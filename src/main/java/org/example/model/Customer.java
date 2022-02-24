package org.example.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity(name = "customers")
public class Customer {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "customer_id")
    private Long id;

    private   String name;
    private String city;
    private String date_of_birth;
    private String zipcode;

    private int status;


    public Customer() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", status=" + status +
                '}';
    }
}
