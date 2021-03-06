package com.database;

import com.database.parser.*;
import java.util.*;

/**
 * Get and Parse query.
 * Interpreter is used to get a query and parse it into detailed information.
 * Generally, you can create an Interpreter object, getQuery(), and parseQuery(), then you can getQueryInfo() to use the information in different query.
 * Created by manfred on 10/21/14.
 */
public class Interpreter {
    private String queryString;
    private QueryInfo queryInfo;

    /**
     * Get a complete query.(Any String terminated with ';')
     * Note that new line(\r, \n) is eliminated
     * @return whether the query is successfully got.
     * */
    public boolean getQuery(){
	    // Get a string ended with ';', note that newline like '\n' is kept.
        Scanner keyboard = new Scanner(System.in).useDelimiter(";");
        this.queryString = keyboard.next();

	    // Get rid of any 'new line' character
	    // Efficiency can be improved
	    queryString = queryString.replaceAll("[\n\r]", "");

        return true;
    }


	/**
	 * Return the string got. Check if is null before use.
	 * */
    public String getQueryString(){
        return this.queryString;
    }

	public QueryInfo getQueryInfo(){
		return queryInfo;
	}

	/**
	 * parse the query got.
	* */
    public void parseQuery() throws Exception {

	    if(queryString == null)
		    throw new Exception("Please call getQuery before parseQuery.");

	    ArrayList<String> queryElement;

	    // Split the query into individual element.
		queryElement = splitIntoElements(queryString);

	    /* Debug */
/*	    Iterator<String> iterator =  queryElement.iterator();
	    while(iterator.hasNext())
		    System.out.println(iterator.next());*/

		if( queryElement.get(0).equals("create") && queryElement.get(1).equals("table"))
			queryInfo = new CreateTableInfo(queryElement);
		else if(queryElement.get(0).equals("create") && queryElement.get(1).equals("index"))
			queryInfo = new CreateIndexInfo(queryElement);
		else if(queryElement.get(0).equals("create") && queryElement.get(1).equals("database"))
			queryInfo = new CreateDatabaseInfo(queryElement);
	    else if(queryElement.get(0).equals("select"))
			queryInfo = new SelectInfo(queryElement);
		else if(queryElement.get(0).equals("insert") && queryElement.get(1).equals("into"))
			queryInfo = new InsertInfo(queryElement);
		else if(queryElement.get(0).equals("delete") && queryElement.get(1).equals("from"))
			queryInfo = new DeleteInfo(queryElement);
	    else if(queryElement.get(0).equals("drop") && queryElement.get(1).equals("table"))
			queryInfo = new DropTableInfo(queryElement);
	    else if(queryElement.get(0).equals("drop") && queryElement.get(1).equals("database"))
			queryInfo = new DropDatabaseInfo(queryElement);
	    else if(queryElement.get(0).equals("drop") && queryElement.get(1).equals("index"))
			queryInfo = new DropIndexInfo(queryElement);
	    else if(queryElement.get(0).equals("use"))
			queryInfo = new UseInfo(queryElement);
		else if(queryElement.get(0).equals("help"))
			queryInfo = new HelpInfo();
	    else if(queryElement.get(0).equals("quit"))
			queryInfo = new QuitInfo();
	    else
			throw new Exception("There's no query of this type!");



    }

	//TODO: cannot parse operators like ">=" right now. You should type in "_>=_", '_' means whitespace.
	private ArrayList<String> splitIntoElements(String string) throws Exception {
		System.out.println("[Debug]Entering...");
		ArrayList<String> element = new ArrayList<String>();

		String separators = "()*,;";
		String quotes = "\'\"";
		String special = separators + quotes;

		int front;
		outer:
		for (int i = 0; i < string.length(); i++) {
			char processingChar = string.charAt(i);

			// Skip the preceding space.
			while(string.charAt(i) == ' ') {
				i++;
				if(i < string.length())
					processingChar = string.charAt(i);
				else
					break outer;
			}

			// If special separator char matched, add to element, and skip.
			if(separators.indexOf(processingChar) != -1) {
				element.add(string.substring(i, i+1));
				continue;
			}

			// If start of a quote found, then find the next quote mark, add to element, and skip.
			front = i;
			int interval;
			// If the processing char is a quote mark
			if(quotes.indexOf(processingChar) != -1){
				// find the next quote-mark in the following string.
				if ((interval = string.substring(i + 1).indexOf(processingChar))
						!= -1) {
					element.add(string.substring(front, front + 2 + interval));
					i = front + interval + 1;
					continue;
				} else
					throw new Exception("The second quote mark is missing. Please check your query and type again");
			}

			/* TO DO !!!*/
			// If a continuous word(ended with whitespace or special chars) is found then add to element, and skip;
			front = i;
			while(i < string.length() &&
					( !(string.charAt(i) == ' '  ||  special.indexOf(string.charAt(i)) != -1)) )
				i++;
			element.add(string.substring(front, i).toLowerCase());
			if(i == string.length())
				break;

			// return the special char if skipped.
			if(special.indexOf(string.charAt(i)) != -1)
				i--;

		}

		return element;

	}

}

