package com.example.Gorets.controllers;

import com.example.Gorets.models.Cart;
import com.example.Gorets.models.Product;
import com.example.Gorets.services.CartRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cart")
public class CartRestController {

    @Autowired
    private CartRepoService cartRepoService;

    @GetMapping
    public List<Product> getListOfProductsFromCardWithIdOne(){

        long one = 1;
        return cartRepoService.getProductsFromCartWithIdOne(one);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean addNewProductInCardWithIdOne(@RequestBody Product newProduct){
        return cartRepoService.addNewProductInCardWithIdOne(newProduct);
    }
}
