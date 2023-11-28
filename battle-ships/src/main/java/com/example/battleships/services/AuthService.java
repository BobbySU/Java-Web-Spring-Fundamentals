package com.example.battleships.services;

import com.example.battleships.models.dto.LoggedUser;
import com.example.battleships.models.dto.UserLoginDTO;
import com.example.battleships.models.dto.UserRegisterDTO;
import com.example.battleships.models.entity.User;
import com.example.battleships.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    @Autowired
    public AuthService(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    public void registerUser(UserRegisterDTO userRegisterDTO){
        User user = this.userRepository.saveAndFlush(this.modelMapper.map(userRegisterDTO, User.class));
//        loggedUser.setId(user.getId());
    }

    public void loginUser(UserLoginDTO userLoginDTO){
       User user = this.userRepository.findByUsername(userLoginDTO.getUsername()).get();
       this.loggedUser.setId(user.getId());
    }

    public void logoutUser(){
        loggedUser.clearUser();
    }
}

