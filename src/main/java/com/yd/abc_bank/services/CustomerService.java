package com.yd.abc_bank.services;

import com.yd.abc_bank.exception.ResourceNotFoundException;
import com.yd.abc_bank.model.Customer;
import com.yd.abc_bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService implements CustomerServiceI {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createNewCustomer(Customer newCustomer) {
        Customer customer = customerRepository.save(newCustomer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Long id, Customer newCustomer) {
        Optional<Customer> customerData = customerRepository.findById(id);

        if (customerData.isPresent()) {
            Customer customer = customerData.get();
            customer.setFirstName(newCustomer.getFirstName());

            customerRepository.save(customer);

            return customer;
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getCustomersByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }
}
