package com.example.Gorets.repository;

import com.example.SprinDataJpa.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
