package com.example.Gorets.controllers;

import com.example.Gorets.models.Product;
import com.example.Gorets.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/test")
public class RestControllerAPI {

    @Autowired
    private ProductService productRepoService;

    @GetMapping
    public List<Product> getListOfProducts(){
        return productRepoService.getAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product addNewProduct(@RequestBody Product newProduct){
        return productRepoService.addNewProduct(newProduct);
    }


}
