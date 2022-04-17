package com.yd.abc_bank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yd.abc_bank.dto.AccountCreationDTO;
import com.yd.abc_bank.model.BankAccount;
import com.yd.abc_bank.services.AccountServiceI;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountServiceI accountServiceI;
    private ObjectMapper mapper;

    @Autowired
    public AccountController(AccountServiceI accountService) {
        this.accountServiceI = accountService;
        mapper = new ObjectMapper();
    }

    @PostMapping
    public ResponseEntity createAccount(@RequestBody AccountCreationDTO accountCreationDTO) {
        // TODO: Use DTO or use another object
        BankAccount bankAccount = this.accountServiceI.createNewAccount(accountCreationDTO);
        return ResponseEntity.ok().body(bankAccount);
    }
}
