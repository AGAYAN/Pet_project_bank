package com.example.bank_project.Transactions.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionsDto {
    private String senderPhone;
    private String receivePhone;
    private Long amount;
}
