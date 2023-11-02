package com.example.Gorets.controllers;

import com.example.Gorets.models.Cart;
import com.example.Gorets.models.Product;
import com.example.Gorets.services.CartRepoService;
import com.example.Gorets.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/v1/cart")
public class CartRestController {
    private Logger logger = Logger.getLogger(CartRestController.class.getName());
    @Autowired
    private CartRepoService cartRepoService;

    @GetMapping
    public List<Product> getListOfProductsFromCartWithIdOne(){
        long one = 1;
        return cartRepoService.getProductsFromCartWithIdOne(one);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Cart addNewProductInCardWithIdOne(@RequestBody Product addProduct){
        return cartRepoService.addNewProductInCardWithIdOne(addProduct);
    }

}
