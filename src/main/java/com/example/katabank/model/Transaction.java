package com.example.katabank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class Transaction {
    private LocalDateTime date;
    private double amount;
    private double balance;
    private TransactionType type;
}
