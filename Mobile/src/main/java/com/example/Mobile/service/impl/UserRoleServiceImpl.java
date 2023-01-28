package com.example.Mobile.service.impl;

import com.example.Mobile.repository.UserRoleRepository;
import com.example.Mobile.service.DataBaseInitService;
import com.example.Mobile.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService, DataBaseInitService {
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInit() {
        return this.userRoleRepository.count()>0;
    }
}
