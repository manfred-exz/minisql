package com.database.parser;

import java.util.ArrayList;

/**
 * Created by manfred on 11/2/14.
 */
public class SelectInfo extends QueryInfo {
	public ArrayList<String> tableList = null;
	public ArrayList<Attribute> selectAttributes = null;   // If it's empty, we should return all the attributes in the specified table.
	//TODO: public ArrayList<Condition> conditionList;

	//TODO: used a different way of parsing from CreateTableInfo, should unify them later.
	public SelectInfo(ArrayList<String> queryElementIn) throws Exception {
		super(QueryType.SELECT);

		// Initialization
		tableList = new ArrayList<String>();
		selectAttributes = new ArrayList<Attribute>();

		String [] queryElement = new String[queryElementIn.size()];
		queryElement = (String[])queryElementIn.toArray(queryElement);

		// Check if the passed in query is right.
		if(queryElement[0].equals("select"))
			;
		else
			throw new Exception("[CreateTableInfo] It's not a 'create table' query, should be passed in.");

	}

}
