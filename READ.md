# Katabank - REST API

Katabank is a simple banking API built with **Spring Boot** for managing bank accounts. It supports basic operations
like deposits, withdrawals, and transaction history retrieval.

## Features

- Deposit money into an account
- Withdraw money from an account
- Check account balance
- View transaction history

## API Endpoints

- Deposit: POST /api/banks/accounts/deposit?amount=<amount>
- Withdraw: POST /api/banks/accounts/withdraw?amount=<amount>
- Balance: GET /api/banks/accounts/balance
- Transactions: GET /api/banks/accounts/transactions
