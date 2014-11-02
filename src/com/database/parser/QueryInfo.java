package com.database.parser;

import java.util.ArrayList;

/**
 * Created by manfred on 11/2/14.
 */
public class QueryInfo {
	QueryType queryType = null;

	QueryInfo(QueryType _queryType){
		queryType = _queryType;
	}

	static String parseAttributeName( String [] parseElement, int index) {
		String attributeName = null;
		if(index < parseElement.length) {
			if(!Attribute.isAttributeName(parseElement[index]))
				return null;
			attributeName = parseElement[index];
			index++;
		}else{
			return null;
		}
		return attributeName;
	}

	static String parseAttributeType( String [] parseElement, int index) {
		String attributeType = null;
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
		else
			;
//			throw new Exception("[parseAttributeLength]Type not supported for variable length " + attributeType);


		return attributeLength;
	}

	static int parseFromTable( String [] parseElement, int index) throws Exception {
		ArrayList<String> tableNameList = new ArrayList<String>();
		int fromIndex = -1;

		for (int i = 0; i < parseElement.length; i++) {
			if(parseElement[i].equals("from"))
				fromIndex = i;
		}

		if(fromIndex == -1)
			throw new Exception(QueryInfo.class + ": " + "no 'from' clause found in select query.");



		return 0;
	}
};