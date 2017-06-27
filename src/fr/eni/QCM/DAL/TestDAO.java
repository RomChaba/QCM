package fr.eni.QCM.DAL;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.QCM.BO.Test;
import fr.eni.QCM.utils.AccesBase;

public class TestDAO {

	static String SQL_GET_ONE_TEST = "SELECT * FROM Test WHERE id = ?";
	static String SQL_GET_ALL_TEST = "SELECT * FROM Test";
	
	public static Test getOne(int id) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Test test = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_ONE_TEST);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			
			while (rs.next()){
				test = new Test(
						rs.getInt("id"), 
						rs.getString("libelle"), 
						rs.getInt("timer"), 
						FormateurDAO.getOne(rs.getInt("idFormateur")), 
						TypeTestDAO.getOne(rs.getInt("idTypeTest"))
						);
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return test;
	}
	
	public static ArrayList<Test> getAll() throws SQLException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		ArrayList<Test> tests = new ArrayList<Test>();
		
		try {
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.createStatement();			
			rs = rqt.executeQuery(SQL_GET_ALL_TEST);
			Test test;
			
			while (rs.next()){
				test = new Test();
					test.setId(rs.getInt("id"));
					test.setLibelle(rs.getString("libelle"));
					test.setTimer(rs.getInt("timer"));
					test.setFormateur(FormateurDAO.getOne(rs.getInt("idFormateur")));
					test.setTypeTest(TypeTestDAO.getOne(rs.getInt("idTypeTest")));
					
				tests.add(test);
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return tests;
	}
}
