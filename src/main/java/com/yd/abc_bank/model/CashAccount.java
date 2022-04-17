package com.yd.abc_bank.model;

import javax.persistence.*;

@Entity
public class CashAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cash_acc_generator")
    @SequenceGenerator(name = "cash_acc_generator", sequenceName = "cash_acc_seq", allocationSize = 1)
    private Long id;

    private int currencyId;
    private Long balance;

    @ManyToOne
    @JoinColumn(name="bank_acc_id")
    private BankAccount bankAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
