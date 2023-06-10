package com.learn.multidb.meat;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.learn.multidb.MultiDbConApplication;

@Configuration
@EnableTransactionManagement
public class JpaConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			@Qualifier("routingDataSource") DataSource routingDataSource,
			EntityManagerFactoryBuilder builder) {

//        LocalContainerEntityManagerFactoryBean bean =
		return builder
            .dataSource(routingDataSource)
            .properties(additionalProperties())
            /*use a class at root package for ease of use, just cause i'm lazy*/
            .packages(MultiDbConApplication.class)
            .persistenceUnit("default")
            .build();

//        if(bean.getJpaVendorAdapter() instanceof HibernateJpaVendorAdapter hJpaVA) {
//        	hJpaVA.setPrepareConnection(true);
//        }
//
//        return bean;
    }

    /**
     * From: https://stackoverflow.com/questions/25911359/how-to-split-read-only-and-read-write-transactions-with-jpa-and-hibernate/26026237
     *
     * Note that the additionalProperties method defines the
     * hibernate.connection.provider_disables_autocommit Hibernate property, which I added to
     * Hibernate to postpone the database acquisition for RESOURCE_LOCAL JPA transactions.
     * Not only that the hibernate.connection.provider_disables_autocommit allows you to
     * make better use of database connections,
     * but it's the only way we can make this example work since,
     * without this configuration, the connection is acquired prior to calling
     * the determineCurrentLookupKey method TransactionRoutingDataSource.
     */
    Map<String, Object> additionalProperties() {
		Map<String, Object> props = new HashMap<>();
		// getting exception java.sql.SQLException: Can't call commit when autocommit=true
//		props.put("hibernate.connection.provider_disables_autocommit", Boolean.TRUE.toString());

		return props;
    }

//    @Bean
//    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//        return transactionManager;
//    }
//
//    @Bean
//    public TransactionTemplate transactionTemplate(EntityManagerFactory entityManagerFactory) {
//        return new TransactionTemplate(transactionManager(entityManagerFactory));
//    }
}

