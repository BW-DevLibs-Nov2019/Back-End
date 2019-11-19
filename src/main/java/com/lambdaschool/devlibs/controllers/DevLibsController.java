package com.lambdaschool.devlibs.controllers;

import com.lambdaschool.devlibs.handlers.RestExceptionHandler;
import com.lambdaschool.devlibs.logging.Loggable;
import com.lambdaschool.devlibs.models.DevLib;
import com.lambdaschool.devlibs.services.DevLibService;
import com.lambdaschool.devlibs.services.UserService;
import io.swagger.annotations.Api;
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

    @GetMapping(value = "/devlibs", produces = {"application/json"})
    public ResponseEntity<?> listAllDevLibs(HttpServletRequest request) {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");
        List<DevLib>allDevLibs = devLibService.listAllDevLibs();
        return new ResponseEntity<>(allDevLibs, HttpStatus.OK);
    }



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

    @GetMapping(value = "/devlib", consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewDevLib(HttpServletRequest request, @Valid @RequestBody DevLib newDevLib)throws URISyntaxException{
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");
        newDevLib = devLibService.save(newDevLib);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newProjectURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/devlibs")
                .buildAndExpand(newDevLib.getDevlibid())
                .toUri();
        responseHeaders.setLocation(newProjectURI);
        return new ResponseEntity<>("Added new Dev Lib", responseHeaders, HttpStatus.CREATED);

    }

    @PutMapping(value = "/devlib/{devlibid}")
    public ResponseEntity<?> updateDevLib(HttpServletRequest request, @RequestBody DevLib updateDevLib,
                                          @PathVariable long devlibid) {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");
        devLibService.update(updateDevLib, devlibid);
        return new ResponseEntity<>("Updated dev libs", HttpStatus.OK);
    }



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



    @DeleteMapping(value = "/devlib/{id}",
            produces = {"application/json"})
    public ResponseEntity<?> deleteDevLibByTitle(HttpServletRequest request,
                                              @PathVariable
                                                         Long id)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        devLibService.deleteDevLibById(id);
        return new ResponseEntity<>("Deleted",
                HttpStatus.OK);
    }



}
