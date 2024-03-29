package com.example.Gorets.services;

import com.example.Gorets.controllers.CartRestController;
import com.example.Gorets.models.Cart;
import com.example.Gorets.models.Product;
import com.example.Gorets.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CartRepoService {
    private Logger logger = Logger.getLogger(CartRestController.class.getName());

    @Autowired
    private CartRepository cartRepo;

    public List<Product> getProductsFromCartWithIdOne(long one){
        Cart cart = cartRepo.findById(one).orElseThrow(() -> new NoSuchElementException("Cart not found by Id: " + one));
        return cart.getProducts();
    }

    public Cart addNewProductInCartWithIdOne(Product newProduct){
        long one = 1;
        Cart cart = cartRepo.findById(one).orElseThrow(() -> new NoSuchElementException("Cart not found by Id: " + one));
        cart.getProducts().add(newProduct);
        cartRepo.save(cart);
        return cart;
    }

    public boolean finedProductByIdFromCart(long id){
        long one = 1;
        Cart cart = cartRepo.findById(one).orElseThrow(() -> new NoSuchElementException("Cart not found by Id: " + one));
        for (Product p : cart.getProducts()) {
            if (p.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Cart createNewCart(Cart cart){
        return cartRepo.save(cart);
    }


    public Cart deleteProductFromCartWithIdOne(Product product){
        long one = 1;
        Cart cart = cartRepo.findById(one).orElseThrow(() -> new NoSuchElementException("Cart not found by Id: " + one));
        cart.getProducts().remove(product);
        cartRepo.save(cart);
        return cart;
    }
}
