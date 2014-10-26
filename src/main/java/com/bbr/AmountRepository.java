package com.bbr;

import java.time.Instant;
import java.util.LinkedList;

public class AmountRepository {

    final LinkedList<Amount> amountRepository = new LinkedList<Amount>();

    public Amount peek() {
        return amountRepository.peek();
    }

    public AmountRepository add(Amount amount) {
        this.amountRepository.add(amount);
        return this;
    }

    public boolean isAfter(AmountRepository repository) {
        return amountRepository.peek().isAfter(repository.peek());
    }

    public Amount totalAmount() {
        return amountRepository.stream().reduce((a,b) -> a.add(b)).get();
    }

    public Amount minus(AmountRepository withdrawalRepository) {
        return this.totalAmount().minus(withdrawalRepository.totalAmount());
    }

    public Instant getLastHistory() {
        return amountRepository.peek().counsultTime();
    }
}
