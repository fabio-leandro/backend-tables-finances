package com.fabio.backend.models;

import java.util.Objects;

public class TableFinancingCalculo {

    private Integer number;
    private Double payment;
    private Double interest;
    private Double amortization;
    private Double balance;

    public TableFinancingCalculo() {
    }

    public TableFinancingCalculo(Integer number, Double payment, Double interest, Double amortization, Double balance) {
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

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Double getAmortization() {
        return amortization;
    }

    public void setAmortization(Double amortization) {
        this.amortization = amortization;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableFinancingCalculo that = (TableFinancingCalculo) o;
        return Objects.equals(number, that.number) && Objects.equals(payment, that.payment) && Objects.equals(interest, that.interest) && Objects.equals(amortization, that.amortization) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, payment, interest, amortization, balance);
    }
}
