package com.learn.multidb.meat;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceRouteConfig {

	public enum DataSourceType {
		READ_WRITE, READ_ONLY
	}

	@Bean("routingDataSource")
	public DataSource routingDataSource(
			@Qualifier("writeDataSource") DataSource writeDataSource,
			@Qualifier("readDataSource") DataSource readDataSource) {

		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(DataSourceType.READ_WRITE, writeDataSource);
		targetDataSources.put(DataSourceType.READ_ONLY, readDataSource);

		TransactionRoutingDataSource routingDataSource = new TransactionRoutingDataSource();
		routingDataSource.setTargetDataSources(targetDataSources);
		routingDataSource.setDefaultTargetDataSource(writeDataSource);

		return routingDataSource;
	}
}
