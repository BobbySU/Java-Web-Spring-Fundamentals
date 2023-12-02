package com.example.battleships.services;

import com.example.battleships.models.dto.CategoryDTO;
import com.example.battleships.models.dto.UserDTO;
import com.example.battleships.models.entity.Category;
import com.example.battleships.models.entity.User;
import com.example.battleships.models.entity.enums.CategoryType;
import com.example.battleships.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserDTO findByUsername(String username) {
        return this.modelMapper.map(this.userRepository.findByUsername(username).orElse(new User()), UserDTO.class);
    }

    public UserDTO findById(String id) {
        return this.modelMapper.map(this.userRepository.findById(id).orElse(new User()), UserDTO.class);
    }

    public UserDTO findByIdNot(String id) {
        return this.modelMapper.map(this.userRepository.findByIdNot(id).orElse(new User()), UserDTO.class);
    }
}
