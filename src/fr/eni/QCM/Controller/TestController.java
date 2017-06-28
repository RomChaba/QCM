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

import fr.eni.QCM.BO.Test;
import fr.eni.QCM.BO.TypeTest;
import fr.eni.QCM.DAL.TestDAO;
import fr.eni.QCM.DAL.TypeTestDAO;

/**
 * Servlet implementation class listTest
 */
@WebServlet("/Test")
public class TestController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();

		// DELETE
		if(request.getParameter("delete")!= null){
			try {
				TestDAO.delete(Integer.valueOf(request.getParameter("delete")));
			} catch (NumberFormatException | SQLException e) {e.printStackTrace();}
		}

		// UPDATE
		if(request.getParameter("update")!= null){
			ArrayList<TypeTest> AllTypesTest = null;
			
			try {
				AllTypesTest = TypeTestDAO.getAll();
			} catch (SQLException e) {e.printStackTrace();}

			request.setAttribute("types", AllTypesTest);
			
			int id = Integer.valueOf(request.getParameter("update"));
			Test test = null;

			try {
				test = TestDAO.getOne(id);
			} catch (SQLException e) {e.printStackTrace();}

			request.setAttribute("test", test);
			request.getRequestDispatcher("/CreerTest").forward(request, response);
			
		}
		
		
		ArrayList<Test> tests = null;
		
		try {
			tests = TestDAO.getAll();
		} catch (SQLException e) {e.printStackTrace();}

		request.setAttribute("tests", tests);
		request.getRequestDispatcher("/ListeTest").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
