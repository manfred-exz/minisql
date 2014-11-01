package com.database.parser;

/**
 * Created by manfred on 10/29/14.
 */
public class Attribute {
	public final static String INT_TYPE = "int";
	public final static String CHAR_TYPE = "char";
	public final static String FLOAT_TYPE = "float";

	private String attributeName = null;
	private String attributeType = null;
	private int attributeLength = 0;
	private boolean isUnique = false;

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
		else
			return false;
	}

	static String parseAttributeName( String [] parseElement, int i) {
		String attributeName = null;
		if(i < parseElement.length) {
			if(!Attribute.isAttributeName(parseElement[i]))
				return null;
			attributeName = parseElement[i];
			i++;
		}else{
			return null;
		}
		return attributeName;
	}

	static String parseAttributeType( String [] parseElement, int i) {
		String attributeType = null;
		if(i < parseElement.length){
			attributeType = parseElement[i];
			i++;
			if(!Attribute.isAttributeType(attributeType)){
				return null;
			}
		}else
			return null;

		return attributeType;
	}

	static int parseAttributeLength( String [] parseElement,String attributeType, int i) throws Exception {
		int attributeLength = 1;
		if(attributeType.equals("char")){
			// at least 3 elements is after "char" if (length) is to be specified.
			if(i+2 < parseElement.length && parseElement[i].equals("(") && parseElement[i+2].equals(")")) {
				attributeLength = Integer.parseInt(parseElement[i + 1]);
			}
		}
		// TODO: the length of int and float may be added.
		else
			;
//			throw new Exception("[parseAttributeLength]Type not supported for variable length " + attributeType);


		return attributeLength;
	}

}
