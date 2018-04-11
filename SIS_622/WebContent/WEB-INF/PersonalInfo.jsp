<%@page import="edu.rit.datasec.Group3Project.web.WebConstants"%>
<%@page import="edu.rit.datasec.Group3Project.bo.PersonalInfo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome <%=request.getSession(false).getAttribute(WebConstants.AUTH_USER)%></title>
</head>
<body>
	<div id='personalInfo'>
		<%
			PersonalInfo info = (PersonalInfo) request.getAttribute(WebConstants.PERSONAL_INFO);
			String contactEmail = info.getContactEmail();
			contactEmail = (contactEmail == null) ? "" : contactEmail;
			String univEmail = info.getUnivEmail();
			univEmail = (univEmail == null) ? "" : univEmail;
			String contactNumber = info.getContactNumber();
			contactNumber = (contactNumber == null) ? "" : contactNumber;
			String emergencyContactEmail = info.getEmergencyContactEmail();
			emergencyContactEmail = (emergencyContactEmail == null) ? "" : emergencyContactEmail;
			String emergencyContactNumber = info.getEmegencyContactNumber();
			emergencyContactNumber = (emergencyContactNumber == null) ? "" : emergencyContactNumber;
		%>
		<form action="PersonalInfoUpdate">
			<table>
				<tr>
					<td>Personal Email:</td>
					<td><input type="email" name="contactEmail"
						value='<%=contactEmail%>'></td>
				</tr>
				<tr>
					<td>Univ Email:</td>
					<td><input type="email" name="univEmail"
						value='<%=univEmail%>'></td>
				</tr>
				<tr>
					<td>Personal Contact:</td>
					<td><input type="text" name="personalContact"
						value='<%=contactNumber%>'></td>
				</tr>
				<tr>
					<td>Emergency Email:</td>
					<td><input type="email" name="emergencyEmail"
						value='<%=emergencyContactEmail%>'></td>
				</tr>
				<tr>
					<td>Emergency Contact:</td>
					<td><input type="text" name="emergencyContact"
						value='<%=emergencyContactNumber%>'></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						name="update" value="update" /></td>
				</tr>


			</table>

		</form>
	</div>
</body>
</html>