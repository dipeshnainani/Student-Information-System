package edu.rit.datasec.Group3Project.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.rit.datasec.Group3Project.bo.Role;
import edu.rit.datasec.Group3Project.service.InstructorService;

/**
 * Servlet implementation class InstructorServlet
 */
@WebServlet("/InstructorServlet")
public class InstructorServlet extends AuthenticatedServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see AuthenticatedServlet#AuthenticatedServlet()
	 */
	public InstructorServlet() {
		super(Arrays.asList(Role.Instructor));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/InstructorWelcome.jsp");
		HttpSession session = request.getSession(false);
		String user = (String) session.getAttribute(WebConstants.AUTH_USER);
		request.setAttribute(WebConstants.INSTRUCTOR_INFO, InstructorService.getInstance().getInstructorInfo(user));
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doPost(request, response);
		doGet(request, response);
	}


}
