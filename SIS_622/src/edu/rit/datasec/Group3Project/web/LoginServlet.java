package edu.rit.datasec.Group3Project.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.rit.datasec.Group3Project.bo.Role;
import edu.rit.datasec.Group3Project.service.CredentialsService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final CredentialsService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		service = CredentialsService.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(WebConstants.MAX_SESSION_TIMEOUT);
		try {
			Role role = service.checkLogin(user, password);
			session.setAttribute(WebConstants.AUTH_USER, user);
			session.setAttribute(WebConstants.AUTH_USER_ROLE, role);

			RequestDispatcher dispatcher = request.getRequestDispatcher(role + "Servlet");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}

	}

}
