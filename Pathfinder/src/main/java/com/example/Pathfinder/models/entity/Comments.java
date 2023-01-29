package com.example.Pathfinder.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "comments")
public class Comments extends BaseEntity{

    @Column
    private Boolean approved; //- Accepts boolean values
    @Column
    private LocalDate created; //- Accepts Date and Time values The values should not be future dates
    @Column(columnDefinition = "TEXT", name = "text_content")
    private String text; //- Accepts very long text values+
    private User author; //- Accepts User Entities as values
    private Route route; //- Accepts Route Entities as value

    public Comments() {
    }

    public Boolean getApproved() {
        return approved;
    }

    public Comments setApproved(Boolean approved) {
        this.approved = approved;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public Comments setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public String getText() {
        return text;
    }

    public Comments setText(String text) {
        this.text = text;
        return this;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public Comments setAuthor(User author) {
        this.author = author;
        return this;
    }

    @ManyToOne
    public Route getRoute() {
        return route;
    }

    public Comments setRoute(Route route) {
        this.route = route;
        return this;
    }
}
