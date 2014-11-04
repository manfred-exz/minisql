package com.database.parser;

/**
 * Created by manfred on 11/4/14.
 */
public class StringValue extends ConstantValue{
	public String stringValue = null;

	public StringValue(String _stringValue){
		stringValue = _stringValue;
	}

	@Override
	public Object getValue() {
		return stringValue;
	}
}
