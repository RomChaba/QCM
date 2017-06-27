package fr.eni.QCM.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.QCM.BO.TypeQuestion;
import fr.eni.QCM.utils.AccesBase;

public class TypeQuestionDAO {

	static String SQL_GET_ONE_TYPE_QUESTION = "SELECT * FROM TypeQues WHERE id = ?";
	
	public static TypeQuestion getOne(int id) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		TypeQuestion typeQuestion = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_ONE_TYPE_QUESTION);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			
			while (rs.next()){
				typeQuestion = new TypeQuestion(
								rs.getInt("id"),
								rs.getString("libelle")
						);
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return typeQuestion;
	}
}
