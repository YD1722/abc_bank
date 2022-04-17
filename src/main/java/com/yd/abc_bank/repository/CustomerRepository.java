package com.yd.abc_bank.repository;

import com.yd.abc_bank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByFirstName(String name);
}