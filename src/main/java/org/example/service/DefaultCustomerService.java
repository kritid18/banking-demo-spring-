package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRespositoryDB;

import java.util.List;

public class DefaultCustomerService {

    private CustomerRespositoryDB respository = new CustomerRespositoryDB();

    public List<Customer> getAllCustomer()
    {
        return respository.findAll();
    }
}
