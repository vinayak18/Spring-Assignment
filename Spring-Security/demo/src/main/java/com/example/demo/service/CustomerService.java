package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.CustomerNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepo;
	
	public List<Customer> getAllCustomer(){
		return customerRepo.findAll();
	}
	
	public ResponseEntity<Object> getCustomerByID(int id) {
		Optional<Customer> customer = customerRepo.findById(id);
		if(customer.isPresent()) {
			return new ResponseEntity<Object>(customer.get(),HttpStatus.OK);
		}
		else {
			throw new CustomerNotFoundException();
		}
	}
	public Customer getCustomerByID1(int id) {
		try {
			return customerRepo.findById(id).get();
		} catch (Exception e) {
			throw new CustomerNotFoundException();
		}
	}
	
	public ResponseEntity<Object> updateCustomer(int id, Customer custData) {
		Optional<Customer> customer = customerRepo.findById(id);
		if(customer.isPresent()) {
			customerRepo.save(custData);
			return new ResponseEntity<Object>("Customer Information Updated Successfully!",HttpStatus.OK);
		}
		else {
			throw new CustomerNotFoundException();
		}
	}
	
	public ResponseEntity<Object> deleteCustomer(int id) {
		Optional<Customer> customer = customerRepo.findById(id);
		if(customer.isPresent()) {
			customerRepo.deleteById(id);
			return new ResponseEntity<Object>("Customer Information Deleted Successfully!",HttpStatus.OK);
		}
		else {
			throw new CustomerNotFoundException();
		}
	}
	
	public ResponseEntity<Object> createCustomer(Customer cust) {
		Optional<Customer> customer = customerRepo.findById(cust.getId());
		if(!customer.isPresent()) {
			customerRepo.save(cust);
			return new ResponseEntity<Object>("New Customer Added Successfully!",HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Customer Already Exsists!",HttpStatus.BAD_REQUEST);
	}
}
