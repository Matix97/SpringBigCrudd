package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.CustomerRepository;
import com.luv2code.springboot.cruddemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int theId)
    {
        Optional<Customer> result =customerRepository.findById(theId);
        Customer customer =null;
        if(result.isPresent())
            customer=result.get();
        else
            throw new RuntimeException("Did not find customer id - "+ theId);

        return customer;
    }

    @Override
    public void save(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    @Override
    public void deleteById(int theId) {
        customerRepository.deleteById(theId);
    }
}
