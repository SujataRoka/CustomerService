package com.customer.usaa.entity;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private long CustomerId;
	    
	    private String name;
	    
	    private int age;
	   
	  	private String address;
        
	    private String companyName;
	    
	    private long phoneNumber;
	    
		private LocalDate createdDate;
		
		private LocalDate updatedDate;
		
		private String createdBy;
		
		private String updatedBy;

	    	    
}
