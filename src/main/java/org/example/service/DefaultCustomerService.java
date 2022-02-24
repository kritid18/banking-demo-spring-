package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
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



    public Customer getCustomer(Long id) {
        Optional<Customer> customerbyId = repository.findById(id);
// if(customerbyId.isPresent())
        return customerbyId.orElseGet(Customer::new);
// else
// return new Customer();
    }
}
