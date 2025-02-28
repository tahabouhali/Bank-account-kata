package com.example.katabank.service;

import com.example.katabank.model.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }

    @Test
    void shouldIncreaseBalanceWhenDeposit() {
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
    }

    @Test
    void shouldDecreaseBalanceWhenWithdraw() {
        account.deposit(1000);
        account.withdraw(200);
        assertEquals(800, account.getBalance());
    }

    @Test
    void shouldThrowExceptionWhenWithdrawMoreThanBalance() {
        account.deposit(500);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(600));
        assertEquals("Insufficient funds.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenDepositNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
        assertEquals("Deposit amount must be positive.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenWithdrawNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50));
        assertEquals("Withdrawal amount must be positive.", exception.getMessage());
    }
}
