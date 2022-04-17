package com.yd.abc_bank.repository;

import com.yd.abc_bank.model.CashAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashAccountRepository extends JpaRepository<CashAccount, Long> {
}