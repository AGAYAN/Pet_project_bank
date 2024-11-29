package com.example.bank_project.Transactions.service.Impl;

import com.example.bank_project.Person.model.UserEntity;
import com.example.bank_project.Person.repository.UserRepository;
import com.example.bank_project.Transactions.dto.TransactionsDto;
import com.example.bank_project.Transactions.dto.TransactionsInfoDTO;
import com.example.bank_project.Transactions.model.TransactionsEntity;
import com.example.bank_project.Transactions.repository.TransactionsRepository;
import com.example.bank_project.Transactions.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionsServiceImpl implements TransactionsService {
    private final UserRepository userRepository;
    private final TransactionsRepository transactionsRepository;

    @Override
    public TransactionsDto Transactions(TransactionsDto transactionsDto) {
        UserEntity person_from = userRepository.findByNumber(transactionsDto.getSenderPhone())
                .orElseThrow(() -> new RuntimeException("Отправитель не найден"));

        UserEntity person_to = userRepository.findByNumber(transactionsDto.getReceivePhone())
                .orElseThrow(() -> new RuntimeException("Получатель не найден"));

        if(person_from.getBalance() < transactionsDto.getAmount()) {
            throw new RuntimeException("Не хватает средств");
        }

        person_from.setBalance(person_from.getBalance() - transactionsDto.getAmount());
        person_to.setBalance(person_to.getBalance() + transactionsDto.getAmount());

        userRepository.save(person_from);
        userRepository.save(person_to);

        TransactionsEntity transactions = new TransactionsEntity();
        transactions.setAmount(transactionsDto.getAmount());
        transactions.setPersonFrom(person_from);
        transactions.setPersonTo(person_to);
        transactionsRepository.save(transactions);
        return transactionsDto;
    }

    @Override
    public List<TransactionsInfoDTO> getUserTransactionsHistory(String number) {
        UserEntity user = userRepository.findByNumber(number)
                .orElseThrow(() -> new RuntimeException("Нету такого user"));

        return transactionsRepository.findAllByPersonTo(user)
                .stream()
                .map(transactionsEntity -> {
                    String senderNumber = userRepository.findById(transactionsEntity.getPersonFrom().getId())
                            .map(UserEntity::getNumber)
                            .orElse("Неизвестный номер");
                    return new TransactionsInfoDTO(senderNumber, transactionsEntity.getAmount());
                })
                .collect(Collectors.toList());
    }

}
