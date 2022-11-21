package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.controller.CustomerController;
import com.example.demo.service.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTests {
	
	@Mock
	CustomerService custService; 
	
	@InjectMocks
	CustomerController customerController;
	
	
	@Test
	void testGetNameSizeValid() {
		int len = customerController.getNameSize("Hello World");
		assertEquals(11,len);
	}
	
	@Test
	void testGetNameSizeEmpty() {
		int len = customerController.getNameSize("");
		assertEquals(0, len);
	}
	
	@Test
	void testGetNameSizeNull() {
		assertThrows(NullPointerException.class,()->{
			int len = customerController.getNameSize(null);
			System.out.println("Size - "+len);
		});
	}
}
