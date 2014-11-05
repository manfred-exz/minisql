package com.database.parser;

import java.util.ArrayList;

/**
 * Created by manfred on 11/2/14.
 */
public class CreateDatabaseInfo extends QueryInfo{
	String databaseName = null;

	public CreateDatabaseInfo(ArrayList<String> queryElementIn) throws Exception{
		super(QueryType.CREATE_DATABASE);

		String [] queryElement = new String [queryElementIn.size()];
		queryElement = 	(String[])queryElementIn.toArray(queryElement);

		// Check if the passed in query is right.
		if(! ( 2 < queryElement.length && queryElement[0].equals("create") && queryElement[1].equals("database")) )
			throw new Exception("[CreateDatabase] It's not a 'create database' query, should be passed in.");
		else
		if( isDatabaseName(queryElement[2]) && isUniqueDatabaseName(queryElement[2]))
			databaseName = queryElement[2];
		else
			throw new Exception("[CreateDatabase] databaseName is invalid.");

	}

}
