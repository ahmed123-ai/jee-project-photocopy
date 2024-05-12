package tn.iit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import DAO.UtilisateurDAO;
import DAO.groupeDAO;
import DAO.matiereDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.groupe;
import model.matiere;
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
    private groupeDAO groupeDAO;
    private matiereDAO matiereDAO; // Initialize the MatiereDAO

    public void init() {
        utilisateurDAO = new UtilisateurDAO();
        groupeDAO = new groupeDAO();
        matiereDAO = new matiereDAO(); // Instantiate the MatiereDAO

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
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
                case "/newGroupe":
                    showNewFormGroupe(request, response);
                    break;
                case "/insertGroupe":
                    insertGroupe(request, response);
                    break;
                case "/deleteGroupe":
                    deleteGroupe(request, response);
                    break;
                case "/editGroupe":
                    showEditFormGroupe(request, response);
                    break;
                case "/updateGroupe":
                    updateGroupe(request, response);
                    break;
                case "/listingGroupe":
                    listGroupes(request, response);
                    break;
                case "/newMatiere": // Handle new matière request
                
                    showNewFormMatiere(request, response);
                    break;
                case "/insertMatiere": // Handle insert matière request
                    insertMatiere(request, response);
                    break;
                case "/deleteMatiere": // Handle delete matière request
                    deleteMatiere(request, response);
                    break;
                case "/editMatiere": // Handle edit matière request
                    showEditFormMatiere(request, response);
                    break;
                case "/updateMatiere": // Handle update matière request
                    updateMatiere(request, response);
                    break;
                case "/listingMatiere": // Handle list matière request
                    listMatieres(request, response);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/users/editUser.jsp");
         request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)

    throws SQLException, IOException {
        String username = request.getParameter("username");
        String role_id = request.getParameter("role_id");
        String password = request.getParameter("password");
     

        utilisateur newUser = new utilisateur(username, role_id, password);
     
        utilisateurDAO.insertUser(newUser);
       

        response.sendRedirect("/login/UserServlet");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String role_id = request.getParameter("role_id");
        String password = request.getParameter("password");
     

        utilisateur user = new utilisateur(id, username, role_id, password);
        utilisateurDAO.updateUser(user);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        utilisateurDAO.deleteUser(id);
        response.sendRedirect("list");
    }
    

    private void listGroupes(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<groupe> listGroupes = groupeDAO.selectAllGroupes();
        request.setAttribute("listGroupes", listGroupes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/groupes/listGroupe.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormGroupe(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/groupes/newGroupe.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormGroupe(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        groupe existingGroupe = groupeDAO.selectGroupe(id);
       

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/groupes/editGroupe.jsp");
        request.setAttribute("groupe", existingGroupe);
         dispatcher.forward(request, response);
    }

    private void insertGroupe(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String label = request.getParameter("label");

        groupe newGroupe = new groupe(label);
        groupeDAO.insertGroupe(newGroupe);

        response.sendRedirect(request.getContextPath() + "/groupe/list");
    }

    private void updateGroupe(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String label = request.getParameter("label");

        groupe groupe = new groupe(id, label);
        groupeDAO.updateGroupe(groupe);
        response.sendRedirect(request.getContextPath() + "/groupe/list");
    }

    private void deleteGroupe(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        groupeDAO.deleteGroupe(id);
        response.sendRedirect(request.getContextPath() + "/groupe/list");
    }
    

    private void listMatieres(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<matiere> listMatieres = matiereDAO.selectAllMatieres();
        request.setAttribute("listMatieres", listMatieres);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/matiere/listMatiere.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormMatiere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<groupe> listGroupes = groupeDAO.selectAllGroupes();
        request.setAttribute("listGroupes", listGroupes);
 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/matiere/newMatiere.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormMatiere(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        matiere existingMatiere = matiereDAO.selectMatiere(id);
        List<groupe> listGroupes = groupeDAO.selectAllGroupes();
        request.setAttribute("matiere", existingMatiere);
        request.setAttribute("listGroupes", listGroupes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/matieres/editMatiere.jsp");
        dispatcher.forward(request, response);
    }

    private void insertMatiere(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String label = request.getParameter("label");
        int groupeId = Integer.parseInt(request.getParameter("groupe_id"));

        matiere newMatiere = new matiere(label, groupeId);
        matiereDAO.insertMatiere(newMatiere);

        response.sendRedirect(request.getContextPath() + "/listingMatiere");
    }

    private void updateMatiere(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String label = request.getParameter("label");
        int groupeId = Integer.parseInt(request.getParameter("groupe_id"));

        matiere matiere = new matiere(id, label, groupeId);
        matiereDAO.updateMatiere(matiere);
        response.sendRedirect(request.getContextPath() + "/listingMatiere");
    }

    private void deleteMatiere(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        matiereDAO.deleteMatiere(id);
        response.sendRedirect(request.getContextPath() + "/listingMatiere");
    }
    
}
