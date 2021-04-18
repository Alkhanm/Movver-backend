package com.github.alkhanm.movver.resources.controller;

import com.github.alkhanm.movver.domain.entities.User;
import com.github.alkhanm.movver.services.UserService;

public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    private User findByUsernameOrPhoneNumber(){
        return null;
    }

    private User save(){
        return null;
    }

    private User update(){
        return null;
    }

    private User replace(){
        return null;
    }

    private boolean delete(){
        return false;
    }
}
