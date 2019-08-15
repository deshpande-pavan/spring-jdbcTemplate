package com.springjdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.springjdbc.model.CustomerModel;

@Component
public class DAOImplementation implements CustomerDAOInterface {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(CustomerModel customer) {
		String sqlQuery = "INSERT INTO CUSTOMER (CUSTID, NAME, AGE) values (?,?,?)";
		jdbcTemplate.update(sqlQuery, customer.getCustId(), customer.getName(), customer.getAge());
		System.out.println("Created Customer");
	}

	@Override
	public void delete(int custid) {
		String sqlQuery = "delete from test.Customer where custid = ?";
		jdbcTemplate.update(sqlQuery, custid);
		System.out.println("Deleted Record with ID = " + custid);
	}

	@Override
	public CustomerModel get(int custId) {
		String sqlQuery = "select * from Customer where custid = ?";
		return (CustomerModel) jdbcTemplate.queryForObject(sqlQuery, new Object[] { custId }, new CustomerMapper());

	}

	@Override
	public List<Object> list() {
		String sqlQuery = "select * from customer";
		return jdbcTemplate.query(sqlQuery, new CustomerMapper());
	}

	
}