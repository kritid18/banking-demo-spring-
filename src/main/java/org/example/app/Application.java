package org.example.app;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.example.repository.CustomerRepositoryStub;
import org.example.repository.CustomerRespositoryDB;
import org.example.service.DefaultCustomerService;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        CustomerRepositoryStub customerRepositoryStub = new CustomerRepositoryStub();
        CustomerRespositoryDB dbrepository = new CustomerRespositoryDB();

        DefaultCustomerService service = new DefaultCustomerService(dbrepository);

        List<Customer>customers = service.getAllCustomer();

        customers.forEach(System.out::println);
    }
}
