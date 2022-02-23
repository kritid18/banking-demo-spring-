package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("cutomerService")
public class DefaultCustomerService implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    //setter injection
    public void setCustomerRepository(CustomerRepository repository) {
        this.repository = repository;
    }

    public DefaultCustomerService() {
    }

    public List<Customer> getAllCustomers()
    {
        return repository.findAll();
    }

    public List<Customer> getAllCustomersWithStars() {
        return repository.findAll()
                .stream()
                .map(c -> new Customer(c.getId(), "#####"+c.getName()+"****", c.getCity()))
                .collect(Collectors.toList());
    }


}
