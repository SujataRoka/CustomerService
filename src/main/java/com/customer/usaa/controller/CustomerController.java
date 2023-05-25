package com.customer.usaa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.usaa.model.CustomerModel;
import com.customer.usaa.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	private CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping
	public List<CustomerModel> getAllCustomer(){
		List<CustomerModel> customers = service.getAllCustomer();
		return customers;
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerModel> getCustomerById(@PathVariable(name = "customerId") long customerId){
		return ResponseEntity.ok(service.getCustomerById(customerId));
	}
	
	@PostMapping
    public ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerModel customerModel){
        return new ResponseEntity<>(service.createCustomer(customerModel), HttpStatus.CREATED);
    }
	
	@PutMapping("/{customerId}")
    public ResponseEntity<CustomerModel> upadteCustomer(@RequestBody CustomerModel customerModel,@PathVariable(name = "customerId") long customerId){
    	CustomerModel updateCustomer = service.updateCustomer(customerModel, customerId);
    	return new ResponseEntity<>(updateCustomer,HttpStatus.OK);
    }

	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable(name = "customerId") long customerId){
		service.deleteCustomerById(customerId);
		return new ResponseEntity<>("Customer entity deleted successfully.",HttpStatus.OK);
		
	}

}
