package com.database.parser;

/**
 *
 * Created by manfred on 10/29/14.
 */

/**
 * Attribute describe the attribute in the query like "select attr_1, attr_2, ... from table_name where ..."
 * It can be in the form <b>table_name.attribute_name</b> or only <b>attribute_name</b>
* To simplify the storage of conditionNode, Constant like <b>string</b>, <b>int</b>, <b>float</b> are also considered Attribute.
* Thus, before using any attribute, you should check if the type is what you want.
* */
public class Attribute {
	public final static String INT_TYPE = "int";
	public final static String CHAR_TYPE = "char";
	public final static String FLOAT_TYPE = "float";
	public final static String CONSTANT_TYPE = "constant";

	//TODO: table name not added into constructor.
	// indexName = null means: which table it belong to is not specified.
	private String tableName = null;
	private String attributeName = null;
	private String attributeType = null;
	private int attributeLength = 0;
	private ConstantValue constant = null;
	private boolean isUnique = false;

	public Attribute(String _attributeName, String _tableName){
		attributeName = _attributeName;
		tableName = _tableName;
	}

	public Attribute(String _attributeType, ConstantValue _constant){
		attributeType = _attributeType;
		constant = _constant;

	}

	public Attribute(String _attributeName, String _attributeType,int _attributeLength, boolean _isUnique){
		attributeName = _attributeName;
		attributeType = _attributeType;
		attributeLength = _attributeLength;
		this.isUnique = _isUnique;
	}

	public Attribute(String _attributeName, String _attributeType, int _attributeLength){
		attributeName = _attributeName;
		attributeType = _attributeType;
		attributeLength = _attributeLength;
		isUnique = false;
	}

	public ConstantValue getConstant(){
		return constant;
	}

	public void setConstant(ConstantValue _constant){
		constant = _constant;
	}

	public String getAttributeName(){
		return attributeName;
	}

	public void setAttributeName(String newName){
		attributeName = newName;
	}

	public String getAttributeType(){
		return attributeType;
	}

	public void setAttributeType(String newType){
		attributeType = newType;
	}

	public String getTableName(){
		return tableName;
	}

	public boolean isUnique(){
		return isUnique;
	}

	public void setUnique(boolean newIsUnique){
		isUnique = newIsUnique;
	}

	public static boolean isAttributeName(String attributeName){
		for (int i = 0; i < attributeName.length(); i++) {
			if(!Character.isAlphabetic(attributeName.charAt(i)))
				return false;
		}
		return true;
	}

	public static boolean isAttributeType(String attributeType){
		if(attributeType.equals(CHAR_TYPE) || attributeType.equals(INT_TYPE) || attributeType.equals(FLOAT_TYPE))
			return true;

		return false;
	}


	public int getAttributeLength() {
		return attributeLength;
	}
}
