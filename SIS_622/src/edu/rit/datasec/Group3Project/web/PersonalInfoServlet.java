package edu.rit.datasec.Group3Project.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.rit.datasec.Group3Project.bo.Role;
import edu.rit.datasec.Group3Project.service.InstructorService;
import edu.rit.datasec.Group3Project.service.StudentService;

public class PersonalInfoServlet extends AuthenticatedServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonalInfoServlet() {
		super(Arrays.asList(Role.Instructor, Role.Student));
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/PersonalInfo.jsp");
		HttpSession session = request.getSession(false);
		String user = (String) session.getAttribute(WebConstants.AUTH_USER);
		Role role = (Role) session.getAttribute(WebConstants.AUTH_USER_ROLE);
		if (role == Role.Student) {
			request.setAttribute(WebConstants.PERSONAL_INFO,
					StudentService.getInstance().getStudentInfo(user).getPersonalInfo());
		} else if (role == Role.Instructor) {
			request.setAttribute(WebConstants.PERSONAL_INFO,
					InstructorService.getInstance().getInstructorInfo(user).getPersonalInfo());

		}
		dispatcher.forward(request, response);

	}

}
