package com.springjdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springjdbc.config.AppConfig;
import com.springjdbc.dao.DAOImplementation;
import com.springjdbc.model.CustomerModel;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.springjdbc");
		context.refresh();
		DAOImplementation customerJdbc = context.getBean(DAOImplementation.class);
		customerJdbc.setDataSource(new AppConfig().getDataSource());
		CustomerModel customer = new CustomerModel(1, "Pavan", 25);
		System.out.println("1. Insert");
		customerJdbc.save(customer);
		System.out.println("2. Get by id");
		CustomerModel newcustomer = customerJdbc.get(3);
		System.out.println("Customer with id 2 is:\nName:" + newcustomer.getName() + " Age:" + newcustomer.getAge());
		context.close();
	}
}
