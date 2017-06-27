package fr.eni.QCM.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.QCM.BO.Candidat;
import fr.eni.QCM.BO.Formateur;
import fr.eni.QCM.DAL.CandidatDAO;
import fr.eni.QCM.DAL.FormateurDAO;
import fr.eni.QCM.DAL.UtilisateurDAO;
import fr.eni.QCM.utils.*;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class ConnexionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ConnexionController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		try {
			int typeUser = UtilisateurDAO.testConnexion("antoine", "e3d96c321f2a71cb81cd7d5f05f1a8d7");
	    	
			// Formateur
			if(typeUser == 1) { 
				Formateur formateur = FormateurDAO.getFormateur("antoine", "e3d96c321f2a71cb81cd7d5f05f1a8d7");
	    		request.getRequestDispatcher("/ListeTest").forward(request, response);
	    		
			// Candidat
			} else if(typeUser == 2) {
				Candidat candidat = CandidatDAO.getCandidat("jean", "e3d96c321f2a71cb81cd7d5f05f1a8d7");
	    		request.getRequestDispatcher("/MesTest").forward(request, response);
	    		
			// Mauvais identifiants
			} else {	
	    		request.getRequestDispatcher("/Home").forward(request, response);		
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
