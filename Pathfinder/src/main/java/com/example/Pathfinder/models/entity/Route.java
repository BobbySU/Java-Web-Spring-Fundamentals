package com.example.Pathfinder.models.entity;

import com.example.Pathfinder.models.entity.enums.Level;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{

    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "LONGTEXT", length = 3000)
    private String gpx_coordinates; // - Accepts very long text values
    @Enumerated(EnumType.STRING)
    private Level level; // - Accepts the levels of the routes (BEGINNER, INTERMEDIATE, ADVANCED) as values
    @Column
    private String name ; //- Accepts String values
    private User author; // - Accepts User Entities as values
    @Column
    private String video_url; // – Accepts the ids of youtube videos as values
    private Set<Comments> comments;
    private Set<Pictures> pictures;
    private Set<Categories> categories;

    public Route() {
    }

    public String getDescription() {
        return description;
    }

    public Route setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGpx_coordinates() {
        return gpx_coordinates;
    }

    public Route setGpx_coordinates(String gpx_coordinates) {
        this.gpx_coordinates = gpx_coordinates;
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

    @ManyToOne
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

    @OneToMany(targetEntity = Comments.class,
            mappedBy = "route",
            cascade = {CascadeType.MERGE, CascadeType.DETACH})
    public Set<Comments> getComments() {
        return comments;
    }

    public Route setComments(Set<Comments> comments) {
        this.comments = comments;
        return this;
    }

    @OneToMany(targetEntity = Pictures.class,
            mappedBy = "route",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE})
    public Set<Pictures> getPictures() {
        return pictures;
    }

    public Route setPictures(Set<Pictures> pictures) {
        this.pictures = pictures;
        return this;
    }

    @ManyToMany
    public Set<Categories> getCategories() {
        return categories;
    }

    public Route setCategories(Set<Categories> categories) {
        this.categories = categories;
        return this;
    }
}
