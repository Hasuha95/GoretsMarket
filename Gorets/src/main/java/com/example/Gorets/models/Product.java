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

    @Column(name = "description")
    private String description;

}
