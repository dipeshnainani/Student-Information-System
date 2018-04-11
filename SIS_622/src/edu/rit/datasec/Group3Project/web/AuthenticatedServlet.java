package edu.rit.datasec.Group3Project.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.rit.datasec.Group3Project.bo.Role;

public abstract class AuthenticatedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Role> allowedRoles;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticatedServlet(List<Role> allowedRoles) {
		this.allowedRoles = allowedRoles;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		checkSession(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		checkSession(request, response);
	}

	private void checkSession(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!isSessionAuthenticated(request)) {
			throw new ServletException("User not authorized");
		}

	}

	private boolean isSessionAuthenticated(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return false;
		}
		Role role = (Role) session.getAttribute(WebConstants.AUTH_USER_ROLE);
		if (role == null || !allowedRoles.contains(role)) {
			return false;
		}
		return true;
	}

}
