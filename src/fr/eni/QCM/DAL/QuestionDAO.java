package fr.eni.QCM.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.QCM.BO.Question;
import fr.eni.QCM.utils.AccesBase;

public class QuestionDAO {

	static String SQL_GET_ONE_QUESTION = "SELECT * FROM Question WHERE id = ?";
	static String SQL_GET_NB_PAR_SECTION = "SELECT COUNT(*) nb FROM Question where idSection = ?";
	static String SQL_GET_QUESTION_FOR_SECTION = "SELECT * FROM Question WHERE idSection = ?";
	static String SQL_DELETE = "DELETE FROM Question WHERE id = ?";
	static String SQL_UPDATE = "UPDATE Question SET libelle = ?, idTypeQuestion = ?, idSection = ? WHERE id = ?";
	static String SQL_INSERT = "INSERT INTO Question(libelle, idSection, idTypeQuestion) VALUES(?, ?, ?)";
	 
	
	public static Question getOne(int id) throws SQLException {
		System.out.println("QuestionDAO > getOne");
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
	public static int getNbParSection(int id) throws SQLException {
		System.out.println("QuestionDAO > getNbParSection");
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Question question = null;
		int nb = 0;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_NB_PAR_SECTION);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			
			while (rs.next()){
				nb = rs.getInt("nb"); 	
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return nb;
	}
	
	public static ArrayList<Question> getQuestionForSection(int idSection) throws SQLException {
		System.out.println("QuestionDAO > getQuestionForSection");
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArrayList<Question> questions = new ArrayList<Question>();
		Question question = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_QUESTION_FOR_SECTION);
			rqt.setInt(1, idSection);
			rs = rqt.executeQuery();
			
			while (rs.next()){
				question = new Question(
								rs.getInt("id"), 
								rs.getString("libelle"), 
								rs.getString("image"), 
								SectionDAO.getOne(rs.getInt("idSection")), 
								TypeQuestionDAO.getOne(rs.getInt("idTypeQuestion"))
						);
				questions.add(question);
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return questions;
	}
	public static void delete(int idQuestion) throws SQLException {
		System.out.println("QuestionDAO > delete");
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_DELETE);
			rqt.setInt(1, idQuestion);
			rs = rqt.executeQuery();
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		
		}
	}
	
	public static void update(String libelle, int type, int idSection, int idQuestion) throws SQLException {
		System.out.println("QuestionDAO > update");
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_UPDATE);
			rqt.setString(1, libelle);
			rqt.setInt(2, type);
			rqt.setInt(3, idSection);
			rqt.setInt(4, idQuestion);
			rs = rqt.executeQuery();
			
		} catch (Exception e) {
			System.out.println(e);
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	public static void insert(String libelle, int idSection, int type) throws SQLException {
		System.out.println("QuestionDAO > insert");
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_INSERT);
			rqt.setString(1, libelle);
			rqt.setInt(2, idSection);
			rqt.setInt(3, type);
			rs = rqt.executeQuery();
			
		} catch (Exception e) {
			System.out.println(e);
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
	}
}
