package org.example;

import com.mysql.cj.xdevapi.Schema;
import org.example.repository.CustomerRepository;
import org.example.repository.CustomerRespositoryDB;
import org.example.service.CustomerService;
import org.example.service.DefaultCustomerService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan({"org.example"})
public class AppConfig {

//    @Bean("customerService")
//    public CustomerService getCustomerService() {
//        CustomerService service = new DefaultCustomerService(getCustomerRepositoryDB());
//        return service;
//    }
//
//    @Bean("customerRepository")
//    public CustomerRepository getCustomerRepositoryDB() {
//        return new CustomerRespositoryDB() ;
//
//    }
}
