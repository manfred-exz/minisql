package com.database.parser;

import java.util.ArrayList;

/**
 * Created by manfred on 11/4/14.
 */
public class InsertInfo extends QueryInfo{
	public String tableName;
	ArrayList<ConstantValue> values;

	public InsertInfo(ArrayList<String> queryElementIn) throws Exception {
		super(QueryType.INSERT);

		String [] queryElement = new String[queryElementIn.size()];
		queryElement = (String[])queryElementIn.toArray(queryElement);

		// Check if the passed in query is right.
		if(!queryElement[0].equals("insert") || !queryElement[1].equals("into"))
			throw new Exception(SelectInfo.class + ": " +  "It's not a 'Insert into' query, should not be passed in.");

		// find the table name.
		if( !isTableName(queryElement[2]))
			throw new Exception(InsertInfo.class + "table name not valid.");
		else
			tableName = queryElement[2];

		// seek to the 'Select' part and check if any attributes specified.
		values = parseValues(queryElement, 3);



	}


}
