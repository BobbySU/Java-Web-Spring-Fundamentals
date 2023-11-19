package com.example.battleships.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false, unique = true)
    private String email;
//    •	Id – Accepts UUID-String or Long values
//•	Username
//    o	The length of the values should be between 3 and 10 characters long (both numbers are INCLUSIVE)
//    o	The values should be unique in the database
//•	Full Name
//    o	The length of the values should be between 5 and 20 characters long (both numbers are INCLUSIVE)
//•	Password
//    o	The length of the values should be more than 3 characters long (INCLUSIVE)
//•	Email
//    o	The values should contain a '@' symbol
//    o	The values should be unique in the database
}
