package com.luv2code.springdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@RequestMapping("/showFormForAdd")
	public String addCustomers(Model theModel) {
		theModel.addAttribute("customer", new Customer());
		return "add-customer";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer thecustomer)
	{
		customerserviceobj.savCustomerService(thecustomer);
		return "redirect:/customer/list";
	}
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int id,Model themodel)
	{
		Customer customerobj=customerserviceobj.updateCustomerService(id);
		themodel.addAttribute("customer",customerobj);
		return "add-customer";
		
	}
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId")int id,Model themodel)
	{
		customerserviceobj.deleteCustomerService(id);
		//themodel.addAttribute("customer",customerobj);
		return "redirect:/customer/list";
		
	}
}
