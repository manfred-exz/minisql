package com.database.parser;

/**
 * ConditionNode is used to store the conditions in where clause.
 * ConditionTree is not implemented yet, since it's not required, but we may implement it in later version.
 * Created by manfred on 11/2/14.
 */
public class ConditionNode {

	private Operator operator;
	public Attribute leftOperand = null;
	public Attribute rightOperand = null;
	public Attribute betweenOperand = null;
	private ConditionNode leftNode = null;
	private ConditionNode rightNode = null;

	ConditionNode(Operator _operator) {
		operator = _operator;
	}

	public void addLeftNode(ConditionNode _leftNode){
		leftNode = _leftNode;
	}

	public void addRightNode(ConditionNode _rightNode){
		rightNode = _rightNode;
	}

	public  String getOperator() {
		return  operator.getOperator();
	}
}
