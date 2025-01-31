package com.example.bank_project.Discount.controller;

import com.example.bank_project.Discount.service.DiscountService;
import com.example.bank_project.Person.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/discount")
public class DiscountController {
    private final DiscountService discountService;

    @GetMapping("/{number}")
    public UserEntity getUserNumber(@PathVariable String number) {
        return discountService.discountOnTheAmount(number);
    }
}
