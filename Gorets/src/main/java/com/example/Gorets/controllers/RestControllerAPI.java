package com.example.Gorets.controllers;

import com.example.Gorets.models.Product;
import com.example.Gorets.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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

    @GetMapping(value = "/{id}")
    public Product getProductById(@PathVariable long id){
        return productService.findProductById(id);
    }


    /**
     *    PostMapping
     */
    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public Product addNewProduct(@RequestBody Product newProduct){
        if (newProduct.getName() == null || newProduct.getPrice() == 0 || newProduct.getSrc() == null){
            throw new IllegalArgumentException();
        }
        return productService.addNewProduct(newProduct);
    }



    /**
     *    DeleteMapping
     */
    @DeleteMapping(value = "/{id}")
    public String deleteProductById(@PathVariable Long id){
        if (id == null){
            throw new IllegalArgumentException();
        }
        productService.deleteProductById(id);
        return "OK";
    }

    @DeleteMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public String deleteAllProducts(){
        return productService.deleteAllProducts();
    }

}
