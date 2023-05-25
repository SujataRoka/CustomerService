package com.customer.usaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.usaa.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
