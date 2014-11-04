package com.database.parser;

/**
 * Created by manfred on 11/4/14.
 */
public class IntValue extends ConstantValue {
	public int intValue = 0;

	public IntValue(int _intValue){
		intValue = _intValue;
	}

	@Override
	public Object getValue() {
		return intValue;
	}
}
