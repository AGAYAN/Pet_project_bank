package com.example.bank_project.Transactions.model;

import com.example.bank_project.Person.model.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_from")
    private UserEntity personFrom;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_to")
    private UserEntity personTo;
    private Long amount;
}
