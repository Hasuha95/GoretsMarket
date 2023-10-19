package com.example.Gorets.controllers;

import com.example.Gorets.models.Product;
import com.example.Gorets.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/test")
public class RestControllerAPI {

    @Autowired
    private ProductService productService;


    /**
     *    GetMapping
     */
    @GetMapping
    public List<Product> getListOfProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(value = "/{name}")
    public List<Product> getProductByName(@PathVariable String name){
        return productService.findProductByName(name);
    }


    /**
     *    PostMapping
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product addNewProduct(@RequestBody Product newProduct){
        return productService.addNewProduct(newProduct);
    }



    /**
     *    DeleteMapping
     */
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public String deleteProduct(@RequestBody Product product){
        return productService.deleteProduct(product);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return "OK";
    }

    @DeleteMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public String deleteAllProducts(){
        return productService.deleteAllProducts();
    }




}
