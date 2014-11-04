package com.database.parser;

/**
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
