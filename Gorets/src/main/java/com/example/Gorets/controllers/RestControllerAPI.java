package com.example.Gorets.controllers;

import com.example.Gorets.models.Product;
import com.example.Gorets.services.ProductService;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/v1/test")
public class RestControllerAPI {
    private Logger logger = Logger.getLogger(CartRestController.class.getName());

    @Autowired
    private ProductService productService;

    /**
     *    GetMapping
     */
    @GetMapping
    public List<Product> getListOfProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(value = "/name/{name}")
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
    @ResponseStatus(HttpStatus.CREATED)
    public Product addNewProduct(@RequestBody Product newProduct){
        if (newProduct.getName() == null || newProduct.getPrice() == 0 || newProduct.getSrc() == null){
            throw new IllegalArgumentException();
        }
        return productService.addNewProduct(newProduct);
    }



    /**
     *    DeleteMapping
     */
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public String deleteProduct(@RequestBody Product product){
        if (product == null){
            throw new IllegalArgumentException();
        }
        return productService.deleteProduct(product);
    }

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
