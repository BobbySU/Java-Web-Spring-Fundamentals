package com.example.Mobile.models.dto;

import com.example.Mobile.models.entity.Model;
import com.example.Mobile.models.entity.User;
import com.example.Mobile.models.entity.enums.Engine;
import com.example.Mobile.models.entity.enums.Transmission;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OfferDTO extends BaseEntityDTO{

    private String description;
    private Engine engine;
    private String imageUrl;
    private String mileage;
    private BigDecimal price;
    private Transmission transmission;
    private Integer year;
    private LocalDate created;
    private LocalDate modified;
    private Model model;
    private User seller;
}
