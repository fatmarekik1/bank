
package com.skypay.banking.controller;

import com.skypay.banking.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/deposit")
    public void deposit(@RequestParam int amount, @RequestParam LocalDate date) {
        accountService.deposit(amount, date);
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestParam int amount, @RequestParam LocalDate date) {
        accountService.withdraw(amount, date);
    }

    @GetMapping("/statement")
    public String statement() {
        return accountService.printStatement();
    }
}
