package com.springjdbc.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {

	public DataSource getDataSource() {
		String filePath="src/main/resources/database.properties";
		Properties props = new Properties();
		try (InputStream is = new FileInputStream(filePath)) {
			props.load(is);
		} catch (IOException e) {
			System.out.println("Error in reading the database properties file");
		}
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(props.getProperty("driver"));
		dataSource.setUrl(props.getProperty("url"));
		dataSource.setUsername(props.getProperty("username"));
		dataSource.setPassword(props.getProperty("password"));
		return dataSource;
	}
}
