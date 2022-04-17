package com.yd.abc_bank.services;

import com.yd.abc_bank.exception.ResourceNotFoundException;
import com.yd.abc_bank.model.Customer;

import java.util.List;

public interface CustomerServiceI {
    Customer createNewCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer) throws ResourceNotFoundException;

    List<Customer> getAllCustomers();

    List<Customer> getCustomersByFirstName(String firstName);
}
