package org.example.app;

import org.example.AppConfig;
import org.example.model.Customer;
import org.example.repository.CustomerRepositoryStub;
import org.example.repository.CustomerRespositoryDB;
import org.example.service.CustomerService;
import org.example.service.DefaultCustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application{

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService service = context.getBean("customerService", CustomerService.class);


        List<Customer>customers = service.getAllCustomers();

       // CustomerRepositoryStub customerRepositoryStub = new CustomerRepositoryStub();
        //CustomerRespositoryDB dbrepository = new CustomerRespositoryDB();

        //DefaultCustomerService service = new DefaultCustomerService(dbrepository);

        customers.forEach(System.out::println);
    }


    public static CustomerRepositoryStub newCustomerRepositoryStub() {
        return new CustomerRepositoryStub();
    }

    public static CustomerRespositoryDB newCustomerRepositoryDb() {
        return new CustomerRespositoryDB();
    }

}
