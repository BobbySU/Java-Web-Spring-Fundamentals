package com.example.Mobile.service.impl;

import com.example.Mobile.service.DataBaseInitService;
import org.springframework.stereotype.Service;

@Service
public class DataBaseInitServiceImpl implements DataBaseInitService {
    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInit() {
        return false;
    }
}
