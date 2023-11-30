package com.example.battleships.validation.checkShipExistence;

import com.example.battleships.repository.ShipRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ShipExistenceValidator implements ConstraintValidator<ValidateExistenceShip, String> {
    private final ShipRepository shipRepository;

    @Autowired
    public ShipExistenceValidator(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @Override
    public void initialize(ValidateExistenceShip constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String shipName, ConstraintValidatorContext constraintValidatorContext) {
        return this.shipRepository.findByName(shipName).isEmpty();
    }
}

