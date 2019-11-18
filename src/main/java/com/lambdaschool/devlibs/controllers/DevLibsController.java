package com.lambdaschool.devlibs.controllers;

import com.lambdaschool.devlibs.handlers.RestExceptionHandler;
import com.lambdaschool.devlibs.logging.Loggable;
import com.lambdaschool.devlibs.services.DevLibService;
import com.lambdaschool.devlibs.services.UserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devlibs")
@Loggable
@Api(tags = {"DevLibsEndpoints"})
public class DevLibsController {

    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

   /* @Autowired
    private DevLibService devLibService;*/
}
