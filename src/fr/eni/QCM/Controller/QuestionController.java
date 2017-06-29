package fr.eni.QCM.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.QCM.BO.Section;
import fr.eni.QCM.DAL.QuestionDAO;
import fr.eni.QCM.DAL.SectionDAO;

/**
 * Servlet implementation class QuestionController
 */
@WebServlet("/Question")
public class QuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("QuestionController : GET");
		
		// DELETE
		if (request.getParameter("delete") != null) {
			int idQuestion = Integer.valueOf(request.getParameter("delete"));
			try {
				QuestionDAO.delete(idQuestion);
			} catch (SQLException e) {e.printStackTrace();}
		}
		
		// Section en cours
		int idSection = Integer.valueOf(request.getParameter("section"));
		Section maSection = null;
		try {
			maSection = SectionDAO.getOne(idSection);
		} catch (SQLException e1) {e1.printStackTrace();}
		
		// Liste des Sections
		ArrayList<Section> LesSections = new ArrayList<Section>();
		try {
			LesSections = SectionDAO.getAll();
		} catch (SQLException e) {e.printStackTrace();}
		
		
		
		request.setAttribute("maSection", maSection);
		request.setAttribute("LesSections", LesSections);
		request.getRequestDispatcher("/CreerQuestion").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("QuestionController : POST");
		doGet(request, response);
	}

}
