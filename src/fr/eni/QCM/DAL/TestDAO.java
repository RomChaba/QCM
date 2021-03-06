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

	static String SQL_GET_ONE = "SELECT * FROM Test WHERE id = ?";
	static String SQL_GET_ALL = "SELECT * FROM Test";
	static String SQL_DELETE = "DELETE FROM Test WHERE id = ?";
	static String SQL_ADD = "INSERT INTO TEST VALUES(?, ?, ?, ?)";
	static String SQL_GET_ONE_BY_LIBELLE = "SELECT * FROM Test WHERE libelle like ?";
	static String SQL_UPDATE = "UPDATE Test SET libelle = ? , timer = ? , idTypeTest = ? WHERE id = ?";
	
	public static Test getOne(int id) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Test test = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_ONE);
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
	
	public static Test getOneByLibelle(String libelle) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Test test = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_ONE_BY_LIBELLE);
			rqt.setString(1, libelle);
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
			
		}catch(Exception e){
			System.out.println(e);
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
			rs = rqt.executeQuery(SQL_GET_ALL);
			Test test;
			
			while (rs.next()){
				test = new Test(
							rs.getInt("id"), 
							rs.getString("libelle"), 
							rs.getInt("timer"), 
							FormateurDAO.getOne(rs.getInt("idFormateur")), 
							TypeTestDAO.getOne(rs.getInt("idTypeTest"))
						);
					
				tests.add(test);
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return tests;
	}

	public static void delete(int id) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_DELETE);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
	}
	
	public static Test add(String libelle, int timer, int idFormateur, int idTypeTest) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Test test = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_ADD);
			rqt.setString(1, libelle);
			rqt.setInt(2, timer);
			rqt.setInt(3, idFormateur);
			rqt.setInt(4, idTypeTest);
			rs = rqt.executeQuery();
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return test;
	}

	public static void update(int id, String libelle, int timer, int idTypeTest) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_UPDATE);
			rqt.setString(1, libelle);
			rqt.setInt(2, timer);
			rqt.setInt(3, idTypeTest);
			rqt.setInt(4, id);
			rs = rqt.executeQuery();
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		
		}
	}
}
