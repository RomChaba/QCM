package fr.eni.QCM.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.QCM.BO.Candidat;
import fr.eni.QCM.utils.AccesBase;

public class CandidatDAO {

	static String SQL_INFO_UTILISATEUR = "SELECT * FROM Utilisateur WHERE login = ? AND password = ?";
	
	public static Candidat getCandidat(String login, String password) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Candidat candidat = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_INFO_UTILISATEUR);
			rqt.setString(1, login);
			rqt.setString(2, password);
			rs = rqt.executeQuery();
			
			while (rs.next()){
				candidat = new Candidat();	
				candidat.setId(rs.getInt("id"));
				candidat.setNom(rs.getString("nom"));
				candidat.setPrenom(rs.getString("prenom"));
				candidat.setMail(rs.getString("mail"));
				candidat.setLogin(rs.getString("login"));
				candidat.setPassword(rs.getString("password"));
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return candidat;
	}
}
