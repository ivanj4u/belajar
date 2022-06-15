package com.aribanilia.belajar.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SiswaHelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public String helloWorld(){
        return "hello world";
    }
}
