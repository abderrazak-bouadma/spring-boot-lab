package org.abder.controller;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: Abderrazak BOUADMA
 * Date: 4/21/15
 * Time: 10:59 AM
 */

@RestController
public class HelloController {


    public static final Logger logger = Logger.getLogger(HelloController.class.getName());

    @RequestMapping(value = "/hello/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sayHello(@PathVariable String name) {
        logger.info("Logging the name {}" + name);
        return "Hello there " + name + " !";
    }
}
