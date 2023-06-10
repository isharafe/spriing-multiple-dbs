package com.learn.multidb.meat;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSource1Config {

	@Bean
	@ConfigurationProperties("spring.datasource.write")
	public DataSourceProperties writeDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "writeDataSource")
	/* In another place in the code, we need a bean of type
	 * "EntityManagerFactoryBuilder". to get this bean a Primary data-source should be configured*/
	@Primary
	public DataSource writeDataSource() {
		return writeDataSourceProperties().initializeDataSourceBuilder().build();
	}

}
