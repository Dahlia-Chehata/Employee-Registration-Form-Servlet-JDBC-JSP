<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="registration.daoImpl.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container" align="center">
    <h1>Successfully registered!</h1>
	<h1> Employee Details</h1>
	<form action="<%= request.getContextPath() %>/employeeInfo" method="post">
    <table class="table" style="with: 80%">
    <thead class="thead-dark">
    <tr align="center">
        <th scope="col" align="center">ID</th>
        <th scope="col" align="center">First Name</th>
        <th scope="col" align="center">Last Name</th> 
        <th scope="col" align="center">Email</th> 
        <th scope="col" align="center">Phone</th>
        <th scope="col" align="center">Age</th> 
        <th scope="col" align="center">Salary</th> 
        <th scope="col" align="center">Department</th>
    </tr>
    </thead>
    <tbody>
    
    <tr>
    <c:forEach items="${empList}" var="employee">
      <tr align="center">
      <th scope="row" align="center">${employee.ID}</th>
      <td align="center"><c:out value="${employee.firstName}"/></td>
      <td align="center"><c:out value="${employee.lastName}"/></td>
      <td align="center"><c:out value="${employee.email}"/></td>
      <td align="center"><c:out value="${employee.phone}"/></td>
      <td align="center"><c:out value="${employee.age}"/></td>
      <td align="center"><c:out value="${employee.salary}"/></td>
      <td align="center"><c:out value="${employee.department.name}"/></td>
      </tr>
    </c:forEach>
    </tr>
    </tbody>
    </table>
    </form>
    </div>
</body>
</html>