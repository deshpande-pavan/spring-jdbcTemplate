package com.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.model.CustomerModel;

public class CustomerMapper implements RowMapper<Object> {

	@Override
	public CustomerModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomerModel customer = new CustomerModel();
		customer.setCustId(rs.getInt("custid"));
		customer.setName(rs.getString("name"));
		customer.setAge(rs.getInt("age"));
		return customer;
	}

}
