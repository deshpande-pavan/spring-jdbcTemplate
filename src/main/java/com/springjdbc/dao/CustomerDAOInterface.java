package com.springjdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.springjdbc.model.CustomerModel;

public interface CustomerDAOInterface {
	
	public void setDataSource(DataSource datasource);

	public void save(CustomerModel customer);

	public void delete(int contactId);

	public CustomerModel get(int contactId);

	public List<Object> list();
}
