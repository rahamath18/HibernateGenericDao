package com.test.springboot.hibernate.customer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.springboot.hibernate.customer.dao.CustomerDao;
import com.test.springboot.hibernate.customer.domain.Customer;
import com.test.springboot.hibernate.customer.dto.CustomerDto;
import com.test.springboot.hibernate.customer.dto.CustomerResultDto;
import com.test.springboot.hibernate.phone.dao.PhoneDao;
import com.test.springboot.hibernate.phone.domain.Phone;

@Service("customerService")
@Transactional
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	PhoneDao phoneDao;
	
	int pageSize = 5;

	public List<CustomerResultDto> getAllCustomers() {
		
			StringBuffer sql = new StringBuffer("");

			sql.append(" select ").append(
					" cus.id as id, ph.id as phoneId, cus.customer_name as customerName, cus.email as email, ph.phone_type as phoneType, ")
					.append(" ph.phone_no as phoneNo").append(" from test.customer cus ")
					.append(" join phone ph on (cus.id=ph.customer_id) ")
					//.append(" where ").append(" cus.id = ? ")
					;

			sql.append(" order by ");
			sql.append(" ph.phone_type asc ");

			System.out.println(sql);

			//List<Object> params = new ArrayList<Object>();
			//params.add(id);

			customerDao.flush();

			org.hibernate.SQLQuery query = customerDao.createNativeQuery(sql.toString());
			// set parameters
			//SQLUtil.setParameters(query, params);

			// add transform
			query.addScalar("id", new LongType()).addScalar("phoneId", new LongType())
					.addScalar("customerName", new StringType()).addScalar("email", new StringType())
					.addScalar("phoneType", new StringType()).addScalar("phoneNo", new StringType())

					.setResultTransformer(Transformers.aliasToBean(CustomerResultDto.class));

			List<CustomerResultDto> aList = query.list();
			return aList;
		}

	public Customer getCustomer(Long id) {
		return customerDao.find(id);
	}

	public void addCustomer(CustomerDto customerForm) {
		Customer customer = new Customer(customerForm.getCustomerName(), customerForm.getEmail());
		customerDao.persist(customer);
		
		if(customerForm.getPhoneType() != null) {
			for (int i = 0; i < customerForm.getPhoneType().length; i++) {
				String phoneType = customerForm.getPhoneType()[i];
				String phoneNo = customerForm.getPhoneNo()[i];
				phoneDao.persist(new Phone(phoneType, phoneNo + "_" + i, customer.getId()));
			}
		}
		// after successful persist set back the id
		customerForm.setId(customer.getId());
	}
	
	public void updateCustomer(CustomerDto customerForm) {
		//TODO - update customer
	}

}