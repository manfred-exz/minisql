package com.database.parser;

/**
 * Created by manfred on 11/2/14.
 */
public class CreateDatabaseInfo extends QueryInfo{
	String databaseName = null;

	public CreateDatabaseInfo(String _databaseName){
		super(QueryType.CREATE_DATABASE);

		//TODO: check if the name is valid.
		databaseName = _databaseName;
	}
}
