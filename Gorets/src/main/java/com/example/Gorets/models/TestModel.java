package com.example.Gorets.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TestModel")
public class TestModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    private String name;
}
