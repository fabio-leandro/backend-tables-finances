package com.fabio.backend.models;

import com.fabio.backend.models.enums.RateType;
import com.fabio.backend.models.enums.Table;

import javax.validation.constraints.Pattern;
import java.util.Objects;

public class Financing {

    @Pattern(regexp = "(?i)PRICE|(?i)SAC", message = "Infomre tabelas PRICE ou SAC.")
    private String table;
    private Double financedAmount;
    private Double entrance;
    private Double rate;
    private RateType rateType;
    private Integer period;

    public Financing(){}

    public Financing(String table, Double financedAmount, Double entrance, Double rate, RateType rateType, Integer period) {
        this.table = table;
        this.financedAmount = financedAmount;
        this.entrance = entrance;
        this.rate = rate;
        this.rateType = rateType;
        this.period = period;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Double getFinancedAmount() {
        return financedAmount;
    }

    public void setFinancedAmount(Double financedAmount) {
        this.financedAmount = financedAmount;
    }

    public Double getEntrance() {
        return entrance;
    }

    public void setEntrance(Double entrance) {
        this.entrance = entrance;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public RateType getRateType() {
        return rateType;
    }

    public void setRateType(RateType rateType) {
        this.rateType = rateType;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Financing financing = (Financing) o;
        return table == financing.table && Objects.equals(financedAmount, financing.financedAmount) && Objects.equals(entrance, financing.entrance) && Objects.equals(rate, financing.rate) && rateType == financing.rateType && Objects.equals(period, financing.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, financedAmount, entrance, rate, rateType, period);
    }
}
