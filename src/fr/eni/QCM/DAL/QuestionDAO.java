package fr.eni.QCM.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.QCM.BO.Question;
import fr.eni.QCM.utils.AccesBase;

public class QuestionDAO {

	static String SQL_GET_ONE_QUESTION = "SELECT * FROM Question WHERE id = ?";
	
	public static Question getOne(int id) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Question question = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_ONE_QUESTION);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			
			while (rs.next()){
				question = new Question(
								rs.getInt("id"), 
								rs.getString("libelle"), 
								rs.getString("image"), 
								SectionDAO.getOne(rs.getInt("idSection")), 
								TypeQuestionDAO.getOne(rs.getInt("idTypeQuestion"))
						);
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return question;
	}
}
