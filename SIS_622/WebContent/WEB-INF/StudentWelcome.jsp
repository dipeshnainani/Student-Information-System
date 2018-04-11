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

	<div id='studentinfo>'>
		<%=request.getAttribute(WebConstants.STUDENT_INFO)%>
	</div>

	<br />

	<div id='navigation'>
		<div>
			<div>
				<a href='StudentCourses'>Courses</a>
			</div>
		</div>
		<div>
			<div>
				<a href='PersonalInfoServlet'>Personal Information</a>
			</div>
		</div>
		<div>
			<div>
				<a href='#'>Shopping Cart</a>
			</div>
		</div>
	</div>


</body>
</html>