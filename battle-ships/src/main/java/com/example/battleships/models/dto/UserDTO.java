package com.example.battleships.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDTO {
        private String id;
        private String username;
        private String password;
        private String fullName;
        private String email;
}
