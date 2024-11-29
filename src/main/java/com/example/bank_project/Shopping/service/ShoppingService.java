package com.example.bank_project.Shopping.service;

import com.example.bank_project.Person.model.UserEntity;
import com.example.bank_project.Shopping.dto.ShoppingDto;

public interface ShoppingService {
    UserEntity buyThing(ShoppingDto shoppingDto);
}
