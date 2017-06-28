package fr.eni.QCM.DAL;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.QCM.BO.Section;
import fr.eni.QCM.utils.AccesBase;

public class SectionDAO {

	static String SQL_GET_ONE_SECTION = "SELECT * FROM Section WHERE id = ?";
	static String SQL_GET_ALL_SECTION = "SELECT * FROM Section";
	
	
	public static Section getOne(int id) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Section section = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_ONE_SECTION);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			
			while (rs.next()){
				section = new Section(
								rs.getInt("id"), 
								rs.getString("libelle"), 
								FormateurDAO.getOne(rs.getInt("idFormateur"))
						);
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return section;
	}
	public static ArrayList<Section> getAll() throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArrayList<Section> sections = new ArrayList<>();
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_ALL_SECTION);
			rs = rqt.executeQuery();
			while (rs.next()){
				sections.add(new Section(
								rs.getInt("id"), 
								rs.getString("libelle"), 
								FormateurDAO.getOne(rs.getInt("idFormateur"))
						));
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return sections;
	}
}
