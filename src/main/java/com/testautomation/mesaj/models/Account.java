package com.testautomation.mesaj.models;

public class Account {

    private Money balance = new Money();

    public void deposit(Money pesos) {
        balance = balance.add(pesos);
    }
}
