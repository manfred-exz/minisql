package com.database.parser;

/**
 * Created by manfred on 11/2/14.
 */
public class UseInfo extends QueryInfo {
	String databaseName = null;

	public UseInfo(String _databaseName){
		super(QueryType.USE);

		//TODO: check if name is valid.
		databaseName = _databaseName;
	}
}
