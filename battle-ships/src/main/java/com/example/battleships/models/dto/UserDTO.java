package com.example.battleships.models.dto;

import lombok.*;

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
