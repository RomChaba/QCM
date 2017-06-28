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
import javax.servlet.http.HttpSession;

import fr.eni.QCM.BO.Formateur;
import fr.eni.QCM.BO.Section;
import fr.eni.QCM.BO.Test;
import fr.eni.QCM.DAL.QuestionDAO;
import fr.eni.QCM.DAL.SectionDAO;
import fr.eni.QCM.DAL.TestDAO;

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
		HttpSession userSession = request.getSession(false);
		Formateur f = (Formateur)userSession.getAttribute("Formateur");
		
		if(request.getParameter("modif") != null){
			System.out.println("modif dune section");
			int id = Integer.valueOf(request.getParameter("modif"));
			String libelle =request.getParameter("libelle");
			
			try {
				SectionDAO.modifLibelle(id, libelle);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("./SectionController");
		}else if(request.getParameter("add") != null){
			System.out.println("Add dune section");
			int idFormateur = f.getId();
			String libelle =request.getParameter("libelle");
			
			try {
				SectionDAO.CreerSection(libelle,idFormateur);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("./SectionController");
			
			
		}else if(request.getParameter("modifid") != null){
			System.out.println("recuperation de la section a modifier");
			
			int idSection =Integer.valueOf(request.getParameter("modifid"));
			
			try {
				Section s = SectionDAO.getOne(idSection);
				request.setAttribute("section", s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/CreerModifSection").forward(request, response);
			
			
		}else if(request.getParameter("suppid") != null){
			System.out.println("suppression de la section");
			
			int idSection =Integer.valueOf(request.getParameter("suppid"));
			
			try {
				SectionDAO.deleteSection(idSection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("./SectionController");
			
			
		}else{
			System.out.println("Affchage sections");
			ArrayList<Integer> nbquestion = new ArrayList<>();
			Map<Section,Integer> secEtNbQue = new LinkedHashMap<>();
			Test t = null;
			try {
				t = TestDAO.getOneByLibelle((String) request.getAttribute("nomTest"));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.setAttribute("test", t);
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
