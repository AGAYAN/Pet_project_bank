package com.example.bank_project.Transactions.service;

import com.example.bank_project.Transactions.dto.TransactionsDto;
import com.example.bank_project.Transactions.dto.TransactionsInfoDTO;
import java.util.List;

public interface TransactionsService {
    TransactionsDto Transactions(TransactionsDto transactionsDto);
    List<TransactionsInfoDTO> getUserTransactionsHistory(String number);
}
