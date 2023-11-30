package com.example.battleships.models.dto.bilding;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoggedUser {
    private String id;

    public boolean isEmpty(){
        return this.id == null;
    }

    public void clearUser(){
        this.id = null;
    }
}
