package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/home")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/allCustomer")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomer();
	}
	@GetMapping("/customer/get/{id}")
	public ResponseEntity<Object> getCustomerByID(@PathVariable int id) {
		return customerService.getCustomerByID(id);
	}
	@PutMapping("/customer/update/{id}")
	public ResponseEntity<Object> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
		return customerService.updateCustomer(id, customer);
	}
	@DeleteMapping("/customer/delete/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable int id) {
		return customerService.deleteCustomer(id);
	}
}
