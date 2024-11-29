package com.example.bank_project.Transactions.controller;

import com.example.bank_project.Transactions.dto.TransactionsInfoDTO;
import com.example.bank_project.Transactions.model.TransactionsEntity;
import com.example.bank_project.Transactions.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/discount")
public class TransactionsDiscountController {
    private final TransactionsService transactionsService;

    @GetMapping("/{number}")
    public TransactionsEntity getUserNumber(@PathVariable String number) {
        return transactionsService.discountOnTheAmount(number);
    }
}
