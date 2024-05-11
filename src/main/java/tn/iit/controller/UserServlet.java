package tn.iit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import DAO.UtilisateurDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.utilisateur;


/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */
@WebServlet("/")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1 ;
    private UtilisateurDAO utilisateurDAO;

    public void init() {
        utilisateurDAO = new UtilisateurDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
	    
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
	        String redirectScript = "<script>setTimeout(function() { window.location.href = '" + request.getContextPath() + destinationPage + "'; }, 1000);</script>";
	        response.getWriter().write(redirectScript);
	    } else {
	        request.setAttribute("error", "Invalid username or password. Please try again.");
	        RequestDispatcher rd = getServletContext().getRequestDispatcher("/auth/login.jsp");
	        rd.forward(request, response);
	    }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();
    	System.out.println("action "+action);
        try {
            switch (action) {
                case "/new":
                	System.out.println("show form user ");
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List<utilisateur> listUser = utilisateurDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/index.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/users/newUser.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        utilisateur existingUser = utilisateurDAO.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/index.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String username = request.getParameter("username");
        String role_id = request.getParameter("role_id");
        String password = request.getParameter("password");
        String state = request.getParameter("state");
        
        utilisateur newUser = new utilisateur(username, role_id, password, state);
        utilisateurDAO.insertUser(newUser);
        response.sendRedirect("list");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String role_id = request.getParameter("role_id");
        String password = request.getParameter("password");
        String state = request.getParameter("state");

        utilisateur user = new utilisateur(id, username, role_id, password, state);
        utilisateurDAO.updateUser(user);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        utilisateurDAO.deleteUser(id);
        response.sendRedirect("list");
    }
}
