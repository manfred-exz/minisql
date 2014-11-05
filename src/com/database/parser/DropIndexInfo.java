package com.database.parser;


import java.util.ArrayList;

/**
 * Created by manfred on 11/4/14.
 */
public class DropIndexInfo extends QueryInfo {
	public String indexName;

	public DropIndexInfo(ArrayList<String> queryElementIn) throws Exception{
		super(QueryType.DROP_INDEX);

		String [] queryElement = new String [queryElementIn.size()];
		queryElement = 	(String[])queryElementIn.toArray(queryElement);

		// Check if the passed in query is right.
		if(! ( 2 < queryElement.length && queryElement[0].equals("drop") && queryElement[1].equals("index")) )
			throw new Exception("[DropIndexInfo] It's not a 'drop index' query, should be passed in.");
		else
			if(isTableName(queryElement[2]))
				indexName = queryElement[2];
			else
				throw new Exception("[DropIndexInfo] indexName is invalid.");

	}
}
