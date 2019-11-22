package com.lambdaschool.devlibs.controllers;

import com.lambdaschool.devlibs.handlers.RestExceptionHandler;
import com.lambdaschool.devlibs.logging.Loggable;
import com.lambdaschool.devlibs.models.Answers;
import com.lambdaschool.devlibs.models.DevLib;
import com.lambdaschool.devlibs.models.User;
import com.lambdaschool.devlibs.services.AnswerService;
import com.lambdaschool.devlibs.services.DevLibService;
import com.lambdaschool.devlibs.services.UserService;
import io.swagger.annotations.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/devlibs")
@Loggable
@Api(tags = {"DevLibsEndpoints"})
public class DevLibsController {

    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @Autowired
    private DevLibService devLibService;

    @Autowired
    UserService userService;

    @Autowired
    AnswerService answersService;


    //Get listAllDevLibs https://dev-libs-bw.herokuapp.com/devlibs/alldevlibsforuser
    @ApiOperation(value = "returns all DevLibs",
            response = DevLib.class,
            responseContainer = "List")
    @GetMapping(value = "/alldevlibsforuser", produces = {"application/json"})
    public ResponseEntity<?> listAllDevLibs(
            Authentication authentication) {
        // logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");
        User user = userService.findByName(authentication.getName());
        List<DevLib> myDevLibs = user.getDevlibs();
        for (int i = 0; i < myDevLibs.size(); i++) {
            myDevLibs.get(i).setAnswerstrings(answersService.findAnswersByDevLibId(myDevLibs.get(i).getDevlibid()));
        }
        return new ResponseEntity<>(myDevLibs, HttpStatus.OK);
    }

    //Find DevLibsByUserName Get https://dev-libs-bw.herokuapp.com/devlibs/devlib/{username}
    @ApiOperation(value = "Finds all DevLibs by username",
            response = DevLib.class,
            responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User Found", response = DevLib.class),
            @ApiResponse(code = 404, message = "User NOT Found")
    })
    @GetMapping(value = "/devlib/{username}",
            produces = {"application/json"})
    public ResponseEntity<?> findDevLibsByUserName(@ApiParam(value = "User Name", required = true, example = "Ronnie")
                                                   @PathVariable
                                                           String username) {

        List<DevLib> devLibs = devLibService.findDevLibsByUserName(username);
        return new ResponseEntity<>(devLibs,
                HttpStatus.OK);
    }

    ///////////////////////////////////////////////////////////
    // GET findAnswersByDevLibId https://dev-libs-bw.herokuapp.com/devlibs/devlib/answers/{devlibid}
    @ApiOperation(value = "Finds Answers By DevLib ID",
            response = DevLib.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Found", response = DevLib.class),
            @ApiResponse(code = 404, message = "404")
    })
    @GetMapping(value = "/devlib/answers/{devlibid}",
            produces = {"application/json"})
    public ResponseEntity<?> findAnswersByDevLibId(@ApiParam(value = "Dev Lib Id", required = true, example = "248")
                                                   @PathVariable
                                                           Long devlibid) {

        List<String> answers = answersService.findAnswersByDevLibId(devlibid);
        return new ResponseEntity<>(answers,
                HttpStatus.OK);
    }

    //POST  addNewDevLibAnswers https://dev-libs-bw.herokuapp.com/devlibs/devlib/answers/{devlibid}
    @ApiOperation(value = "Finds Answers By DevLib ID",
            response = DevLib.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Found", response = DevLib.class),
            @ApiResponse(code = 404, message = "404")
    })
    @PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/devlib/answers/{devlibid}")
    public ResponseEntity<?> addNewDevLibAnswers(@Valid
                                                 @RequestBody Answers answers, @PathVariable long devlibid) {


        Answers newAnswer = answersService.save(answers);
        answersService.insertDevLibAnswers(devlibid, newAnswer.getAnswerid());

        return new ResponseEntity<>(HttpStatus.CREATED);


    }

    //POST addNewDevLib https://dev-libs-bw.herokuapp.com/devlibs/create

    @ApiOperation(value = "Adds New DevLib",
            response = DevLib.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Created", response = DevLib.class),
            @ApiResponse(code = 404, message = "404")
    })
    @PostMapping(value = "/create",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewDevLib(@Valid
                                          @RequestBody
                                                  DevLib newDevLib,
                                          org.springframework.security.core.Authentication authentication) throws URISyntaxException {
        User user = userService.findByName(authentication.getName());
        newDevLib = devLibService.save(newDevLib, user);

        newDevLib.setAnswerstrings(answersService.findAnswersByDevLibId(newDevLib.getDevlibid()));

        HttpHeaders responseHeaders = new HttpHeaders();

        URI newDevLibsURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{devlibid}").buildAndExpand(newDevLib.getDevlibid()).toUri();
        responseHeaders.setLocation(newDevLibsURI);

        System.out.println(newDevLib.toString());
        return new ResponseEntity<>(newDevLib, responseHeaders, HttpStatus.CREATED);
    }

    //Put updateDevLib https://dev-libs-bw.herokuapp.com/devlibs/devlib/{devlibid}
    @ApiOperation(value = "Updates DevLib",
            response = DevLib.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Updated", response = DevLib.class),
            @ApiResponse(code = 404, message = "404")
    })
    @PutMapping(value = "/devlib/{devlibid}")
    public ResponseEntity<?> updateDevLib(@RequestBody DevLib updateDevLib, @ApiParam(value = "Dev Lib Id", required = true, example = "248")
    @PathVariable long devlibid) {
        devLibService.update(updateDevLib, devlibid);
        return new ResponseEntity<>("Updated dev libs", HttpStatus.OK);
    }


    //Delete deleteDevLibById https://dev-libs-bw.herokuapp.com/devlibs/devlib/{devlibid}
    @ApiOperation(value = "Deletes DevLib By Id",
            response = DevLib.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deleted", response = DevLib.class),
            @ApiResponse(code = 404, message = "404")
    })
    @DeleteMapping(value = "/devlib/{devlibid}",
            produces = {"application/json"})
    public ResponseEntity<?> deleteDevLibById(@ApiParam(value = "Dev Lib Id", required = true, example = "248")
                                              @PathVariable
                                                      Long devlibid) {

        devLibService.deleteDevLibById(devlibid);
        return new ResponseEntity<>("Deleted",
                HttpStatus.OK);
    }


}
/* BACKUP PLAN
    @PutMapping(value = "/devlib/answers/{answerid}")
    public ResponseEntity<?> updateAnswer(@RequestBody Answers updateAnswers,
                                          @PathVariable long answerid) {
        answersService.update(answerid, updateAnswers);
        return new ResponseEntity<>("Updated Answer", HttpStatus.OK);
    }*/

/*@PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
  @PostMapping(value = "/devlibs/answers/{devlibid}")
  public ResponseEntity<?> addNewDevLibAnswers(@Valid
                                                 @RequestBody Answers answers, @PathVariable long devlibid){


     Answers newAnswer = answersService.save(answers);
     answersService.insertDevLibAnswers(devlibid, newAnswer.getAnswerid());

      return new ResponseEntity<>(HttpStatus.CREATED);



  }*/
