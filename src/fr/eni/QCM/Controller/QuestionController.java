package fr.eni.QCM.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.tools.xjc.generator.util.ExistingBlockReference;

import fr.eni.QCM.BO.Proposition;
import fr.eni.QCM.BO.Question;
import fr.eni.QCM.BO.Section;
import fr.eni.QCM.DAL.PropositionDAO;
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
			int idSection = 0;
			try {
				idSection = QuestionDAO.getOne(idQuestion).getSection().getId();
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				QuestionDAO.delete(idQuestion);
			} catch (SQLException e) {e.printStackTrace();}
			

			String url = "./SectionController?modifid=" + idSection;
			response.sendRedirect(url);
		}
		
		// UPDATE
		if (request.getParameter("update") != null) {
			int idQuestion = Integer.valueOf(request.getParameter("update"));
			Question question = null;
			ArrayList<Proposition> propositions = new ArrayList<Proposition>();
			
			try {
				question = QuestionDAO.getOne(idQuestion);
				propositions = PropositionDAO.getPropForQuest(idQuestion);
			} catch (SQLException e) {e.printStackTrace();}
			
			for (Proposition p : propositions) {
				System.out.println(p.getLibelle());
			}
			
			request.setAttribute("Propositions", propositions);
			request.setAttribute("Question", question);
		
		}
		
		if (request.getParameter("delete") == null) {
			
			// Section en cours
			int idSection = 0;
			if (request.getParameter("section") != null) {
				idSection = Integer.valueOf(request.getParameter("section"));
			}
						
	
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("QuestionController : POST");
		doGet(request, response);
	}

}
