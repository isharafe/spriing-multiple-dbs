package com.learn.multidb.meat;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSource2Config {

	@Bean
	@ConfigurationProperties("spring.datasource.read")
	public DataSourceProperties readDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "readDataSource")
	public DataSource readDataSource() {
		return readDataSourceProperties().initializeDataSourceBuilder().build();
	}

}
