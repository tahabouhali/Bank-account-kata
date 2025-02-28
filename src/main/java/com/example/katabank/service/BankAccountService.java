package com.example.katabank.service;

import com.example.katabank.model.BankAccount;
import com.example.katabank.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankAccountService {
    private final BankAccount bankAccount;

    public void deposit(double amount) {
        bankAccount.deposit(amount);
    }

    public void withdraw(double amount) {
        bankAccount.withdraw(amount);
    }

    public double getBalance() {
        return bankAccount.getBalance();
    }

    public List<Transaction> getTransactionHistory() {
        return bankAccount.getTransactions();
    }
}
