package fr.eni.QCM.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.QCM.BO.Candidat;
import fr.eni.QCM.BO.Formateur;
import fr.eni.QCM.DAL.CandidatDAO;
import fr.eni.QCM.DAL.FormateurDAO;
import fr.eni.QCM.DAL.UtilisateurDAO;
import fr.eni.QCM.utils.Const;
import fr.eni.QCM.utils.MD5;

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
		HttpSession userSession = request.getSession(false);
		if(request.getParameter("deconnexion")!= null){
			userSession.invalidate();
			System.out.println("dans la déco");
			response.sendRedirect("Home");
		}else{
			System.out.println("else de la déco");
			String login = request.getParameter(Const.PARAM_LOGIN);
			String password = MD5.encode(request.getParameter(Const.PARAM_PASSWORD));
					
			try {
				int typeUser = UtilisateurDAO.testConnexion(login, password);
		    	
				
				// Formateur
				if(typeUser == 1) { 
					Formateur formateur = FormateurDAO.getFormateur(login, password);
					userSession.setAttribute("type", typeUser);
					
					userSession.setAttribute("Formateur", formateur);
		    		request.getRequestDispatcher("/ListeTest").forward(request, response);
		    		
				// Candidat
				} else if(typeUser == 2) {
					Candidat candidat = CandidatDAO.getCandidat(login, password);
					userSession.setAttribute("type", typeUser);
					userSession.setAttribute("Candidat", candidat);
		    		request.getRequestDispatcher("/MesTest").forward(request, response);
		    		
				// Mauvais identifiants
				} else {	
		    		request.getRequestDispatcher("/Home").forward(request, response);		
				}
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
