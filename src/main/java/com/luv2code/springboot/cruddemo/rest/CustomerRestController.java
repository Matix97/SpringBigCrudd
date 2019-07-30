package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.CustomerDAO;
import com.luv2code.springboot.cruddemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerDAO customerDAO;
    //quick and dirty: inject customer dao
    @Autowired
    public CustomerRestController(CustomerDAO theCustomerDAO)
    {
        customerDAO=theCustomerDAO;
    }

    //expose "/customers" and return list of customers
    @GetMapping("/customers")
    public List<Customer> findAll()
    {
        return customerDAO.findAll();
    }
}
