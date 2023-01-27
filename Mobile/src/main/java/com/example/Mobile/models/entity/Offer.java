package com.example.Mobile.models.entity;

import com.example.Mobile.models.entity.enums.Engine;
import com.example.Mobile.models.entity.enums.Transmission;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String description;  // – some text.
    @Enumerated(EnumType.STRING)
    private Engine engine;  // – enumerated value (GASOLINE, DIESEL, ELECTRIC, HYBRID).
    @Column
    private String imageUrl;  // – the url of image.
    @Column
    private String mileage;  // – a number.
    @Column
    private BigDecimal price;  // – the price of the offer.
    @Enumerated(EnumType.STRING)
    private Transmission transmission;  // – enumerated value (MANUAL, AUTOMATIC).
    @Column
    private Integer year;  // – the year of offered car.
    @Column
    private LocalDate created;  // – a date and time.
    @Column
    private LocalDate modified;  // – a date and time.

    private Model model;  // – the model of a car.

    private User seller;  // – a user that sells the car.

    public Offer() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @ManyToOne
    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}

