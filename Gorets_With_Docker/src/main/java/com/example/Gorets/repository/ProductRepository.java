package com.example.Gorets.repository;

import com.example.Gorets.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long>, JpaRepository<Product, Long> {
    List<Product> findByName(String name);

    Product findOneById(long id);
}
