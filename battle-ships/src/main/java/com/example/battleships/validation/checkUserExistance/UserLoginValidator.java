package com.example.battleships.validation.checkUserExistance;

import com.example.battleships.models.dto.UserDTO;
import com.example.battleships.models.dto.UserLoginDTO;
import com.example.battleships.models.dto.UserRegisterDTO;
import com.example.battleships.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UserLoginValidator implements ConstraintValidator<ValidateLoginForm, UserLoginDTO> {

    private final UserService userService;

    @Autowired
    public UserLoginValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(ValidateLoginForm constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginDTO userLoginDTO, ConstraintValidatorContext constraintValidatorContext) {
        UserDTO userDTO = this.userService.findByUsername(userLoginDTO.getUsername());
        return userDTO.getId() != null && userDTO.getPassword().equals(userLoginDTO.getPassword());
    }
}
