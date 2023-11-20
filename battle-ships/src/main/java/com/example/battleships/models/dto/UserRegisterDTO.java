package com.example.battleships.models.dto;

import com.example.battleships.validation.passwordMatcher.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@PasswordMatch
public class UserRegisterDTO {
    @Size(min = 3, max = 10)
    @NotNull
    @NotBlank
    private String username;

    @Size(min = 3)
    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private String confirmPassword;

    @Size(min = 5, max = 20)
    @NotNull
    @NotBlank
    private String fullName;

    @Email
    @NotNull
    @NotBlank
    private String email;
}
