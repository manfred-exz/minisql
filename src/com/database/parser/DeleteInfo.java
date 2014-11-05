package com.database.parser;

import java.util.ArrayList;

/**
 * "Delete" query.
 * Created by manfred on 11/2/14.
 */
public class DeleteInfo extends QueryInfo {
	public String [] tableList = null;
	public ArrayList<ConditionNode> conditionList;  //TODO: Now the ConditionList only support the condition-form "condition-1 and condition-2 and condition-3 and ..." may support free form in future.
//	private ConditionNode conditionTree = null;

	//TODO: used a different way of parsing from CreateTableInfo, should unify them later.
	public DeleteInfo(ArrayList<String> queryElementIn) throws Exception {
		super(QueryType.DELETE);

		String [] queryElement = new String[queryElementIn.size()];
		queryElement = (String[])queryElementIn.toArray(queryElement);

		// Check if the passed in query is right.
		if(!queryElement[0].equals("delete"))
			throw new Exception(DeleteInfo.class + ": " +  "It's not a 'Delete' query, should not be passed in.");

		// seek to the 'From' part, and check the find all the tables used in the query.
		if( (tableList = parseFromTable(queryElement, 0)) == null)
			throw new Exception(DeleteInfo.class + "[DeleteInfo]: " +  "Not From clause found.");

		conditionList = parseWhere(queryElement, 0);



	}

}
