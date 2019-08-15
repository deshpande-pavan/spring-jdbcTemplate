package com.springjdbc;

import java.util.Scanner;

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
		int choice = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your choice of operation\n1. Insert\n2. GetById\n3. GetAll\n4. Delete");
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("You have selected to add customer to mysql db");
			System.out.print("Enter the customer id of the customer:");
			int custid = sc.nextInt();
			System.out.print("Enter name of the customer: ");
			String name = sc.next();
			System.out.print("Enter age of the customer: ");
			int age = sc.nextInt();
			customerJdbc.save(new CustomerModel(custid, name, age));
			break;
		case 2:
			System.out.println("You have selected to get customer by id");
			System.out.println("Enter the customer id");
			int custId = sc.nextInt();
			CustomerModel customer = customerJdbc.get(custId);
			System.out.println(customer.toString() + "");
			break;
		case 4:
			System.out.println("You have selected the delete operation by customer id");
			System.out.println("Enter customer id to delete");
			int id=sc.nextInt();
			customerJdbc.delete(id);
			break;
		default: {
			System.out.println("entered wrong input..exiting");
			sc.close();
			context.close();
			System.exit(0);
		}

		}
	}
}
