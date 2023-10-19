package com.example.Gorets.services;

import com.example.Gorets.models.Product;
import com.example.Gorets.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts(){
        long one = 1;
        return (List<Product>) repository.findAll();
    }

    public Product addNewProduct(Product product){
        return repository.save(product);
    }

    public String deleteProductById(long id){
        repository.deleteById(id);
        return "OK";
    }

    public String deleteProduct(Product product){
        repository.delete(product);
        return "OK";
    }

    public String deleteAllProducts(){
        repository.deleteAll();
        return "OK";
    }

    public List<Product> findProductByName(String name){
        return repository.findByName(name);
    }


}
