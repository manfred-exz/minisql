package com.database.parser;

/**
 * Created by manfred on 10/29/14.
 */
public class Attribute {
	public final static String INT_TYPE = "int";
	public final static String CHAR_TYPE = "char";
	public final static String FLOAT_TYPE = "float";

	//TODO: table name not added into constructor.
	// tableName = null means: which table it belong to is not specified.
	private String tableName = null;
	private String attributeName = null;
	private String attributeType = null;
	private int attributeLength = 0;
	private boolean isUnique = false;

	public Attribute(String newAttributeName, String newTableName){
		attributeName = newAttributeName;
		tableName = newTableName;
	}

	public Attribute(String newAttributeName, String newAttributeType,int newAttributeLength, boolean newIsUnique){
		attributeName = newAttributeName;
		attributeType = newAttributeType;
		attributeLength = newAttributeLength;
		isUnique = newIsUnique;
	}

	public Attribute(String newAttributeName, String newAttributeType, int newAttributeLength){
		attributeName = newAttributeName;
		attributeType = newAttributeType;
		attributeLength = newAttributeLength;
		isUnique = false;
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



}
