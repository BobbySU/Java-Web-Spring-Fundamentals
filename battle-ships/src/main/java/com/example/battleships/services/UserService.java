package com.example.battleships.services;

import com.example.battleships.models.dto.UserDTO;
import com.example.battleships.models.dto.bilding.UserSeedDTO;
import com.example.battleships.models.entity.User;
import com.example.battleships.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
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
    @PostConstruct
    private void postConstructUser() throws IOException {
        if (userRepository.count() == 0) {
            this.userRepository.saveAndFlush(this.modelMapper.map(UserSeedDTO.builder()
                    .username("bobby")
                    .password("12345")
                    .fullName("Bobbyto")
                    .email("bobby@abv.bg")
                    .build(), User.class));
            this.userRepository.saveAndFlush(this.modelMapper.map(UserSeedDTO.builder()
                    .username("peppy")
                    .password("12345")
                    .fullName("Peppyto")
                    .email("petar@abv.bg")
                    .build(), User.class));
        }
    }
}
