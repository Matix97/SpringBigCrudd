package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDAOHibernateImpl implements CustomerDAO {

    //define field for entitymanager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public CustomerDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Customer> findAll() {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create a query
        String str = "select ";
        str += "*";
        str += "from Klient";
        String str2="from Customer";
        Query<Customer> theQuery =
                currentSession.createQuery(str2, Customer.class);

        //execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        //return the results
        return customers;
    }

    @Override
    public Customer findById(int theId) {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //get the customer
        Customer theCustomer =
                currentSession.get(Customer.class, theId);

        return theCustomer;
    }

    @Override
    public void save(Customer theCustomer) {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //save customer
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public void deleteById(int theId) {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //delete object with primary key
        /*Query theQuery =
                currentSession.createQuery(
                  "delete from Klient where id=:customerID"
                );
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();*/
    }
}
