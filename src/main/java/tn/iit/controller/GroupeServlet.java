package tn.iit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.groupe;
import DAO.groupeDAO;

@WebServlet("/groupe/*")
public class GroupeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private groupeDAO groupeDAO;

    public void init() {
        groupeDAO = new groupeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        
        
		System.out.println("action sss " + action);

        try {
            if (action != null) {
                switch (action) {
                    case "/new":
                    	showNewFormGroupe(request, response);
                        break;
                    case "/insert":
                        insertGroupe(request, response);
                        break;
                    case "/delete":
                        deleteGroupe(request, response);
                        break;
                    case "/edit":
                        showEditForm(request, response);
                        break;
                    case "/update":
                        updateGroupe(request, response);
                        break;
                    default:
                        listGroupes(request, response);
                        break;
                }
            } else {
                // Handle the case when action is null
                // You can provide a default behavior or return an error response
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing servlet path");
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
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

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
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
}
