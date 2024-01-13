package com.example.Gorets.repository;

import com.example.Gorets.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CrudRepository<Product, Long> {

}
