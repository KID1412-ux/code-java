package com.guigu.code.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Test")
public class TestController {

    @RequestMapping("test1")
    @CrossOrigin
    public String test1(){
        return "index";
    }

}
