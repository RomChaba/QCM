package fr.eni.QCM.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.AllPermission;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.QCM.BO.Formateur;
import fr.eni.QCM.BO.Test;
import fr.eni.QCM.BO.TypeTest;
import fr.eni.QCM.DAL.TestDAO;
import fr.eni.QCM.DAL.TypeTestDAO;

/**
 * Servlet implementation class TestAddController
 */
@WebServlet("/Test/Add")
public class TestAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<TypeTest> AllTypesTest = null;
		
		try {
			AllTypesTest = TypeTestDAO.getAll();
		} catch (SQLException e) {e.printStackTrace();}
		
		request.setAttribute("types", AllTypesTest);
		request.getRequestDispatcher("/CreerTest").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nom = request.getParameter("nom");
		int timermin = Integer.valueOf(request.getParameter("timermin"));
		int timersec = Integer.valueOf(request.getParameter("timersec"));
		int type = Integer.valueOf(request.getParameter("type"));
		HttpSession session = request.getSession();
		Formateur user = (Formateur) session.getAttribute("Formateur");
		int timer = timermin * 60 + timersec;
		
		Test test = null;
		try {
			TestDAO.add(nom, timer, user.getId(), type);
			test = TestDAO.getOneByLibelle(nom);
			
		} catch (SQLException e) {e.printStackTrace();}

		request.setAttribute("test", test);
		request.getRequestDispatcher("/SectionController").forward(request, response);
	}

}
