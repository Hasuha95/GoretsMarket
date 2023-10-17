package com.example.Gorets.controllers;

import com.example.Gorets.models.TestProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "")
public class MainController {

    /**
     * Main block
     */
    @GetMapping(value = "")
    public String mainPage(){
        return "my_templates/mainHTML/main_page.html";
    }

    @GetMapping(value = "/prod")
    public String productsPage(Model model){
        return "my_templates/mainHTML/products_page.html";
    }


    @GetMapping(value = "/productDescription")
    public String productDescription(){
        return "mainHTML/product_description.html";
    }


    /**
     * Block of authentication
     */

    @GetMapping(value = "/administration")
    public String administrationPage(){
        return "mainHTML/administration_page.html";
    }

}
