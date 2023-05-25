package com.customer.usaa.service;

import java.util.List;

import com.customer.usaa.entity.Customer;
import com.customer.usaa.model.CustomerModel;

public interface CustomerService {
	
	public List<CustomerModel> getAllCustomer();
	
	public CustomerModel getCustomerById(long customerId);
	
	public CustomerModel createCustomer(CustomerModel customerModel);
	
	public CustomerModel updateCustomer(CustomerModel customerModel,long customerId );
	
	public void deleteCustomerById(long customerId);

}
