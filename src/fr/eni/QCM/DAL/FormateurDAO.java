package fr.eni.QCM.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.QCM.BO.Formateur;
import fr.eni.QCM.utils.AccesBase;

public class FormateurDAO {

	static String SQL_LOGIN = "SELECT * FROM Utilisateur WHERE login = ? AND password = ?";
	static String SQL_GET_ONE_FORMATEUR = "SELECT * FROM Formateur WHERE id = ?";
	
	public static Formateur getOne(int id) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Formateur formateur = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_ONE_FORMATEUR);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			
			while (rs.next()){
				formateur = new Formateur(
						rs.getInt("id"), 
						rs.getString("nom"), 
						rs.getString("prenom"), 
						rs.getString("mail"), 
						rs.getString("login"),
						rs.getString("password")
						);
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return formateur;
	}
	
	public static Formateur getFormateur(String login, String password) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Formateur formateur = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_LOGIN);
			rqt.setString(1, login);
			rqt.setString(2, password);
			rs = rqt.executeQuery();
			
			while (rs.next()){
				formateur = new Formateur();	
				formateur.setId(rs.getInt("id"));
				formateur.setNom(rs.getString("nom"));
				formateur.setPrenom(rs.getString("prenom"));
				formateur.setMail(rs.getString("mail"));
				formateur.setLogin(rs.getString("login"));
				formateur.setPassword(rs.getString("password"));
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return formateur;
	}
}
