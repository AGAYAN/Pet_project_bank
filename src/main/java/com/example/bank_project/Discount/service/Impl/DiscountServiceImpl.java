package com.example.bank_project.Discount.service.Impl;

import com.example.bank_project.Discount.service.DiscountService;
import com.example.bank_project.Person.model.UserEntity;
import com.example.bank_project.Person.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final UserRepository userRepository;

    private static final Double CASHBACK_1LVL = 0.01;

    private static final Double CASHBACK_2LVL = 0.0125;


    @Override
    public UserEntity discountOnTheAmount(String number) {
        UserEntity user = userRepository.findByNumber(number)
                .orElseThrow(() -> new RuntimeException("Нету такого user"));

        double userWastes = user.getWastes();
        if (user.getWastes() < 20000) {
            double cashback = userWastes * CASHBACK_2LVL;
            System.out.println(cashback);
        } else if(user.getWastes() > 20000) {
            double cashback = userWastes * CASHBACK_1LVL;
            System.out.println(cashback);
        }
        // Реализация кешбек 1.25;

        return user;
    }

}
