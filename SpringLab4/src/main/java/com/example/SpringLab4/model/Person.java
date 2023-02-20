package com.example.SpringLab4.model;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    public User() {}
}


