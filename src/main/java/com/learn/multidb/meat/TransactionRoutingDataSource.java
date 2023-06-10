package com.learn.multidb.meat;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.learn.multidb.meat.DataSourceRouteConfig.DataSourceType;

public class TransactionRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO: FIXME: this always returns false
		boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
		System.out.println("Current transaction is " + (isReadOnly ? "read-only" : "read-write"));
		return isReadOnly ?
				DataSourceType.READ_ONLY : DataSourceType.READ_WRITE;
	}
}
