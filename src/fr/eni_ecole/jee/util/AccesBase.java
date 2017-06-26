package fr.eni_ecole.jee.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AccesBase {
	static Context initContext = null;
	static Context envContext = null;
	static DataSource dataSource = null;
	
	static {
		try {
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/formations");
			
		} catch (NamingException e) {
			System.err.println("### AccesBase.java ###");
			System.out.println(e);
			System.err.println("### AccesBase.java ###");
		}
	}
	
	public static Connection getConnection() throws SQLException{
		
		Connection connexion = null;
		
		if(dataSource != null){
			connexion = dataSource.getConnection();
		}
		return connexion;
	}
}
