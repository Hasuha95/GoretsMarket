package com.example.Gorets.services;

import com.example.Gorets.models.Cart;
import com.example.Gorets.models.Product;
import com.example.Gorets.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CartRepoService {

    @Autowired
    private CartRepository cartRepo;

    public List<Product> getProductsFromCartWithIdOne(long one){
        Cart cart = cartRepo.findById(one).orElseThrow(() -> new NoSuchElementException("Cart not found by Id: " + one));
        return cart.getProducts();
    }

    public Cart addNewProductInCardWithIdOne(Product newProduct){
        long one = 1;
        Cart cart = cartRepo.findById(one).orElseThrow(() -> new NoSuchElementException("Cart not found by Id: " + one));
        cart.getProducts().add(newProduct);
        return cart;
    }


    public Cart createNewCart(Cart cart){
        return cartRepo.save(cart);
    }
}
