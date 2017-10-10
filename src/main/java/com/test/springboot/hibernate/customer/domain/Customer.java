
package com.test.springboot.hibernate.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.test.springboot.hibernate.common.util.JSONUtil;

@Entity
@Table(name="CUSTOMER")
public class Customer {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;

	@Column(name="CUSTOMER_NAME")
	String customerName; 

	@Column(name="EMAIL")
	String email;
	
	public Customer() {
		super();
	}
	public Customer(String customerName,String email) {
		super();
		this.customerName=customerName;
		this.email=email;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return JSONUtil.POJO2JSON(this);
	}
	
}
