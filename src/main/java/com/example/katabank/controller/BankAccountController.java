package com.example.katabank.controller;

import com.example.katabank.model.Transaction;
import com.example.katabank.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banks/accounts")
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @PostMapping("/deposit")
    public void deposit(@RequestParam double amount) {
        bankAccountService.deposit(amount);
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestParam double amount) {
        bankAccountService.withdraw(amount);
    }

    @GetMapping("/balance")
    public double getBalance() {
        return bankAccountService.getBalance();
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        return bankAccountService.getTransactionHistory();
    }

    @GetMapping("/statement")
    public List<Transaction> getStatement() {
        return bankAccountService.getTransactionHistory();
    }

}
