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

import org.glassfish.jersey.server.internal.process.RespondingContext;

import fr.eni.QCM.BO.Formateur;
import fr.eni.QCM.BO.Question;
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
			int id = Integer.valueOf(request.getParameter("modif"));
			String libelle =request.getParameter("libelle");
						
			try {
				SectionDAO.modifLibelle(id, libelle);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("./SectionController");
		}else if(request.getParameter("selectDel") != null){
			
			int idTest = Integer.valueOf(request.getParameter("idTest"));
			int idSection =Integer.valueOf(request.getParameter("selectDel"));
			
			try {
				SectionDAO.deleteSectionSeletec(idSection, idTest);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("./SectionController");
			
			
		}else if(request.getParameter("add") != null){
			
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

			int idSection =Integer.valueOf(request.getParameter("modifid"));
			
			ArrayList<Question> LesQuestions = new ArrayList<Question>();
			try {
				LesQuestions = QuestionDAO.getQuestionForSection(idSection);
			} catch (SQLException e1) {e1.printStackTrace();}
			request.setAttribute("LesQuestions", LesQuestions);
			
			try {
				Section s = SectionDAO.getOne(idSection);
				request.setAttribute("section", s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/CreerModifSection").forward(request, response);
			
			
		}else if(request.getParameter("suppid") != null){
			
			
			int idSection =Integer.valueOf(request.getParameter("suppid"));
			
			try {
				SectionDAO.deleteSection(idSection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("./SectionController");
			
			
		}else if(request.getParameter("addid") != null){
			Test t = null;
			System.out.println("Valeur de getParameter(\"nomTest\") dans addid : ");
			System.out.println((String) request.getParameter("nomTest"));
			
			
			try {
				t = TestDAO.getOneByLibelle((String) request.getParameter("nomTest"));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.setAttribute("test", t);
			int idSection = Integer.valueOf(request.getParameter("addid"));
			int idTest = Integer.valueOf(request.getParameter("idtest"));
			
			try {
				SectionDAO.linkTestSection(idTest, idSection);;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("./SectionController");
			
			
		}else{
			
			ArrayList<Integer> nbquestion = new ArrayList<>();
			Map<Section,Integer> secEtNbQue = new LinkedHashMap<>();
			Test t = null;
			System.out.println("valeur de getAttribute(nomTest) : ");
			System.out.println((String) request.getAttribute("nomTest"));
			
			if(request.getAttribute("nomTest") != null){
				try {
					t = TestDAO.getOneByLibelle((String) request.getAttribute("nomTest"));
					userSession.setAttribute("test", t);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(request.getParameter("nomTest") != null){
				try {
					t = TestDAO.getOneByLibelle((String) request.getParameter("nomTest"));
					userSession.setAttribute("test", t);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				t = (Test) userSession.getAttribute("test");
			}
			
			if(request.getAttribute("nomTest") != null){
				try {
					t = TestDAO.getOneByLibelle((String) request.getAttribute("nomTest"));
					userSession.setAttribute("test", t);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			
			try {
				ArrayList<Section> sections = SectionDAO.getNotSelectedForId(t.getId());
				for (Section section : sections) {
					secEtNbQue.put(section, QuestionDAO.getNbParSection(section.getId()));
				}
				
				request.setAttribute("sectionsEtQues", secEtNbQue);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			//Partie pour les sections du test
			try {
				ArrayList<Integer> sectionsDuTest = new ArrayList<>();
				Map<Section,Integer> secTestEtNbQue = new LinkedHashMap<>();
				
				System.out.println("valeur de id : ");
				System.out.println(t.getId());
				
				
				sectionsDuTest = SectionDAO.getAllForId(t.getId());
				
				ArrayList<Section> sections = new ArrayList<>();
				
				for (Integer id : sectionsDuTest) {
					secTestEtNbQue.put(SectionDAO.getOne(id), QuestionDAO.getNbParSection(id));
				}
				request.setAttribute("sectionTest", secTestEtNbQue);
				
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
