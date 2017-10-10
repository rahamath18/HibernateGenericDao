package com.test.springboot.hibernate.customer.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.test.springboot.hibernate.common.dao.GenericDaoHibernateImpl;
import com.test.springboot.hibernate.customer.domain.Customer;

@Repository("customerDao")
public class CustomerDao extends GenericDaoHibernateImpl<Customer, Serializable> {

	public CustomerDao() {
		setClazz(Customer.class);
		// CustomerResultDto is only used for pagination. Not required to set Claszzzzz
	}
	
//	public Page<CustomerResultDto> queryPageForCustomer(Query query, int pageNum, int pageSize) {
////		return getPageFromScrollableResults(pageNum, pageSize, query.scroll());
//		return pageByQuery(pageNum, pageSize, query);
//	}
	
}
