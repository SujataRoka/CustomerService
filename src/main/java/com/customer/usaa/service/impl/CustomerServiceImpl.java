package com.customer.usaa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.customer.usaa.entity.Customer;
import com.customer.usaa.exception.ResourceNotFoundException;
import com.customer.usaa.model.CustomerModel;
import com.customer.usaa.repository.CustomerRepository;
import com.customer.usaa.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepo;
	
	private ModelMapper modelMapper;
	
	public CustomerServiceImpl(CustomerRepository customerRepo, ModelMapper modelMapper) {
		this.customerRepo = customerRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<CustomerModel> getAllCustomer() {
		
		List<Customer> customers =  customerRepo.findAll();
		return customers.stream().map(customer->mapToModel(customer)).collect(Collectors.toList());
	}
    
	

	@Override
	public CustomerModel getCustomerById(long customerId) {
		Customer customer = customerRepo.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","customerId",customerId));
		return mapToModel(customer);
	}

	@Override
	public CustomerModel createCustomer(CustomerModel customerModel) {
		Customer customer = mapToEntity(customerModel);
		Customer newCustomer = customerRepo.save(customer);
		
		CustomerModel customerResponse = mapToModel(newCustomer);
		return customerResponse;
	}
    //Convert Model To Entity
	private Customer mapToEntity(CustomerModel customerModel) {
		Customer customer = modelMapper.map(customerModel, Customer.class);
		return customer;
	}
	
	//Convert Entity into model
	private CustomerModel mapToModel(Customer customer) {
		CustomerModel customerModel = modelMapper.map(customer, CustomerModel.class);
		return customerModel;
	}

	@Override
	public CustomerModel updateCustomer(CustomerModel customerModel, long customerId) {
		Customer customer = customerRepo.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","customerId",customerId));
		customer.setName(customerModel.getName());
		customer.setAddress(customerModel.getAddress());
		customer.setCompanyName(customerModel.getCompanyName());
		customer.setAge(customerModel.getAge());
		customer.setPhoneNumber(customerModel.getPhoneNumber());
		Customer upadtePost = customerRepo.save(customer);
		return mapToModel(upadtePost);
	}

	@Override
	public void deleteCustomerById(long customerId) {
		Customer customer = customerRepo.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","customerId",customerId));
		customerRepo.delete(customer);
	}

}
