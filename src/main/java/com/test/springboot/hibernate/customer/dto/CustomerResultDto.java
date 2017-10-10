
package com.test.springboot.hibernate.customer.dto;

import com.test.springboot.hibernate.common.util.JSONUtil;

public class CustomerResultDto {

	Long id;
	
	Long phoneId;

	String customerName; 

	String email;
	
	String phoneType; 

	String phoneNo;
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getPhoneId() {
		return phoneId;
	}



	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
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



	public String getPhoneType() {
		return phoneType;
	}



	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}



	public String getPhoneNo() {
		return phoneNo;
	}



	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}



	@Override
	public String toString() {
		return JSONUtil.POJO2JSON(this);
	}
	
}
