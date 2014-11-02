package com.database.parser;

import java.util.ArrayList;

/**
 * Created by manfred on 11/2/14.
 * This is a abstract root class of all kinds of query class.
 */
public abstract class QueryInfo {
	QueryType queryType = null;

	QueryInfo(QueryType _queryType){
		queryType = _queryType;
	}

	static String parseAttributeName(String parseElement) {
			if(!Attribute.isAttributeName(parseElement))
				return null;
			else
				return parseElement;

	}

	static String parseAttributeType( String [] parseElement, int index) {
		String attributeType;
		if(index < parseElement.length){
			attributeType = parseElement[index];
			if(!Attribute.isAttributeType(attributeType)){
				return null;
			}
		}else
			return null;

		return attributeType;
	}

	static int parseAttributeLength( String [] parseElement,String attributeType, int index) throws Exception {
		int attributeLength = 1;
		if(attributeType.equals("char")){
			// at least 3 elements is after "char" if (length) is to be specified.
			if(index+2 < parseElement.length && parseElement[index].equals("(") && parseElement[index+2].equals(")")) {
				attributeLength = Integer.parseInt(parseElement[index + 1]);
			}
		}
		// TODO: the length of int and float may be added.

//			throw new Exception("[parseAttributeLength]Type not supported for variable length " + attributeType);


		return attributeLength;
	}
	
	
	static String parseTableName(String parseElement){
		if(isTableName(parseElement))
			return parseElement;
		else
			return null;
	}

	static Attribute parseAttributeNameWithTable(String parseElement) throws Exception {
		int indexOfDot = parseElement.indexOf('.');

		String tableName = null;
		String attributeName;
		if(indexOfDot != -1){
			// dot(.) found, attribute in table.attr form.
			tableName = parseTableName(parseElement.substring(0, indexOfDot));
			if(tableName == null)
				throw new Exception(QueryInfo.class + "parseAttributeNameInSelect: table Name not valid.");


			attributeName = parseAttributeName(parseElement.substring(indexOfDot+1));
			if(attributeName == null)
				throw new Exception(QueryInfo.class + "parseAttributeNameInSelect: attribute Name not valid.");
		}
		else
			attributeName = parseElement;

		return new Attribute(attributeName,tableName);
	}

	static String [] parseFromTable( String [] parseElement, int index) throws Exception {
		ArrayList<String> tableNameList = new ArrayList<String>();
		int fromIndex = -1;

		// Check if FROM 'clause' exists in the query. Search from index specified, because their can be more From in one query.
		for (int i = index; i < parseElement.length; i++) {
			if(parseElement[i].equals("from"))
				fromIndex = i;
		}
		// if not then it's a wrong query.
		if(fromIndex == -1)
			throw new Exception(QueryInfo.class + ": " + "no 'from' clause found in select query.");


		for (int i = fromIndex+1;
		     i < parseElement.length && !parseElement[i].equals(";") && !parseElement[i].equals("where"); // Stops checking table name when ';' or 'where' is found.
		     i++)
		{
			// skip comma, (which means in our parser, you can keep or omit comma, it doesn't matter.
			String comma = parseElement[i];
			if(comma.equals(",")){
				continue;
			}

			// Find next table name
			String element = parseElement[i];
			if(!isTableName(element))
				throw new Exception(QueryInfo.class + "[parseFromTable], invalid table name");
			else
				tableNameList.add(element);

		}

		if(tableNameList.size() == 0){
			return null;
		}

//		String [] returnTableList =  new String[tableNameList.size()];
		String [] returnTableList;
		returnTableList = (String [])tableNameList.toArray();


		return returnTableList;
	}

	static Attribute [] parseSelectAttributes(String [] parseElement, int index) throws Exception {
		ArrayList<Attribute> attributesList = new ArrayList<Attribute>();
		int fromIndex = -1;

		// Check if Select clause exists in the query. Search from index specified, because their can be more Select in one query.
		for (int i = index; i < parseElement.length; i++) {
			if(parseElement[i].equals("select"))
				fromIndex = i;
		}
		// if not then it's a wrong query.
		if(fromIndex == -1)
			throw new Exception(QueryInfo.class + ": " + "no 'from' clause found in select query.");

		// Check if * is specified
		if(parseElement[fromIndex+1].equals("*"))
			return null;

		// Check all the attributes following if not *
		for (int i = fromIndex+1;
		     i < parseElement.length && !parseElement[i].equals("from"); // Stops checking table name when ';' or 'from' is found.
		     i++)
		{
			// skip comma, (which means in our parser, you can keep or omit comma, it doesn't matter.
			String comma = parseElement[i];
			if(comma.equals(",")){
				continue;
			}

			// Find next attribute name
			attributesList.add( parseAttributeNameWithTable(parseElement[i]) );


			/*if(!isAttributeName(element))
				throw new Exception(QueryInfo.class + "[parseFromTable], invalid table name");
			else{
				int indexOfDot = -1;
				String tableName;
				String attributeName;
				if( (indexOfDot = element.indexOf('.')) != -1 ) {
					if(isTableName(element.substring(0, indexOfDot)))
						tableName = element.substring(0, indexOfDot);
					else
						throw new Exception(QueryInfo.class + "[parseFromTable], invalid table name");
					attributeName = element.substring(indexOfDot+1);
				}
				else
				//TODO
					;
				
			}*/

		}

		return (Attribute[]) attributesList.toArray();
	}



	static boolean isTableName(String tableName){
		return true;
	}

	//TODO: Check if attribute name exists.
	static boolean isAttributeName(String attributeName){
		return true;
	}
};