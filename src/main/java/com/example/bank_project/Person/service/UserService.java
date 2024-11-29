package com.example.bank_project.Person.service;

import com.example.bank_project.Person.dto.UserDto;
import com.example.bank_project.Person.model.UserEntity;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    List<UserEntity> getAll();
}
