package com.example.bank_project.Transactions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionsInfoDTO {
    private String senderPhoneNumber;
    private Long amount;
}
