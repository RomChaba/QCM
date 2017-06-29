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
import fr.eni.QCM.BO.Question;
import fr.eni.QCM.BO.Test;
import fr.eni.QCM.BO.TypeTest;
import fr.eni.QCM.DAL.PropositionDAO;
import fr.eni.QCM.DAL.QuestionDAO;
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
			//TODO: CHANGER PAR LE BON LIEN VERS LA QUESTION
			
			
			int idSectionADD = 0;
			try {
				
				idSectionADD = QuestionDAO.getOne(idQuestion).getSection().getId();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String s = "./Question?update="+idQuestion+"&section="+idSectionADD;
			
			request.getRequestDispatcher(s).forward(request, response);
			
		}
		//DELETE
		else if(request.getParameter("delProp") != null){
			System.out.println("ENTRER DANS LA PARTIE delProp");
			int idProp = Integer.valueOf(request.getParameter("delProp"));
			
			int idQuestionDEL = 0;
			int idSectionDEL = 0;
			
			
			try {
				idQuestionDEL = PropositionDAO.getOne(idProp).getQuestion().getId();
				idSectionDEL = QuestionDAO.getOne(idQuestionDEL).getSection().getId();
				PropositionDAO.delPropo(idProp);
			} catch (SQLException e) {e.printStackTrace();}
			//TODO: CHANGER PAR LE BON LIEN VERS LA QUESTION

			String s = "./Question?update="+idQuestionDEL+"&section="+idSectionDEL;
			System.out.println("LIEN DE LA REDIRECTION : "+s);
			response.sendRedirect(s);
		}
		
		//UPDATE
		else if(request.getParameter("updProp") != null){
			System.out.println("ENTRER DANS UPDATE");
			String libelle = request.getParameter("libelle");
			System.out.println("Valeur de libelle");
			System.out.println(libelle);
			int reponse = Integer.valueOf(request.getParameter("verite"));
			
			
			int idPropo = Integer.valueOf(request.getParameter("updProp"));
			
			try {
				PropositionDAO.updatePropo(libelle, reponse, idPropo);
			} catch (SQLException e) {e.printStackTrace();}
			//TODO: CHANGER PAR LE BON LIEN VERS LA QUESTION
			int idQuestion = 0;
			int idSection = 0;
			try {
				idQuestion = PropositionDAO.getOne(idPropo).getQuestion().getId();
				idSection = QuestionDAO.getOne(idQuestion).getSection().getId();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String s = "./Question?update="+idQuestion+"&section="+idSection;
			
			response.sendRedirect(s);
		}
		//TOTAL
		else{
			try {
				
				Question q = QuestionDAO.getOne(Integer.valueOf(request.getParameter("idQuestion")));
				request.setAttribute("question", q);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (request.getParameter("idProp") != null){
				try {
					request.setAttribute("proposition", PropositionDAO.getOne(Integer.valueOf(request.getParameter("idProp"))));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
