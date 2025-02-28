package com.example.katabank.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class BankAccount {
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance = balance + amount;
        transactions.add(new Transaction(LocalDateTime.now(), amount, balance, TransactionType.DEPOSIT));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance = balance - amount;
        transactions.add(new Transaction(LocalDateTime.now(), amount, balance, TransactionType.WITHDRAWAL));
    }
}
