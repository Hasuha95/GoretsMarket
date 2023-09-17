package com.example.Gorets.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "buyers")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @OneToMany
    @JoinTable(name = "buyers_products")
    private List<Product> products = new ArrayList<>();

    public Buyer(String name) {
        this.name = name;
    }

    public Buyer() {
    }
}
