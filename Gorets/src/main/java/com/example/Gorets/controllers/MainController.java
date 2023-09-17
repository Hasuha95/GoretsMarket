package com.example.Gorets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "")
public class MainController {

    /**
     * Main block
     */
    @GetMapping(value = "")
    public String mainPage(){
        return "mainHTML/main_page.html";
    }

    @GetMapping(value = "/products")
    public String productsPage(){
        return "mainHTML/products_page.html";
    }



    /**
     * Block of autentication
     */

}
