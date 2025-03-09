package com.example.katabank.controller;

import com.example.katabank.model.Transaction;
import com.example.katabank.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banks/accounts")
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestParam double amount) {
        bankAccountService.deposit(amount);
        return ResponseEntity.ok("Deposit successful!");
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestParam double amount) {
        bankAccountService.withdraw(amount);
        return ResponseEntity.ok("Withdrawal successful!");
    }

    @GetMapping("/balance")
    public ResponseEntity<Double> getBalance() {
        return ResponseEntity.ok(bankAccountService.getBalance());
    }

    @GetMapping("/statement")
    public ResponseEntity<List<Transaction>> getStatement() {
        return ResponseEntity.ok(bankAccountService.getTransactionHistory());
    }
}
