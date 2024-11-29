package com.example.bank_project.Person.dto;

import lombok.Data;


@Data
public class UserDto {
    private String name;
    private String email;
    private String number;
    private Long balance;
}
