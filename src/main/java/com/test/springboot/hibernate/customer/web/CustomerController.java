package com.test.springboot.hibernate.customer.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.springboot.hibernate.customer.domain.Customer;
import com.test.springboot.hibernate.customer.dto.CustomerDto;
import com.test.springboot.hibernate.customer.dto.CustomerResultDto;
import com.test.springboot.hibernate.customer.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = { "/getAllCustomers" }, method = RequestMethod.GET)
	public ModelAndView getAllCustomers(ModelMap m, HttpServletRequest request, HttpServletResponse response) {

		List<CustomerResultDto> listOfCustomers = customerService.getAllCustomers();
		System.out.println(listOfCustomers);
		ModelAndView mvc = new ModelAndView("customer/customerDetails");
		mvc.addObject("customerForm", new CustomerDto());
		mvc.addObject("listOfCustomers", listOfCustomers);
		return mvc;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/customer/getAllCustomers";
	}

	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Customer getCustomerById(@PathVariable int id) {
		//TODO - get customer by id and return
		return null;
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCustomer(@ModelAttribute("customerForm") CustomerDto customerForm) {

		System.out.println("addCustomer CustomerFormDto: " + customerForm);

		if (customerForm.getId() == null || customerForm.getId() == 0) {
			customerService.addCustomer(customerForm);
		} else {
			customerService.updateCustomer(customerForm);
		}

		return "redirect:/customer/getAllCustomers";
	}

	@RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCustomer(@PathVariable("id") int id, Model model) {
		//TODO - get customer by id and set into model
		model.addAttribute("listOfCustomers", this.customerService.getAllCustomers());
		return "customerDetails";
	}

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCustomer(@PathVariable("id") int id) {
		//TODO - delete customer by id
		return "redirect:/getAllCustomers";

	}
}
