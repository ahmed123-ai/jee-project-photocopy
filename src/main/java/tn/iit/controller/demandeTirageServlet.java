package tn.iit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import DAO.demandeTirageDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.demandeTirage;

public class demandeTirageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private demandeTirageDAO demandeTirageDAO;

	public void init() {
		demandeTirageDAO = new demandeTirageDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertDemandeTirage(request, response);
				break;
			case "/delete":
				deleteDemandeTirage(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateDemandeTirage(request, response);
				break;
			case "/updateTo1":
				updateDemandeTirageTo1(request, response);
				break;
			case "/updateTo0":
				updateDemandeTirageTo0(request, response);
				break;
			case "/list":
				listDemandeTirages(request, response);
				break;
			default:
				listDemandeTirages(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/demandeTirage/new.jsp");
		dispatcher.forward(request, response);
	}

	private void insertDemandeTirage(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Retrieve data from the request
		// Assuming you have form fields named accordingly
		int userId = Integer.parseInt(request.getParameter("user_id"));
		int matiereId = Integer.parseInt(request.getParameter("matiere_id"));
		String dateArriver = request.getParameter("dateArriver");
		int nbCopier = Integer.parseInt(request.getParameter("nbCopier"));
		int statu = Integer.parseInt(request.getParameter("statu"));

 		demandeTirage newDemandeTirage = new demandeTirage(userId, matiereId, dateArriver, nbCopier, statu);

		// Insert the new DemandeTirage into the database
		demandeTirageDAO.insertDemandeTirage(newDemandeTirage);

		// Redirect to the list page
		response.sendRedirect(request.getContextPath() + "/demandeTirage/list");
	}

	private void deleteDemandeTirage(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		demandeTirageDAO.deleteDemandeTirage(id);
		response.sendRedirect(request.getContextPath() + "/demandeTirage/list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		demandeTirage existingDemandeTirage = demandeTirageDAO.selectDemandeTirage(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/demandeTirage/edit.jsp");
		request.setAttribute("demandeTirage", existingDemandeTirage);
		dispatcher.forward(request, response);
	}

	private void updateDemandeTirage(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Retrieve data from the request
		// Assuming you have form fields named accordingly
		int id = Integer.parseInt(request.getParameter("id"));
		int userId = Integer.parseInt(request.getParameter("user_id"));
		int matiereId = Integer.parseInt(request.getParameter("matiere_id"));
		String dateArriver = request.getParameter("dateArriver");
		int nbCopier = Integer.parseInt(request.getParameter("nbCopier"));
		int statu = Integer.parseInt(request.getParameter("statu"));

		// Create a new DemandeTirage object
		demandeTirage demandeTirage = new demandeTirage(id, userId, matiereId, dateArriver, nbCopier, statu);

		// Update the DemandeTirage in the database
		demandeTirageDAO.updateDemandeTirage(demandeTirage);

		// Redirect to the list page
		response.sendRedirect(request.getContextPath() + "/demandeTirage/list");
	}

	private void updateDemandeTirageTo1(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		demandeTirageDAO.updateDemandeTirageStatusTo1(id); // Set status to 1
		response.sendRedirect(request.getContextPath() + "/demandeTirage/list");
	}

	private void updateDemandeTirageTo0(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		demandeTirageDAO.updateDemandeTirageStatusTo0(id); // Set status to 0
		response.sendRedirect(request.getContextPath() + "/demandeTirage/list");
	}

	private void listDemandeTirages(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<demandeTirage> listDemandeTirages = demandeTirageDAO.selectAllDemandesTirage();
		request.setAttribute("listDemandeTirages", listDemandeTirages);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/demandeTirage/list.jsp");
		dispatcher.forward(request, response);
	}
}
