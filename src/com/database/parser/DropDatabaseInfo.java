package com.database.parser;

import java.util.ArrayList;

/**
 * "Drop database" query.
 * Created by manfred on 11/2/14.
 */
public class DropDatabaseInfo extends QueryInfo{
	String databaseName = null;

	public	DropDatabaseInfo(ArrayList<String> queryElementIn) throws Exception{
		super(QueryType.DROP_DATABASE);

		String [] queryElement = new String [queryElementIn.size()];
		queryElement = 	(String[])queryElementIn.toArray(queryElement);

		// Check if the passed in query is right.
		if(! ( 2 < queryElement.length && queryElement[0].equals("drop") && queryElement[1].equals("database")) )
			throw new Exception("[DropDatabase] It's not a 'drop database' query, should be passed in.");
		else
		if(isTableName(queryElement[2]))
			databaseName = queryElement[2];
		else
			throw new Exception("[DropDatabase] databaseName is invalid.");

	}

}
