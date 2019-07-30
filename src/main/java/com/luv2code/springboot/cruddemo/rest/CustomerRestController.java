package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.CustomerDAO;
import com.luv2code.springboot.cruddemo.entity.Customer;
import com.luv2code.springboot.cruddemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService customerService;
    @Autowired
    public CustomerRestController(CustomerService theCustomerService)
    {
        customerService=theCustomerService;
    }

    //expose "/customers" and return list of customers
    @GetMapping("/customers")
    public List<Customer> findAll()
    {
        return customerService.findAll();
    }
    //add mapping for GET /employees/{employeeId}
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId)
    {
        Customer customer= customerService.findById(customerId);
        if(customer==null)
        {
            throw  new RuntimeException("Customer ID didn't find");
        }
        return customer;
    }

    //add mapping for POST /customers -add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer)
    {
        //also just in case they pass an id in JSON .. set id to o
        //this is to force a save of new item ... instead od update
        theCustomer.setId(0);
        customerService.save(theCustomer);
        return theCustomer;
    }

    // add mapping for PUT /customers - update existing customer
    public  Customer updateCustomer(@RequestBody Customer theCustomer)
    {
        customerService.save(theCustomer);
        return theCustomer;
    }
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId)
    {
        Customer customer= customerService.findById(customerId);
        if(customer==null)
        {
            throw  new RuntimeException("Customer ID didn't find");
        }
        customerService.deleteById(customerId);
        return "Deleted customer id - "+customerId;
    }

}
