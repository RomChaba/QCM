package fr.eni.QCM.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.QCM.BO.Proposition;
import fr.eni.QCM.BO.Test;
import fr.eni.QCM.BO.TypeTest;
import fr.eni.QCM.DAL.PropositionDAO;
import fr.eni.QCM.DAL.TestDAO;
import fr.eni.QCM.DAL.TypeTestDAO;

/**
 * Servlet implementation class listTest
 */
@WebServlet("/Reponse")
public class PropositionController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		//VARIABLES
		Proposition p = null;
		
		//ADD
		if(request.getParameter("addProp") != null){
			String libelle = request.getParameter("libelle");
			int reponse = Integer.valueOf(request.getParameter("verite"));
			int idQuestion = Integer.valueOf(request.getParameter("addProp"));
			
			try {
				PropositionDAO.creerPropo(libelle, reponse, idQuestion);
			} catch (SQLException e) {e.printStackTrace();}
			request.getRequestDispatcher("/Home").forward(request, response);
			
		}
		
		//DELETE
		//UPDATE
		//TOTAL
		else{
			request.getRequestDispatcher("/CreerReponse").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
