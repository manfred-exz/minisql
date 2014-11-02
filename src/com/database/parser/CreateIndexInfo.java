package com.database.parser;

/**
 * Created by manfred on 11/2/14.
 */
public class CreateIndexInfo extends QueryInfo{
	String indexName = null;
	String tableName = null;
	String attributeName = null;

	public CreateIndexInfo(String _indexName, String _tableName, String _attributeName) {
		super(QueryType.CREATE_INDEX);

		//TODO: check whether the attribute exists in the table, and is a unique key.
		indexName = _indexName;
		tableName = _tableName;
		attributeName = _attributeName;
	}
}
