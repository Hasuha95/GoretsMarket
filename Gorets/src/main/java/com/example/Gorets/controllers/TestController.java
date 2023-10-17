package com.example.Gorets.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "")
    public String testPage(){
        return "test/test.html";
    }
    //    js-guitar-shop-10-catalog-ajax/index.html

    @GetMapping(value = "/second_page")
    public String testPage2(){
        return "simple/test_second.html";
    }
}
