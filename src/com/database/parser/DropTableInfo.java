package com.database.parser;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * "Drop table" query.
 * Created by manfred on 11/4/14.
 */
public class DropTableInfo extends QueryInfo {
	public String tableName;

	public	DropTableInfo(ArrayList<String> queryElementIn) throws Exception{
		super(QueryType.DROP_TABLE);

		String [] queryElement = new String [queryElementIn.size()];
		queryElement = 	(String[])queryElementIn.toArray(queryElement);

		// Check if the passed in query is right.
		if(! ( 2 < queryElement.length && queryElement[0].equals("drop") && queryElement[1].equals("table")) )
			throw new Exception("[DropTableInfo] It's not a 'drop table' query, should be passed in.");
		else
			if(isTableName(queryElement[2]))
				tableName = queryElement[2];
			else
				throw new Exception("[DropTableInfo] indexName is invalid.");

	}
}
