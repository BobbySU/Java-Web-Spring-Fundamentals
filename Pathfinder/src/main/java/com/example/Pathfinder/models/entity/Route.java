package com.example.Pathfinder.models.entity;

import com.example.Pathfinder.models.entity.enums.Level;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT", length = 3000)
    private String gpxCoordinates; // - Accepts very long text values

    @Enumerated(EnumType.STRING)
    private Level level; // - Accepts the levels of the routes (BEGINNER, INTERMEDIATE, ADVANCED) as values

    @Column
    private String name ; //- Accepts String values

    @ManyToOne
    private User author; // - Accepts User Entities as values

    @Column
    private String video_url; // – Accepts the ids of youtube videos as values

    @OneToMany(targetEntity = Comment.class,
            mappedBy = "route",
            cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private Set<Comment> comments;

    @OneToMany(targetEntity = Picture.class,
            mappedBy = "route",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE})
    private Set<Picture> pictures;

    @ManyToMany
    private Set<Category> categories;

    public Route() {
    }

    public String getDescription() {
        return description;
    }

    public Route setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public Route setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public Route setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public Route setName(String name) {
        this.name = name;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Route setAuthor(User author) {
        this.author = author;
        return this;
    }

    public String getVideo_url() {
        return video_url;
    }

    public Route setVideo_url(String video_url) {
        this.video_url = video_url;
        return this;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Route setComments(Set<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public Route setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Route setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }
}
