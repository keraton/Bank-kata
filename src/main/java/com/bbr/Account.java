package com.bbr;

import java.time.Instant;

public class Account {

    final AmountRepository depositRepository = new AmountRepository();
    final AmountRepository withdrawalRepository = new AmountRepository();

    public Account deposit(Amount amount) {
        this.depositRepository.add(new Amount(amount));
        return this;
    }

    public Account withdrawal(Amount amount) {
        this.withdrawalRepository.add(new Amount(amount));
        return this;
    }

    public void send(Account account, Amount amount) {
        this.withdrawal(new Amount(amount));
        account.deposit(new Amount(amount));
    }

    public Amount consultLastDeposit() {
        return depositRepository.peek();
    }

    public Amount consultLastWithdrawal() {
        return withdrawalRepository.peek();
    }

    public Amount consultLastStatement() {
        if (depositRepository.isAfter(withdrawalRepository))
            return depositRepository.peek();
        return withdrawalRepository.peek();
    }

    public Amount consultLastBalance() {
        return depositRepository.minus(withdrawalRepository);
    }

    public Instant consultLastHistory() {
        if (depositRepository.isAfter(withdrawalRepository))
            return depositRepository.getLastHistory();
        return withdrawalRepository.getLastHistory();
    }
}
