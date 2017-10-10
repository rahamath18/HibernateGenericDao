package com.test.springboot.hibernate.phone.service;

import java.util.List;

import javax.transaction.Transactional;

import com.test.springboot.hibernate.customer.dao.CustomerDao;
import com.test.springboot.hibernate.customer.domain.Customer;
import com.test.springboot.hibernate.phone.dao.PhoneDao;
import com.test.springboot.hibernate.phone.domain.Phone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("phoneService")
@Transactional
public class PhoneService {

	@Autowired
	PhoneDao phoneDao;

	public List<Phone> getAllPhones() {
		return phoneDao.findAll();
	}

	public Phone getPhone(Long id) {
		return phoneDao.find(id);
	}

	public void addPhone(Phone phone) {
		phoneDao.persist(phone);
	}
	

}
