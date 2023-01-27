package com.example.Mobile.models.entity;

import com.example.Mobile.models.entity.enums.Category;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {

    @Column
    private String name; // – a model name.
    @Enumerated(EnumType.STRING)
    private Category category; // – an enumeration (Car, Buss, Truck, Motorcycle)
    @Column
    private String imageUrl; // – the url of image with size between 8 and 512 characters.
    @Column
    private Integer startYear; // – a number.
    @Column
    private Integer endYear; // – a number.
    @Column
    private LocalDate created; // – a date and time.
    @Column
    private LocalDate modified; // – a date and time.

    private Brand brand; // – a model brand.

    public Model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }

    @ManyToOne
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}