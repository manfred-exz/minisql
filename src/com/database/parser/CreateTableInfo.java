package com.database.parser;

import java.util.ArrayList;

/**
 * Created by manfred on 10/29/14.
 */
public class CreateTableInfo extends QueryInfo{
	public String tableName;
	public ArrayList<Attribute> attributes;
	public String primaryKeyName;



	public CreateTableInfo(ArrayList<String> queryElementIn) throws Exception{
		super(QueryType.CREATE_TABLE);

		// Initialization
		tableName = null;
		attributes = new ArrayList<Attribute>();
		primaryKeyName = null;

		String [] queryElement = new String[queryElementIn.size()];
		queryElement = (String[])queryElementIn.toArray(queryElement);

		// Check if the passed in query is right.
		if(queryElement[0].equals("create") && queryElement[1].equals("table"))
			;
		else
			throw new Exception("[CreateTableInfo] It's not a 'create table' query, should be passed in.");


		/*To Do: should check if the name if legal first.*/
		if(2 <queryElement.length)
			tableName = queryElement[2];

		if(3 < queryElement.length && queryElement[3].equals("("))
			;
		else
			throw new Exception("[CreateTableInfo]No ( found");

		int i = 4;
		String primaryKey;
		while(true) {

			// Determine whether to stop, if ')' is found then stop.
			if(i < queryElement.length)
				if(queryElement[i].equals(")"))
					break;
			else
				throw new Exception("[CreateTableInfo]Wrong format.");


			// Find primary key definition
			if(queryElement[i].equals("primary")){
				// At least 2 element are needed after "primary"
				if(i+2 < queryElement.length && queryElement[i+1].equals("key")){
					// TO DO: should check if the Name is legal.
					primaryKeyName = queryElement[i+2];
					i = i+3;
				}
				else
					throw new Exception("[CreateTableInfo]Wrong format.");
			}
			// Check if reached end.
			if(queryElement[i].equals(")"))
				break;

			// Find attributeName
			String attributeName = QueryInfo.parseAttributeName(queryElement[i]);
			if(attributeName == null)
				throw new Exception("[CreateTableInfo]Attribute name not right: " + attributeName);
			else
				i++;

			// Find attributeType
			String attributeType = QueryInfo.parseAttributeType(queryElement, i);
			if(attributeType == null)
				throw new Exception("[CreateTableInfo]Attribute type not right: " + attributeType);
			else
				i++;
			// Check if query is ended.
			if(queryElement[i].equals(")"))
				break;

			int attributeLength = QueryInfo.parseAttributeLength(queryElement, attributeType, i);
			if(attributeType.equals("char"))
				i = i+3;

			// Check if 'unique' is specified.
			boolean isUnique = false;
			if(i < queryElement.length && queryElement[i].equals("unique")) {
				isUnique = true;
				i++;
			}

			// Skip the ending comma','
			if(i < queryElement.length && queryElement[i].equals(","))
				i++;

			attributes.add(new Attribute(attributeName, attributeType, attributeLength, isUnique));

		}



	}


}
