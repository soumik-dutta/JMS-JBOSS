package com.omototest.dao.interfaces;

import java.util.List;

import org.hibernate.HibernateException;

public interface CommonDAOInterface {
	void addOrUpdateRecord(Object obj) throws HibernateException;

	void deleteRecord(Object obj) throws HibernateException;

	List getAllRecords() throws HibernateException;

	Object getObjectById(Long id) throws HibernateException;
}
