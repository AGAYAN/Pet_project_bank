package com.example.bank_project.Transactions.repository;

import com.example.bank_project.Person.model.UserEntity;
import com.example.bank_project.Transactions.model.TransactionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionsRepository extends JpaRepository<TransactionsEntity, Long> {
    List<TransactionsEntity> findAllByPersonTo(UserEntity user);
}
