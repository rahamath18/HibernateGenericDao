package com.test.springboot.hibernate.common.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDaoHibernateImpl <T, ID extends Serializable> implements GenericDao<T, ID> {
	
	@Autowired
    private SessionFactory sessionFactory;
    
    private Class<T> type;
    
    public final void setClazz( Class< T > type ){
    	this.type = type;
     }

    public T find(ID id) {
    	return (T) getSession().get(type, id);
    }
    
    @SuppressWarnings("unchecked")
    public List< T > findAll() {
        return getSession().createQuery( "from " + type.getName() ).list();
     }
    
    public T getReference(ID id) {
    	return (T) getSession().load(type, id);
    }
        
    public void persist(T o) {
        getSession().persist(o);
    }
    
    public void save(T o) {
        getSession().save(o);
    }

    @SuppressWarnings("unchecked")
    public T merge(T o) {
        return (T) getSession().merge(o);
    }
    
    public void update(T o) {
        getSession().update(o);
    }

    public void remove(T o) {
        getSession().delete(o);
    }
    
    public Query createQuery(String queryStr) {
        return getSession().createQuery(queryStr);
    }
    
    public Criteria createEntityCriteria() {
		return getSession().createCriteria(type);
	}

	public Query getNamedQuery(String queryName) {
		return getSession().getNamedQuery(queryName);
	}

	public SQLQuery createNativeQuery(String queryString) {
		return getSession().createSQLQuery(queryString);
	}
    
    @SuppressWarnings("unchecked")
    public List<T> findByQuery(Query query) {
        return query.list();
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findByNativeQuery(SQLQuery query) {
        return query.list();
    }
    
    public List<T> findByExample(T exampleInstance) {
        return findByCriteria(Example.create(exampleInstance));
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findByCriteria(Criterion... criterion) {
        Criteria crit = getSession().createCriteria(type);
        for (Criterion c : criterion) {
        	crit.add(c);
        }
        return crit.list();
    }
    
    public void flush() {
    	getSession().flush();
    }
    
    public void clear() {
    	getSession().clear();
    }
    
    public void evict(T object) {
    	getSession().evict(object);
    }
    
    public Set<T> uniqueSet(List<T> list) {
    	return new LinkedHashSet<T>(list);
    }
    
    public List<T> uniqueList(List<T> list) {
    	return new ArrayList<T>(uniqueSet(list));
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
        		//SessionFactoryUtils.getSession(sessionFactory, true);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public Class<T> getBaseType() {
		return type;
	} 
}
