package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRespositoryDB;

import java.util.List;

public class DefaultCustomerService {


    public DefaultCustomerService(CustomerRespositoryDB respository) {
        this.respository = respository;
    }

    private CustomerRespositoryDB respository;



    public List<Customer> getAllCustomer()
    {
        return respository.findAll();
    }
}
