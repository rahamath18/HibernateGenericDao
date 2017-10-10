package com.test.springboot.hibernate.phone.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.test.springboot.hibernate.common.dao.GenericDaoHibernateImpl;
import com.test.springboot.hibernate.phone.domain.Phone;

@Repository("phoneDao")
public class PhoneDao extends GenericDaoHibernateImpl<Phone, Serializable> {

	public PhoneDao() {
		setClazz(Phone.class);
		// CustomerResultDto is only used for pagination. Not required to set Claszzzzz
	}
	
}
