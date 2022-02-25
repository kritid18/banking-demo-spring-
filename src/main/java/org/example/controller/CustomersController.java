package org.example.controller;

import org.example.model.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers()
    {
        return customerService.getAllCustomers();
    }

    @RequestMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id)
    {
        return customerService.getCustomer(id);
    }

    @RequestMapping(value = "{Id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable Long Id)
    {
        customerService.deleteCustomer(Id);
    }
}
