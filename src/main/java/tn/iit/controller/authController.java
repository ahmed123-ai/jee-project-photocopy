package tn.iit.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.utilisateur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import DAO.UtilisateurDAO;

/**
 * Servlet implementation class authController
 */

public class authController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("action " + action);

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UtilisateurDAO userDAO = new UtilisateurDAO();

		utilisateur authenticatedUser = userDAO.login(username, password);

		if (authenticatedUser != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("userCourant", authenticatedUser);
			System.out.println("userCourant: " + authenticatedUser.getUsername());
			System.out.println("Role ID: " + authenticatedUser.getRole_id());

			String role_id = authenticatedUser.getRole_id();
			String destinationPage;
			if ("1".equals(role_id)) {
				destinationPage = "/UserServlet";
			} else if ("2".equals(role_id)) {
				destinationPage = "/teacher/index.jsp";
			} else if ("3".equals(role_id)) {
				destinationPage = "/agent/index.jsp";
			} else {
				destinationPage = "/error.jsp"; // Handle unknown role ID
			}

			// Add a delay before redirecting
			String redirectScript = "<script>setTimeout(function() { window.location.href = '"
					+ request.getContextPath() + destinationPage + "'; }, 1000);</script>";
			response.getWriter().write(redirectScript);
		} else {
			request.setAttribute("error", "Invalid username or password. Please try again.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/auth/login.jsp");
			rd.forward(request, response);
		}

	}

}
