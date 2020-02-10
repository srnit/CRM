package com.luv2code.springdemo.services;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {
  public List<Customer> getCustomers();

   public void savCustomerService(Customer thecustomer);

    public Customer updateCustomerService(int id);

	public void deleteCustomerService(int id);
}
