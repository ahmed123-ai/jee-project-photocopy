package tn.iit.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.utilisateur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class InscriptionController
 */
public class InscriptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   /* String nom = request.getParameter("nom");
		String prenom = request.getParameter("nom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String state = request.getParameter("password");
		 utilisateur user = new utilisateur(3,nom, prenom, login, password,state);
		 ServletContext application = getServletContext();
	 
		 List<utilisateur> u = (List<utilisateur>)application.getAttribute("users");
		 if(u == null) {
			 u = new ArrayList<utilisateur>();
		 }
		 u.add(user);
		 application.setAttribute("users", u);
		 response.sendRedirect("auth.jsp");
 */
		 	 
		 		 
	}

}
