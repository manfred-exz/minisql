package com.database.parser;

/**
 * Created by manfred on 11/2/14.
 */
public class DropDatabaseInfo extends QueryInfo{
	String databaseName = null;

	public DropDatabaseInfo(String _databaseName){
		super(QueryType.DROP);

		//TODO: check if the database exists.
		databaseName = _databaseName;
	}

}
