package org.example.repository;

import org.example.model.Customer;

import javax.swing.plaf.basic.BasicListUI;
import java.util.List;

import static java.util.Arrays.asList;

public class CustomerRepositoryStub implements CustomerRepository{

    @Override
    public List<Customer> findAll() {
        return asList(
                new Customer("1", "Brijesh", "New DElhi"),
                new Customer("2", "Dharmesh", "New Delhi"),
                new Customer("3", "Taniya", "New DElhi"));
    }
}