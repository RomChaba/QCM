package fr.eni.QCM.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.QCM.BO.Proposition;
import fr.eni.QCM.utils.AccesBase;

public class PropositionDAO {

	static String SQL_GET_ONE_PROPOSITION = "SELECT * FROM Proposition WHERE id = ?";
	static String SQL_GET_ALL = "SELECT * FROM Proposition";
	static String SQL_GET_ALL_FOR_QUESTION = "SELECT * FROM Proposition WHERE idQuestion = ?";
	static String SQL_INSERT_PROPO = "INSERT INTO Proposition (libelle,reponse,idQuestion) VALUES (?,?,?)";
	static String SQL_UPDATE_PROPO = "UPDATE Proposition SET libelle = ? AND reponse = ? WHERE id = ?";
	static String SQL_DELETE_PROPO = "DELETE FROM Proposition WHERE id = ?";
	
	
	
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
								QuestionDAO.getOne(rs.getInt("idQuestion"))
						);
			}
			
		}catch(Exception e){
			System.out.println("PROPOSITIONDAO FONCTION : getOne");
			System.out.println(e);
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return proposition;
	}
	public static ArrayList<Proposition> getAll() throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArrayList<Proposition> proposition = new ArrayList<>();
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_ALL);
			rs = rqt.executeQuery();
			
			while (rs.next()){
				proposition.add(new Proposition(
								rs.getInt("id"), 
								rs.getString("libelle"), 
								rs.getBoolean("reponse"), 
								QuestionDAO.getOne(rs.getInt("idQuestion"))
						));
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return proposition;
	}
	//Récupération des propostion en fonction d'un id de question
	public static ArrayList<Proposition> getPropForQuest(int idQuestion) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArrayList<Proposition> proposition = new ArrayList<>();
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_ALL_FOR_QUESTION);
			rs = rqt.executeQuery();
			
			while (rs.next()){
				proposition.add(new Proposition(
								rs.getInt("id"), 
								rs.getString("libelle"), 
								rs.getBoolean("reponse"), 
								QuestionDAO.getOne(rs.getInt("question"))
						));
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return proposition;
	}
	
	//Insert d'une nouvelle Proposition
	public static void creerPropo(String libelle,int reponse,int idQuestion) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_INSERT_PROPO);
			//(libelle,reponse,idQuestion)
			rqt.setString(1, libelle);
			rqt.setInt(2, reponse);
			rqt.setInt(3, idQuestion);
			rs = rqt.executeQuery();
			
			
		}catch(Exception e){
			System.out.println("PROPOSITIONDAO FONCTION : creerPropo");
			System.out.println(e);
		}
		finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}

	
	//DELETE d'une Proposition
	public static void delPropo(int idProp) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_DELETE_PROPO);
			rqt.setInt(1, idProp);
			rs = rqt.executeQuery();
			
			
		}catch(Exception e){
			System.out.println("PROPOSITIONDAO FONCTION : delPropo");
			System.out.println(e);
		}
		finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	//Insert d'une nouvelle Proposition
		public static void updatePropo(String libelle,int reponse,int idPropo) throws SQLException {
			Connection cnx = null;
			PreparedStatement rqt = null;
			ResultSet rs = null;
			try{
				cnx = AccesBase.recupererConnexionJDBC();
				rqt = cnx.prepareStatement(SQL_UPDATE_PROPO);
				
				rqt.setString(1, libelle);
				rqt.setInt(2, reponse);
				rqt.setInt(3, idPropo);
				rs = rqt.executeQuery();
				
				
			}catch(Exception e){
				System.out.println("PROPOSITIONDAO FONCTION : updatePropo");
				System.out.println(e);
			}
			finally{
				if (rs!=null) rs.close();
				if (rqt!=null) rqt.close();
				if (cnx!=null) cnx.close();
			}
		}
	
	
}

//updatePropo

