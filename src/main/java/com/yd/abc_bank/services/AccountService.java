package com.yd.abc_bank.services;

import com.yd.abc_bank.dto.AccountCreationDTO;
import com.yd.abc_bank.exception.ResourceNotFoundException;
import com.yd.abc_bank.model.BankAccount;
import com.yd.abc_bank.model.CashAccount;
import com.yd.abc_bank.model.Customer;
import com.yd.abc_bank.repository.BankAccountRepository;
import com.yd.abc_bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.yd.abc_bank.util.ApplicationConstants.*;

@Service
public class AccountService implements AccountServiceI {
    private BankAccountRepository bankAccountRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public AccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public BankAccount createNewAccount(AccountCreationDTO accountCreationDTO) throws ResourceNotFoundException {
        Optional<Customer> customerData = customerRepository.findById(accountCreationDTO.getCustomerId());

        if (!customerData.isPresent()) {
            throw new ResourceNotFoundException();
        }

        BankAccount bankAccount = new BankAccount();
        List<CashAccount> cashAccountList = new ArrayList<>(4);

        bankAccount.setCustomerId(accountCreationDTO.getCustomerId());
        bankAccount.setCountryId(accountCreationDTO.getCountryId());

        for (int currencyId : accountCreationDTO.getCurrencyList()) {
            CashAccount cashAccount = new CashAccount();

            cashAccount.setBalance(0L);
            cashAccount.setCurrencyId(currencyId);

            cashAccountList.add(cashAccount);
        }

        bankAccount.setCashAccounts(cashAccountList);

        return bankAccountRepository.save(bankAccount);
    }

    private String getBankAccId() {
        return COUNTRY_CODE + CHECK_DIGITS + BANK_ID + BRANCH_ID + getRandomBankAccNumber();
    }

    private String getRandomBankAccNumber() {
        String accNum = "";

        for (int i = 0; i < 3; i++) {
            accNum += String.format("%04d", new Random().nextInt(10000));
        }

        return accNum;
    }
}
