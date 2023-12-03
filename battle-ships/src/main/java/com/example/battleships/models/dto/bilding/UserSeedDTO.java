package com.example.battleships.models.dto.bilding;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSeedDTO {
    private String username;
    private String password;
    private String fullName;
    private String email;
}
