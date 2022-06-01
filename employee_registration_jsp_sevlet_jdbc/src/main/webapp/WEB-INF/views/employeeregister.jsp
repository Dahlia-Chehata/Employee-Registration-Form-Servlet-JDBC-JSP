<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Employee Register Form</h1>
		<form action="<%= request.getContextPath() %>/employeeInfo"
			method="post">
			<table style="with: 80%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" /></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="text" name="phone" /></td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><input type="date" name="dateOfBirth" /></td>
				</tr>
				<tr>
					<td>Salary</td>
					<td><input type="number" name="salary" /></td>
				</tr>
				<tr>
					<td>Department</td>
					<td><select name="department">
							<option value="NONE">Select a department</option>
							<c:forEach items="${listDepartment}" var="department">
								<option value="${department.ID}"
									<c:if test="${department.ID eq SelectedDepartmentID}">selected="selected"</c:if>>
									${department.name}</option>
							</c:forEach>
					</select></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>

