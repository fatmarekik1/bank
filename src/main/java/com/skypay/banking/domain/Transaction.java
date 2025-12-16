
package com.skypay.banking.domain;

import java.time.LocalDate;

public record Transaction(LocalDate date, int amount, int balance) {}
