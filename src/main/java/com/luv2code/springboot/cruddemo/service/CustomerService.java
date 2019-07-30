package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();
    public Customer findById(int theId);
    public void save(Customer theCustomer);
    public void deleteById(int theId);


}
