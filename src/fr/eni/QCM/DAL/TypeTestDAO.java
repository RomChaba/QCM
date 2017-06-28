package fr.eni.QCM.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni.QCM.BO.TypeTest;
import fr.eni.QCM.utils.AccesBase;

public class TypeTestDAO {

	static String SQL_GET_ONE_TYPE_TEST = "SELECT * FROM TypeTest WHERE id = ?";
	static String SQL_GET_ALL_TYPE_TEST = "SELECT * FROM TypeTest";
	
	public static TypeTest getOne(int id) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		TypeTest typeTest = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_ONE_TYPE_TEST);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			
			while (rs.next()){
				typeTest = new TypeTest(
								rs.getInt("id"),
								rs.getString("libelle")
						);
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return typeTest;
	}
	
	public static ArrayList<TypeTest> getAll() throws SQLException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		ArrayList<TypeTest> types = new ArrayList<TypeTest>();
		
		try {
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.createStatement();			
			rs = rqt.executeQuery(SQL_GET_ALL_TYPE_TEST);
			TypeTest type;
			
			while (rs.next()){
				type = new TypeTest(
						rs.getInt("id"),
						rs.getString("libelle")
				);
					
				types.add(type);
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return types;
	}
}
