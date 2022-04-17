package com.yd.abc_bank.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_acc_generator")
    @SequenceGenerator(name = "bank_acc_generator", sequenceName = "bank_acc_seq", allocationSize = 1)
    private Long id;
    private Long customerId;
    private int countryId;

    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL)
    private List<CashAccount> cashAccounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CashAccount> getCashAccounts() {
        return cashAccounts;
    }

    public void setCashAccounts(List<CashAccount> cashAccounts) {
        this.cashAccounts = cashAccounts;
    }

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
}
