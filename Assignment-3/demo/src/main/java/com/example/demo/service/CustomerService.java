package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
		if(!customer.isPresent()) {
			return new ResponseEntity<Object>(customer.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Customer not found!",HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<Object> updateCustomer(int id, Customer custData) {
		Optional<Customer> customer = customerRepo.findById(id);
		if(!customer.isPresent()) {
			customerRepo.save(custData);
			return new ResponseEntity<Object>("Customer Information Updated Successfully!",HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Customer not found!",HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<Object> deleteCustomer(int id) {
		Optional<Customer> customer = customerRepo.findById(id);
		if(!customer.isPresent()) {
			customerRepo.deleteById(id);
			return new ResponseEntity<Object>("Customer Information Deleted Successfully!",HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Customer not found!",HttpStatus.NOT_FOUND);
	}
}
