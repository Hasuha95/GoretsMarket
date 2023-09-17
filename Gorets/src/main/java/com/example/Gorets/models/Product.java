package com.example.Gorets.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "cost")
    private int cost;

    @Column(name = "title")
    private String title;

    public Product(int cost, String title) {
        this.cost = cost;
        this.title = title;
    }

    public Product() {
    }
}
