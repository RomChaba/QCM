package fr.eni.QCM.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.QCM.BO.Section;
import fr.eni.QCM.DAL.QuestionDAO;
import fr.eni.QCM.DAL.SectionDAO;

/**
 * Servlet implementation class SectionController
 */
@WebServlet("/SectionController")
public class SectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SectionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Passage dans le controler de section");
		ArrayList<Integer> nbquestion = new ArrayList<>();
		Map<Section,Integer> secEtNbQue = new LinkedHashMap<>();
		try {
			ArrayList<Section> sections = SectionDAO.getAll();
			for (Section section : sections) {
				secEtNbQue.put(section, QuestionDAO.getNbParSection(section.getId()));
			}
			
			request.setAttribute("sectionsEtQues", secEtNbQue);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		request.getRequestDispatcher("/AjoutSectionTest").forward(request, response);		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
