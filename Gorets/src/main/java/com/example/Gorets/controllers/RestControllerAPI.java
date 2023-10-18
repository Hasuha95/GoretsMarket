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
    private ProductService service = new ProductService();

    @GetMapping
    public List<Product> getListOfProducts(){
//        Product product1 = new Product();
//        product1.setName("product1");
//        product1.setPrice(123);
//        product1.setSrc("https://i.ibb.co/pKrG5ZJ/2.jpg");
//
//        Product product2 = new Product();
//        product2.setName("product2");
//        product2.setPrice(123);
//        product2.setSrc("https://i.ibb.co/pKrG5ZJ/2.jpg");
//
//        Product product3 = new Product();
//        product3.setName("product3");
//        product3.setPrice(123);
//        product3.setSrc("https://i.ibb.co/pKrG5ZJ/2.jpg");
//
//        service.addNewProduct(product1);
//        service.addNewProduct(product2);
//        service.addNewProduct(product3);

        return service.getAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product addNewProduct(@RequestBody Product newProduct){
        System.out.println("PosrtMapping is done");
        return service.addNewProduct(newProduct);
    }

}
