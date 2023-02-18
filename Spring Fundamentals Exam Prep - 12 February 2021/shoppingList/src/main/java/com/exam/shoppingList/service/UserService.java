package com.exam.shoppingList.service;

import com.exam.shoppingList.models.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel findByUserAndPassword(String username, String password);
}
