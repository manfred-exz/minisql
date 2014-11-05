package com.database.parser;

import java.util.ArrayList;

/**
 * Created by manfred on 10/29/14.
 */
public class CreateIndexInfo extends QueryInfo{
	public String indexName;
	public String tableName;
	public String attributeName;



	public CreateIndexInfo(ArrayList<String> queryElementIn) throws Exception{
		super(QueryType.CREATE_INDEX);

		String [] queryElement = new String [queryElementIn.size()];
		queryElement = 	(String[])queryElementIn.toArray(queryElement);

		// Check if the passed in query is right.
		if(! ( 6 < queryElement.length && queryElement[0].equals("create") && queryElement[1].equals("index") && queryElement[3].equals("on")) )
			throw new Exception("[DropIndexInfo] It's not a 'create index' query, should be passed in.");
		else
		if( isUniqueIndexName(queryElement[2]) && isTableName(queryElement[4]) && isAttributeName(queryElement[6], queryElement[4])) {
			indexName = queryElement[2];
			tableName = queryElement[4];
			attributeName = queryElement[6];
		}
		else
			throw new Exception("[DropIndexInfo] indexName is invalid.");



	}




}
