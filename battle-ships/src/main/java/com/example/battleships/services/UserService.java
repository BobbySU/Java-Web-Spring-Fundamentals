package com.example.battleships.services;

import com.example.battleships.models.dto.UserDTO;
import com.example.battleships.models.entity.User;
import com.example.battleships.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserDTO findByUsername(String username){
        return this.modelMapper.map(this.userRepository.findByUsername(username).orElse(new User()), UserDTO.class);
    }
}
