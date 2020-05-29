package com.testautomation.mesaj.models;

public class Money {

    private final int pesos;
    private final int cents;

    public Money() {
        this.pesos = 0;
        this.cents = 0;
    }

    public Money(int pesos, int cents) {
        this.pesos = pesos;
        this.cents = cents;
    }

    public int pesos() {
        return pesos;
    }

    public int cents() {
        return cents;
    }

    public Money add(Money amount){
        int newCents = cents + amount.cents();
        int newPesos = pesos + amount.pesos();

        return new Money(newPesos, newCents);
    }
}
