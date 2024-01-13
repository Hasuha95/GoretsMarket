package com.example.Gorets.repository;

import com.example.Gorets.models.Cart;
import com.example.Gorets.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

}
