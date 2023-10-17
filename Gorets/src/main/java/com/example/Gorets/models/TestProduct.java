package com.example.Gorets.models;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "testProducts")
public class TestProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "img")
    private String img;

}
