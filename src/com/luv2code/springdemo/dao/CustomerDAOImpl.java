package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastname", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}

	@Override
	public void saveCustomer(Customer thecustomer) {
		Session currentsession=sessionFactory.getCurrentSession();
		currentsession.saveOrUpdate(thecustomer);
		
	}

	@Override
	public Customer getCustomersbyID(int id) {
	  
	    Session cursession=sessionFactory.getCurrentSession();
	    return cursession.get(Customer.class, id);
		
	}

	@Override
	public void deleteCustomerbyID(int id) {
		Session currentsession=sessionFactory.getCurrentSession();
		Query thequery= currentsession.createQuery("delete from Customer where id=:customerid");
		thequery.setParameter("customerid",id);
		thequery.executeUpdate();
		
	}

}





