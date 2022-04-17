package com.yd.abc_bank.dto;

import java.util.List;

public class AccountCreationDTO {
    private Long customerId;
    private int countryId;
    private List<Integer> currencyList;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public List<Integer> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Integer> currencyList) {
        this.currencyList = currencyList;
    }
}
