package com.example.Mobile.models.dto;

import java.time.LocalDate;

public class BrandDTO extends BaseEntityDTO{
    private String name;
    private LocalDate created;
    private LocalDate modified;

    public BrandDTO() {
    }

    public String getName() {
        return name;
    }

    public BrandDTO setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public BrandDTO setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public LocalDate getModified() {
        return modified;
    }

    public BrandDTO setModified(LocalDate modified) {
        this.modified = modified;
        return this;
    }
}
