package com.database.parser;

/**
 * Created by manfred on 11/2/14.
 */
public class HelpInfo extends QueryInfo {
	//TODO: help topic is not decided yet.
	String helpTopic = null;

	public HelpInfo(String _helpTopic){
		super(QueryType.HELP);

		// TODO: check if the topic exists.
		helpTopic = _helpTopic;
	}
}
