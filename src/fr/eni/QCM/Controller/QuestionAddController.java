package fr.eni.QCM.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.QCM.DAL.QuestionDAO;

/**
 * Servlet implementation class QuestionAddController
 */
@WebServlet("/Question/Add")
public class QuestionAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("QuestionAddController : GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("QuestionAddController : POST");
		
		String libelle = request.getParameter("libelle");
		int idQuestion = Integer.valueOf(request.getParameter("idQuestion"));
		int type = Integer.valueOf(request.getParameter("type"));
		int idSection = Integer.valueOf(request.getParameter("section"));
		
		try {
			QuestionDAO.update(libelle, type, idSection, idQuestion);
		} catch (SQLException e) {e.printStackTrace();}
		
		response.sendRedirect("../SectionController");
	}

}
