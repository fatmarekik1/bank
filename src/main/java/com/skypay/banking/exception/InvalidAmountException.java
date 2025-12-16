
package com.skypay.banking.exception;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException() {
        super("Amount must be positive");
    }
}
