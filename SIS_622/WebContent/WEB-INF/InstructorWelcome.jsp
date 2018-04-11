<%@page import="edu.rit.datasec.Group3Project.web.WebConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome <%=request.getSession(false).getAttribute(WebConstants.AUTH_USER)%></title>
</head>
<body>
	<%=request.getAttribute(WebConstants.INSTRUCTOR_INFO)%>



	<div id='navigation'>
		<div>
			<div>
				<a href='InstructorCourses'>Courses</a>
			</div>
		</div>
		<div>
			<div>
				<a href='PersonalInfoServlet'>Personal Info</a>
			</div>
		</div>
	</div>
</body>
</html>