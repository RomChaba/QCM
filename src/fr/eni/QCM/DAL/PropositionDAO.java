package fr.eni.QCM.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.QCM.BO.Proposition;
import fr.eni.QCM.utils.AccesBase;

public class PropositionDAO {

	static String SQL_GET_ONE_PROPOSITION = "SELECT * FROM Proposition WHERE id = ?";
	
	public static Proposition getOne(int id) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Proposition proposition = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_ONE_PROPOSITION);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			
			while (rs.next()){
				proposition = new Proposition(
								rs.getInt("id"), 
								rs.getString("libelle"), 
								rs.getBoolean("reponse"), 
								QuestionDAO.getOne(rs.getInt("question"))
						);
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return proposition;
	}
}
