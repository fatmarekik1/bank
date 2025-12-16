
package com.skypay.banking;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.skypay.banking.service.AccountService;
import com.skypay.banking.service.AccountServiceImpl;

class AccountServiceTest {
@Test
    void should_print_expected_statement() {
        AccountService account = new AccountServiceImpl();

        account.deposit(1000, LocalDate.of(2012, 1, 10));
        account.deposit(2000, LocalDate.of(2012, 1, 13));
        account.withdraw(500, LocalDate.of(2012, 1, 14));

        String statement = account.printStatement();

        assertTrue(statement.contains("1000"));
        assertTrue(statement.contains("3000"));
        assertTrue(statement.contains("2500"));
    }
}
