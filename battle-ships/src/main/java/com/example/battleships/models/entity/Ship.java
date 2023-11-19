package com.example.battleships.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "ships")
public class Ship extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;
    //    o	The length of the values must be between 2 and 10 characters (both numbers are INCLUSIVE)
    //    o	The values should be unique in the database
    @Column(nullable = false)
    private Long health;
    //    o	The values should be positive numbers
    @Column(nullable = false)
    private Long power;
    //    o	The values should be positive numbers
    @Column(nullable = false)
    private Date created;
    //    o	The values should not be future dates

    private Category category;
    //    o	A relationship with the Categories Entity

    private User user;
    //    o	A user that owns the ship
    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public Ship setCategory(Category category) {
        this.category = category;
        return this;
    }
    @ManyToOne
    public User getUser() {
        return user;
    }

    public Ship setUser(User user) {
        this.user = user;
        return this;
    }
}
