package com.example.hw13_q2.Controller;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Account {
    private int deposit;
    private int withdraw;

    public int getDeposit() {
        return deposit;
    }

    public int getWithdraw() {
        return withdraw;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public void setWithdraw(int withdraw) {
        this.withdraw = withdraw;
    }
}
