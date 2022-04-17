package com.yd.abc_bank.controller;

import com.yd.abc_bank.exception.ResourceNotFoundException;
import com.yd.abc_bank.model.Customer;
import com.yd.abc_bank.services.CustomerServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerServiceI customerService;

    @Autowired
    public CustomerController(CustomerServiceI customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public ResponseEntity getAllCustomers() {
        List<Customer> customerList = customerService.getAllCustomers();
        return ResponseEntity.ok().body(customerList);
    }

    @GetMapping("/{firstName}")
    public ResponseEntity getByFirstName(@PathVariable(value = "firstName") String firstName) {
        List<Customer> filteredCustomerList = customerService.getCustomersByFirstName(firstName);
        return ResponseEntity.ok().body(filteredCustomerList);

    }

    @PostMapping()
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createNewCustomer(customer);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer partialCustomer, @PathVariable(value = "id") Long id) {
        try {
            Customer customer = customerService.updateCustomer(id, partialCustomer);
            return ResponseEntity.ok().body(customer);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Not Found");
        }
    }
}
