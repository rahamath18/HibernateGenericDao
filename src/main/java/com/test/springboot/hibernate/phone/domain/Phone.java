
package com.test.springboot.hibernate.phone.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.test.springboot.hibernate.common.util.JSONUtil;

@Entity
@Table(name="PHONE")
public class Phone {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;

	@Column(name="PHONE_TYPE")
	String phoneType; 

	@Column(name="PHONE_NO")
	String phoneNo;
	
	@Column(name="CUSTOMER_ID", nullable = false)
	private Long customerId;
	
	public Phone() {
		super();
	}
	
	public Phone(String phoneType,String phoneNo, Long customerId) {
		super();
		this.phoneType=phoneType;
		this.phoneNo=phoneNo;
		this.customerId = customerId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return JSONUtil.POJO2JSON(this);
	}
	
}
