package com.yd.abc_bank.services;

import com.yd.abc_bank.dto.AccountCreationDTO;
import com.yd.abc_bank.exception.ResourceNotFoundException;
import com.yd.abc_bank.model.BankAccount;

public interface AccountServiceI {
    BankAccount createNewAccount(AccountCreationDTO accountCreationDTO) throws ResourceNotFoundException;
}
