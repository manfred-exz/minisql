package com.database.parser;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by manfred on 11/4/14.
 */
public class DropTableInfo extends QueryInfo {
	public String tableName;

	public	DropTableInfo(ArrayList<String> queryElementIn) throws Exception{
		super(QueryType.DROP_TABLE);

		String [] queryElement = (String[])queryElementIn.toArray();

		// Check if the passed in query is right.
		if(! (queryElement[0].equals("drop") && queryElement[1].equals("table")) )
			throw new Exception("[CreateTableInfo] It's not a 'drop table' query, should be passed in.");
		else
			if(isTableName(iterator.next()))
				tableName = iterator.
	}
}
