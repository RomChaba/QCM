package fr.eni.QCM.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.QCM.BO.Candidat;
import fr.eni.QCM.BO.Formateur;
import fr.eni.QCM.utils.AccesBase;

public class UtilisateurDAO {
	static String SQL_TYPE_USER = "SELECT TypeUser = CASE WHEN c.idUtilisateur IS NOT NULL THEN 2 WHEN f.idUtilisateur IS NOT NULL THEN 1 ELSE 3 END FROM Utilisateur u LEFT JOIN Candidat c on c.idUtilisateur = u.id LEFT JOIN Formateur f on f.idUtilisateur = u.id where login = ? and password = ?";
	
	public static int testConnexion(String login, String password) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		int typeUser = 0;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_TYPE_USER);
			rqt.setString(1, login);
			rqt.setString(2, password);
			rs = rqt.executeQuery();
			
			while (rs.next()){
				typeUser = rs.getInt("TypeUser");		
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return typeUser;
	}
}
