package com.luv2code.springdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
    private CustomerService customerserviceobj;
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer>resultlist=customerserviceobj.getCustomers();
		theModel.addAttribute("customers", resultlist);
		return "listcustomer";
	}
	
}
