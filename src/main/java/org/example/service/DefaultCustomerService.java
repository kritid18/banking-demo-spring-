package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service("cutomerService")
public class DefaultCustomerService implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    //setter injection
    public void setCustomerRepository(CustomerRepository repository) {
        this.repository = repository;
    }



    public List<Customer> getAllCustomers()
    {
        return repository.findAll();
    }


    public ResponseEntity<Customer> getCustomer(Long Id)
    {
        Optional<Customer> optionalCustomer = repository.findById(Id);
        if(optionalCustomer.isPresent())
        {
            return new ResponseEntity<>(optionalCustomer.get(), HttpStatus.OK);
        }
        //return new ResponseEntity<>(optionalCustomer.get(), HttpStatus.OK);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found");
    }




//    public Customer getCustomer(Long id) {
//        Optional<Customer> customerbyId = repository.findById(id);
//// if(customerbyId.isPresent())
//        return customerbyId.orElseGet(Customer::new);
//
//    }

        public void deleteCustomer(Long Id)
        {
//            System.out.println(repository.findById(Id));

            Optional<Customer> optionalCustomer = repository.findById(Id);
            if(optionalCustomer.isPresent())
            {
                repository.deleteById(Id);
            }
            //return new ResponseEntity<>(optionalCustomer.get(), HttpStatus.OK);
            else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found");
            }

             //repository.deleteById(Id);
        }

        public Customer saveCustomer(Customer customer)
        {
            return repository.saveAndFlush(customer);
        }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        ResponseEntity<Customer> responseEntity=getCustomer(id);
        if(responseEntity.getStatusCode().is4xxClientError())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "INVALID CUSTOMER ID");
        }

        Customer existingCustomer = responseEntity.getBody();
        BeanUtils.copyProperties(customer, existingCustomer, "id");
        return repository.saveAndFlush(existingCustomer);
    }
}
