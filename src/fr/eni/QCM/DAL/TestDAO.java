package fr.eni.QCM.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.QCM.BO.Test;
import fr.eni.QCM.utils.AccesBase;

public class TestDAO {

	static String SQL_GET_ONE_TEST = "SELECT * FROM Test WHERE id = ?";
	
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
}
