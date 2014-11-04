package com.database.parser;

/**
 * Created by manfred on 11/4/14.
 */
public class DoubleValue extends ConstantValue {
	public double DoubleValue = 0;

	public DoubleValue(double _doubleValue){
		DoubleValue = _doubleValue;
	}

	@Override
	public Object getValue() {
		return DoubleValue;
	}
}
