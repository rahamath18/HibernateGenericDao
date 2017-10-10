package com.test.springboot.hibernate.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

public interface GenericDao<T, ID extends Serializable> {

    T find(ID id);
    
    List< T > findAll();
    
    T getReference(ID id);
        
    void persist(T newInstance);
    
    void save(T newInstance);
    
    void update(T o);

    T merge(T object);

    void remove(T persistentObject);
    
    Query createQuery(String queryStr);
    
    List<T> findByQuery(Query query);
    
    List<T> findByNativeQuery(SQLQuery query);
    
    List<T> findByExample(T exampleInstance);
    
    List<T> findByCriteria(Criterion... criterion);
    
    void flush();
    
    void clear();
    
    void evict(T object);
    
    //convinience method to get rid of duplicates
    Set<T> uniqueSet(List<T> list);
    
    //convinience method to get rid of duplicates
    List<T> uniqueList(List<T> list);
    
    Session getSession(); 
    
    Query getNamedQuery(String queryName);

	SQLQuery createNativeQuery(String queryString);
	
	Criteria createEntityCriteria();
	
}
