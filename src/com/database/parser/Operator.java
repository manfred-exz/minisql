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

	static public boolean isOperator(String operator){
		if( operator.equals("=") || operator.equals("!=") || operator.equals(">") || operator.equals("<") ||
				operator.equals(">=") || operator.equals("<=") || operator.equals("between"))
			return true;
		else
			return false;
	}

	static  Operator getOperatorFromString(String operator){
		if(operator.equals("="))
			return Operator.EQUAL;
		else if(operator.equals("!="))
			return  Operator.NOT_EQUAL;
		else if(operator.equals(">"))
			return  Operator.GREATER_THAN;
		else if(operator.equals("<"))
			return  Operator.LESS_THAN;
		else if(operator.equals(">="))
			return  Operator.GREATER_EQUAL;
		else if(operator.equals("<="))
			return  Operator.LESS_EQUAL;
		else if(operator.equals("between"))
			return  Operator.BETWEEN;
		else
			return null;
	}
}
