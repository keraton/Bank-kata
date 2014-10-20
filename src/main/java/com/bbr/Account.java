package com.bbr;

import com.bbr.repository.AmountRepository;

public class Account {

    final AmountRepository depositRepository = new AmountRepository();
    final AmountRepository withdrawalRepository = new AmountRepository();

    public Account deposit(Amount amount) {
        this.depositRepository.add(amount);
        return this;
    }

    public Account withdrawal(Amount amount) {
        this.withdrawalRepository.add(amount);
        return this;
    }

    public void send(Account account, Amount amount) {
        this.withdrawal(amount);
        account.deposit(amount);
    }

    public Amount consultLastDeposit() {
        return depositRepository.peek();
    }

    public Amount consultLastWithdrawal() {
        return withdrawalRepository.peek();
    }
}
