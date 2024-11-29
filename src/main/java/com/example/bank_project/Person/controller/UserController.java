package com.example.bank_project.Person.controller;

import com.example.bank_project.Person.dto.UserDto;
import com.example.bank_project.Person.model.UserEntity;
import com.example.bank_project.Person.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public List<UserEntity> getAll() {
        return userService.getAll();
    }
}
