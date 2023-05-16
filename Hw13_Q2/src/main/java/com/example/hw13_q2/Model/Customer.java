package com.example.hw13_q2.Model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Customer {
    private String id;
    private String username;
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
