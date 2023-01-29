package com.example.Pathfinder.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pictures")
public class Pictures extends BaseEntity{

    @Column
    private  String title; //- Accepts String values
    @Column(columnDefinition = "TEXT")
    private  String url; // - Accepts very long String values
    private  User author; // - Accepts User Entities as values
    private  Route route; //- Accepts Route Entities as values

    public Pictures() {
    }

    public String getTitle() {
        return title;
    }

    public Pictures setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Pictures setUrl(String url) {
        this.url = url;
        return this;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public Pictures setAuthor(User author) {
        this.author = author;
        return this;
    }

    @ManyToOne
    public Route getRoute() {
        return route;
    }

    public Pictures setRoute(Route route) {
        this.route = route;
        return this;
    }
}
