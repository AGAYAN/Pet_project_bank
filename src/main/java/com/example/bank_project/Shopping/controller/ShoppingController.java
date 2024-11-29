package com.example.bank_project.Shopping.controller;

import com.example.bank_project.Person.model.UserEntity;
import com.example.bank_project.Shopping.dto.ShoppingDto;
import com.example.bank_project.Shopping.service.ShoppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping")
@RequiredArgsConstructor
public class ShoppingController {
    private final ShoppingService service;

    @PostMapping
    public UserEntity BuyShopping(@RequestBody ShoppingDto shoppingDto) {
        return service.buyThing(shoppingDto);
    }
}
