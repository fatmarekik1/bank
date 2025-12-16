
package com.skypay.banking.dto;

import java.time.LocalDate;

public record Transaction(LocalDate date, int amount, int balance) {}
