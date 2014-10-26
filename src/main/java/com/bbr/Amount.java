package com.bbr;

import java.time.Instant;

public final class Amount {

    final double value;
    final Instant instant;

    public Amount(double value) {
        this.value = value;
        this.instant = DateTimeService.getInstant();
    }

    public Amount(Amount amount) {
        this.value = amount.value;
        this.instant = DateTimeService.getInstant();
    }

    public boolean isAfter(Amount amount) {
        return this.instant.isAfter(amount.instant);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        if (Double.compare(amount.value, this.value) != 0) return false;
        return true;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(value);
        return (int) (temp ^ (temp >>> 32));
    }

    public Amount minus(Amount amount) {
        return new Amount(this.value - amount.value);
    }

    public Amount add(Amount amount) {
        return new Amount(this.value + amount.value);
    }

    public Instant counsultTime() {
        return instant;
    }
}
