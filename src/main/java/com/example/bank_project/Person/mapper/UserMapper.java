package com.example.bank_project.Person.mapper;

import com.example.bank_project.Person.dto.UserDto;
import com.example.bank_project.Person.model.UserEntity;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

   public static UserDto userDto(UserEntity user) {
       UserDto userDto = new UserDto();
       if (user == null) {
           return null;
       }
       userDto.setName(user.getName());
       userDto.setEmail(user.getEmail());
       userDto.setNumber(user.getNumber());
       userDto.setBalance(user.getBalance());
       return userDto;
   }

   public static UserEntity userEntity(UserDto userDto) {
       if (userDto == null) {
           return null;
       }
       UserEntity userEntity = new UserEntity();
       userEntity.setName(userDto.getName());
       userEntity.setEmail(userDto.getEmail());
       userEntity.setNumber(userDto.getNumber());
       userEntity.setBalance(userDto.getBalance());
       return userEntity;
   }
}
