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
import edu.rit.datasec.Group3Project.service.StudentService;

/**
 * Servlet implementation class StudentCourseServlet
 */
@WebServlet("/StudentCourses")
public class StudentCourseServlet extends AuthenticatedServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see AuthenticatedServlet#AuthenticatedServlet()
	 */
	public StudentCourseServlet() {
		super(Arrays.asList(Role.Student));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/StudentCourseInfo.jsp");
		HttpSession session = request.getSession(false);
		String user = (String) session.getAttribute(WebConstants.AUTH_USER);
		request.setAttribute(WebConstants.STUDENT_COURSE_INFO, StudentService.getInstance().getStudentCourseInfo(user));
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
