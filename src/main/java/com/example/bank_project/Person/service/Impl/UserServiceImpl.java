package com.example.bank_project.Person.service.Impl;

import com.example.bank_project.Person.dto.UserDto;
import com.example.bank_project.Person.mapper.UserMapper;
import com.example.bank_project.Person.model.UserEntity;
import com.example.bank_project.Person.service.UserService;
import com.example.bank_project.Person.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = UserMapper.userEntity(userDto);

        UserEntity savedUser = userRepository.save(userEntity);

        return UserMapper.userDto(savedUser);
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }
}
