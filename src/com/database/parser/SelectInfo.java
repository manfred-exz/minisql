package com.database.parser;

import java.util.ArrayList;

/**
 * Created by manfred on 11/2/14.
 */
public class SelectInfo extends QueryInfo {
	public String [] tableList = null;
	public Attribute [] selectAttributes = null;   // If it's empty, we should return all the attributes in the specified table.
	public ArrayList<ConditionNode> conditionList;  //TODO: Now the ConditionList only support the condition-form "condition-1 and condition-2 and condition-3 and ..." may support free form in future.
//	private ConditionNode conditionTree = null;

	//TODO: used a different way of parsing from CreateTableInfo, should unify them later.
	public SelectInfo(ArrayList<String> queryElementIn) throws Exception {
		super(QueryType.SELECT);

		String [] queryElement = new String[queryElementIn.size()];
		queryElement = (String[])queryElementIn.toArray(queryElement);

		// Check if the passed in query is right.
		if(!queryElement[0].equals("select"))
			throw new Exception(SelectInfo.class + ": " +  "It's not a 'Select' query, should not be passed in.");

		// seek to the 'From' part, and check the find all the tables used in the query.
		if( (tableList = parseFromTable(queryElement, 0)) == null)
			throw new Exception(SelectInfo.class + "[SelectInfo]: " +  "Not From clause found.");

		// seek to the 'Select' part and check if any attributes specified.
		selectAttributes = parseSelectAttributes(queryElement, 0);

		conditionList = parseWhere(queryElement, 0);



	}

}
