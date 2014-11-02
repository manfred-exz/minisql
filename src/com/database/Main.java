package com.database;

public class Main {

    public static void main(String[] args) {
	    Interpreter interpreter = new Interpreter();
        interpreter.getQuery();
        System.out.println(interpreter.getQueryString());
	    try {
		    interpreter.parseQuery();
	    } catch (Exception e) {
		    e.printStackTrace();
	    }

    }
}
