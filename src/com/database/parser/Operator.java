package com.database.parser;

/**
 * Created by manfred on 11/2/14.
 */
public enum Operator {
	EQUAL("="), NOT_EQUAL("!="),
	GREATER_THAN(">"), LESS_THAN("<"),
	GREATER_EQUAL(">="), LESS_EQUAL("<="),
	BETWEEN("between");

	String operator;


	Operator(String _operator) {
		operator = _operator;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
}
