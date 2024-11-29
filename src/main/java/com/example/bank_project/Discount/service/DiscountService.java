package com.example.bank_project.Discount.service;

import com.example.bank_project.Person.model.UserEntity;

public interface DiscountService {
    UserEntity discountOnTheAmount(String number);

}
