package com.example.bank_project.Transactions.controller;


import com.example.bank_project.Person.model.UserEntity;
import com.example.bank_project.Transactions.dto.TransactionsDto;
import com.example.bank_project.Transactions.dto.TransactionsInfoDTO;
import com.example.bank_project.Transactions.model.TransactionsEntity;
import com.example.bank_project.Transactions.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transactions")
public class TransactionsController {
    private final TransactionsService transactionsService;

    @PostMapping
    public ResponseEntity<TransactionsDto> transactionsDtoResponseEntity(@RequestBody TransactionsDto transactionsDto) {
        transactionsService.Transactions(transactionsDto);
        return ResponseEntity.ok(transactionsDto);
    }

    @GetMapping("/{number}")
    public List<TransactionsInfoDTO> getUserNumber(@PathVariable String number) {
        return transactionsService.getUserTransactionsHistory(number);
    }

}
