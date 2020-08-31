<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@include file="../html/header.html"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<body>
	<!-- Menu container -->
	<div class=container>
		<%@include file="menu.jsp"%>
	</div>
	<!-- Detail container -->
	<div class="container">

		<h1 class="text-success">Employee Details</h1>
		<p align="right">
		<button
				onclick="window.location.href = 'showFormPrintPdf.do'; return false;"
				class="btn btn-outline-success">Print Pdf</button>
			<button
				onclick="window.location.href = 'showFormForAdd.html'; return false;"
				class="btn btn-outline-success">Add Employee</button>
		</p>
		<hr class="border border-success" />
		<table border="1" class="table table-striped table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>Full Name</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Hobbies</th>
					<th>Country</th>
					<th>Address</th>
					<th>Actions</th>
				</tr>
			</thead>
			<c:forEach items="${employeeList}" var="e">
				<c:url var="updateLink" value="/employee/displayUpdateForm.html">
					<c:param name="employeeId" value="${e.id}" />
				</c:url>

				<c:url var="deleteLink" value="/employee/displayDeleteForm.html">
					<c:param name="employeeId" value="${e.id}" />
				</c:url>
				<tbody>
					<tr>
						<td>${e.fullname}</td>
						<td>${e.email}</td>
						<td>${e.gender}</td>
						<td>${e.hobbies}</td>
						<td>${e.country}</td>
						<td>${e.address}</td>
						<td><a href="${updateLink}">Update</a> | <a
							href="${deleteLink}"
							onclick="if(!(confirm('Are you sure want to delete this Employee permanently?'))) return false">Delete</a>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<hr class="border border-success" />
	</div>

</body>
</html>