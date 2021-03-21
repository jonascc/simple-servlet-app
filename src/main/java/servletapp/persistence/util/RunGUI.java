package servletapp.persistence.util;

import org.hsqldb.util.DatabaseManagerSwing;

public class RunGUI {

	public static void main(String[] args) {
		System.out.println("Launching manager");

		DatabaseManagerSwing.main(new String[] 
				 //{"--url", "jdbc:hsqldb:file:db-data/mydatabase"}); // it is not possible to write to a file inside a dynamic web 
				{"--url", "jdbc:hsqldb:file:C:/HSQL_databases/simple-servlet-app/database01"});
	}

}
