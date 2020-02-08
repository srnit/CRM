package com.luv2code.springdemo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceimpl implements CustomerService {
    @Autowired
	private CustomerDAO customerdaoobj;
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerdaoobj.getCustomers();
	}

}
