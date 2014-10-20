package com.bbr;

public final class Amount {

    final double amount;

    public Amount(double value) {
        this.amount = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        if (Double.compare(amount.amount, this.amount) != 0) return false;
        return true;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(amount);
        return (int) (temp ^ (temp >>> 32));
    }
}
