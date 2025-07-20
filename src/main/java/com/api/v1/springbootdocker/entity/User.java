// src/main/java/com/example/dockerspringdemo/model/User.java
package com.api.v1.springbootdocker.entity;

import jakarta.persistence.*;

@Entity
@Table(name="springbootdocker_user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}