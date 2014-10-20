package com.bbr.repository;

import com.bbr.Amount;

import java.util.Stack;

public class AmountRepository {

    final Stack<Amount> amountRepository = new Stack<Amount>();

    public Amount peek() {
        return amountRepository.peek();
    }

    public AmountRepository add(Amount amount) {
        this.amountRepository.add(amount);
        return this;
    }
}
