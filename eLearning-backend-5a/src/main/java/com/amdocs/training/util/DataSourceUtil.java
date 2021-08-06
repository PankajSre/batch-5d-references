package com.amdocs.training.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.amdocs.training")
public class DataSourceUtil {

	@Bean
	public static DataSource dataSource() {
		try {
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/batch_6b");
			ds.setUsername("root");
			ds.setPassword("pankaj");
			return ds;
		} catch (Exception ex) {
			return null;
		}
	}
}
