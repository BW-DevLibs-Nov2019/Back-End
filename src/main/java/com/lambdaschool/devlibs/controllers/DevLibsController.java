package com.lambdaschool.devlibs.controllers;

import com.lambdaschool.devlibs.handlers.RestExceptionHandler;
import com.lambdaschool.devlibs.logging.Loggable;
import com.lambdaschool.devlibs.models.DevLib;
import com.lambdaschool.devlibs.models.User;
import com.lambdaschool.devlibs.services.DevLibService;
import com.lambdaschool.devlibs.services.UserService;
import io.swagger.annotations.Api;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
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

    //Get listAllDevLibs https://dev-libs-bw.herokuapp.com/devlibs/alldevlibsforuser
    @GetMapping(value = "/alldevlibsforuser",produces = {"application/json"})
    public ResponseEntity<?> listAllDevLibs(
            Authentication authentication,HttpServletRequest request) {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");
        User user = userService.findByName(authentication.name());
        List<DevLib> myDevLibs = user.getDevLibs();
        return new ResponseEntity<>(myDevLibs, HttpStatus.OK);
    }

    //Find DevLibsByUserName Get https://dev-libs-bw.herokuapp.com/devlibs/devlib/{username}
            @GetMapping(value = "/devlib/{username}",
            produces = {"application/json"})
    public ResponseEntity<?> findDevLibsByUserName(HttpServletRequest request,
                                                   @PathVariable
                                                 String username)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<DevLib> devLibs = devLibService.findDevLibsByUserName(username);
        return new ResponseEntity<>(devLibs,
                HttpStatus.OK);
    }
    //Post addNewDevLib https://dev-libs-bw.herokuapp.com/devlibs/create
    @PostMapping(value = "/create", consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewDevLib(HttpServletRequest request, @Valid @RequestBody DevLib newDevLib, Authentication authentication)throws URISyntaxException{
       // logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");
        User user = userService.findByName(authentication.name());
        newDevLib.setUser(user);
        newDevLib = devLibService.save(newDevLib);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newDevLibURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{devlibid}")
                .buildAndExpand(newDevLib.getDevlibid())
                .toUri();
        responseHeaders.setLocation(newDevLibURI);
        return new ResponseEntity<>("Added new Dev Lib", responseHeaders, HttpStatus.CREATED);

    }

    //Put updateDevLib https://dev-libs-bw.herokuapp.com/devlibs/devlib/{devlibid}
    @PutMapping(value = "/devlib/{devlibid}")
    public ResponseEntity<?> updateDevLib(HttpServletRequest request, @RequestBody DevLib updateDevLib,
                                          @PathVariable long devlibid) {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");
        devLibService.update(updateDevLib, devlibid);
        return new ResponseEntity<>("Updated dev libs", HttpStatus.OK);
    }



    //Delete deleteDevLibById https://dev-libs-bw.herokuapp.com/devlibs/devlib/{devlibid}
    @DeleteMapping(value = "/devlib/{devlibid}",
            produces = {"application/json"})
    public ResponseEntity<?> deleteDevLibById(HttpServletRequest request,
                                              @PathVariable
                                                      Long devlibid)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

       devLibService.deleteDevLibById(devlibid);
        return new ResponseEntity<>("Deleted",
                HttpStatus.OK);
    }




}
