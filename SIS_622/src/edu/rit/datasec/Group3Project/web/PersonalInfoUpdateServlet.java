package edu.rit.datasec.Group3Project.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.rit.datasec.Group3Project.bo.Role;
import edu.rit.datasec.Group3Project.dao.BaseDAO;
import edu.rit.datasec.Group3Project.service.InstructorService;
import edu.rit.datasec.Group3Project.service.StudentService;

public class PersonalInfoUpdateServlet extends AuthenticatedServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonalInfoUpdateServlet() {
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
		edu.rit.datasec.Group3Project.bo.PersonalInfo info = null;

		Map<String, String> attrs = new HashMap<>();

		Arrays.asList("contactEmail", "univEmail", "personalContact", "emergencyEmail", "emergencyContact")
				.forEach(attr -> attrs.put(attr, request.getParameter(attr)));
		System.out.println(attrs);

		if (role == Role.Student) {
			info = StudentService.getInstance().getStudentInfo(user).getPersonalInfo();

			request.setAttribute(WebConstants.PERSONAL_INFO,
					StudentService.getInstance().getStudentInfo(user).getPersonalInfo());

		} else if (role == Role.Instructor) {
			info = InstructorService.getInstance().getInstructorInfo(user).getPersonalInfo();
			request.setAttribute(WebConstants.PERSONAL_INFO,
					InstructorService.getInstance().getInstructorInfo(user).getPersonalInfo());

		}
		info = compare(attrs, info);
		if (info != null) {
			BaseDAO.getInstance().saveOrUpdate(info);
		}

		if (role == Role.Student) {
			request.setAttribute(WebConstants.PERSONAL_INFO,
					StudentService.getInstance().getStudentInfo(user).getPersonalInfo());

		} else if (role == Role.Instructor) {
			request.setAttribute(WebConstants.PERSONAL_INFO,
					InstructorService.getInstance().getInstructorInfo(user).getPersonalInfo());
		}

		dispatcher.forward(request, response);
	}

	public edu.rit.datasec.Group3Project.bo.PersonalInfo compare(Map<String, String> attrs,
			edu.rit.datasec.Group3Project.bo.PersonalInfo info) {
		edu.rit.datasec.Group3Project.bo.PersonalInfo changed = null;

		if (info.getContactEmail() == null || !attrs.get("contactEmail").equals(info.getContactEmail())) {
			changed = info;
			info.setContactEmail(attrs.get("contactEmail"));
		}
		if (info.getUnivEmail() == null || !attrs.get("univEmail").equals(info.getUnivEmail())) {
			changed = info;
			info.setUnivEmail(attrs.get("univEmail"));
		}
		try {
			System.err.println(attrs.get("personalContact"));
			if (info.getContactNumber() == null || !attrs.get("personalContact").equals(info.getContactNumber())) {
				changed = info;
				info.setContactNumber(attrs.get("personalContact"));
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		if (info.getEmergencyContactEmail() == null
				|| !attrs.get("emergencyEmail").equals(info.getEmergencyContactEmail())) {
			changed = info;
			info.setEmergencyContactEmail(attrs.get("emergencyEmail"));
		}
		if (info.getEmergencyContactEmail() == null
				|| !attrs.get("emergencyContact").equals(info.getEmergencyContactEmail())) {
			changed = info;
			info.setEmergencyContactEmail(attrs.get("emergencyContact"));
		}
		return changed;
	}

}
