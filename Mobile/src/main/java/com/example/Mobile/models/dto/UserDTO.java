package com.example.Mobile.models.dto;

import com.example.Mobile.models.entity.UserRole;

import java.time.LocalDate;

public class UserDTO extends BaseEntityDTO{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private UserRole role;
    private String imageUrl;
    private LocalDate created;
    private LocalDate modified;

}
