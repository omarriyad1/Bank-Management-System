package com.example.lib.controller;

import com.example.lib.dto.UserDto;
import com.example.lib.model.User;
import com.example.lib.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api4")
public class userController {
    @Autowired
    userService service;
    @PostMapping("/createUsr")
    @ResponseBody
    public User createUser(@RequestBody UserDto user) {
        return service.createUser(user);
    }
}
