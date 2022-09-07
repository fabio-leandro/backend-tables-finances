package com.fabio.backend.models;

import java.util.Objects;

public class TableFinancing {

    private Integer number;
    private String payment;
    private String interest;
    private String amortization;
    private String balance;

    public TableFinancing(){}

    public TableFinancing(Integer number, String payment, String interest, String amortization, String balance) {
        this.number = number;
        this.payment = payment;
        this.interest = interest;
        this.amortization = amortization;
        this.balance = balance;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getAmortization() {
        return amortization;
    }

    public void setAmortization(String amortization) {
        this.amortization = amortization;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableFinancing that = (TableFinancing) o;
        return Objects.equals(number, that.number) && Objects.equals(payment, that.payment) && Objects.equals(interest, that.interest) && Objects.equals(amortization, that.amortization) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, payment, interest, amortization, balance);
    }
}
