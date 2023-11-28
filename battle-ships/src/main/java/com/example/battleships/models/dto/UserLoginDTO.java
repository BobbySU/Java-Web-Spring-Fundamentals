package com.example.battleships.models.dto;

import com.example.battleships.validation.checkUserExistance.ValidateLoginForm;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@ValidateLoginForm
public class UserLoginDTO {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
