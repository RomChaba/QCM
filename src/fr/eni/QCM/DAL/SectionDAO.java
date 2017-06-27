package fr.eni.QCM.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.QCM.BO.Section;
import fr.eni.QCM.utils.AccesBase;

public class SectionDAO {

	static String SQL_GET_ONE_SECTION = "SELECT * FROM Section WHERE id = ?";
	
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
}
