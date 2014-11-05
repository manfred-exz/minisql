package com.database.parser;

/**
 * "Help" query.
 * Created by manfred on 11/2/14.
 */
public class HelpInfo extends QueryInfo {
	//TODO: help topic is not decided yet.
	String helpTopic = null;

	public HelpInfo(){
		super(QueryType.HELP);
	}
}
