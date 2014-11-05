package com.database.parser;

import java.util.ArrayList;

/**
 * Created by manfred on 11/2/14.
 */
public class UseInfo extends QueryInfo{
	String databaseName = null;

	public UseInfo(ArrayList<String> queryElementIn) throws Exception{
		super(QueryType.USE);

		String [] queryElement = new String [queryElementIn.size()];
		queryElement = 	(String[])queryElementIn.toArray(queryElement);

		// Check if the passed in query is right.
		if(! ( 1 < queryElement.length && queryElement[0].equals("use")) )
			throw new Exception("[Use] It's not a 'use database' query, should be passed in.");
		else
		if(isTableName(queryElement[1]))
			databaseName = queryElement[1];
		else
			throw new Exception("[Use] databaseName is invalid.");

	}

}
