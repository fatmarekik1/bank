
package com.skypay.banking.service;

import com.skypay.banking.dto.Transaction;
import com.skypay.banking.exception.InsufficientBalanceException;
import com.skypay.banking.exception.InvalidAmountException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private List<Transaction> transactions = new ArrayList<>();
    private int balance = 0;

    @Override
    public void deposit(int amount, LocalDate date) {
        validateAmount(amount);
        validateDate(date);
        balance += amount;
        transactions.add(new Transaction(date, amount, balance));
    }

    @Override
    public void withdraw(int amount, LocalDate date) {
        validateAmount(amount);
        validateDate(date);
        if (amount > balance) {
            throw new InsufficientBalanceException();
        }
        balance -= amount;
        transactions.add(new Transaction(date, -amount, balance));
    }

    @Override
    public String printStatement() {
        StringBuilder sb = new StringBuilder("DATE       || AMOUNT     || BALANCE\n");
        for (int i = transactions.size() - 1; i >= 0; i--) {
            sb.append(transactions.get(i).date()).append(" || ")
              .append(String.format("%-10d", transactions.get(i).amount())).append(" || ")
              .append(transactions.get(i).balance()).append("\n");
        }
        return sb.toString();
    }

    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException();
        }
    }
    private void validateDate(LocalDate date) {
        if (date == null || date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid date");
        }
    }
}
