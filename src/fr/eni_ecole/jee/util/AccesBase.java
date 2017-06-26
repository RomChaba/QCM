package fr.eni_ecole.jee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesBase {

	static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	static String url = "jdbc:sqlserver://10.1.0.207;databaseName=QCM;";
	static String login = "sa";
	static String mdp = "Pa$$w0rd";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le driver JDBC");
			//e.printStackTrace();
		}
	}
	
	public static Connection recupererConnexionJDBC() {
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, login, mdp);
		} catch (SQLException e) {
			System.err.println("Impossible d'initialiser une connexion");
			// e.printStackTrace();
		}
		
		return connection;

	}
	
	
	
	
	
}
