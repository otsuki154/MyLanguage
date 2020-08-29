<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@include file="../html/header.html" %>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<body>

	<div class="container">
		<h1 class="text-success">Farmily Details</h1>
		<hr />
		<s:form action="saveProcess" modelAttribute="farmily">
			<s:hidden path="id" />
			<s:hidden path="" value="${farmily.hobbies}" id="hobbies" />
			
			<div class="form-group">
				<s:input path="fullname" class="form-control border border-success"
				placeholder="Enter Full Name" />
			</div>

			<div class="form-group">
				<s:input path="email" placeholder="Enter Email" class="form-control border border-success" />
			</div>
			
			<div class="form-group border border-success">
				<div class="form-check-inline">
					<label class="form-check-label">
						<s:radiobutton path="gender" value="Male" class="form-check-input"/>Male
					</label>
				</div>
			
				<div class="form-check-inline">
					<label class="form-check-label">
						<s:radiobutton path="gender" value="Female" class="form-check-input"/>Female
					</label>
				</div>
			</div>
			
			<div class="form-group border border-success">
				<div class="form-check-inline">
					<label class="form-check-label">
						<s:checkbox path="hobbies" value="Sports" class="form-check-input"/>Sports
					</label>
				</div>
				
				<div class="form-check-inline">
					<label class="form-check-label">
						<s:checkbox path="hobbies" value="Browsing" class="form-check-input"/>Browsing
					</label>
				</div>
				
				<div class="form-check-inline">
					<label class="form-check-label">
						<s:checkbox path="hobbies" value="Running" class="form-check-input"/>Running
					</label>
				</div>
				
				<div class="form-check-inline">
					<label class="form-check-label">
						<s:checkbox path="hobbies" value="Chatting" class="form-check-input"/>Chatting
					</label>
				</div>
			</div>
				
			<div class="form-group">
				<s:select path="country" class="form-control border border-success">
					<s:option value="0">--Select--</s:option>
					<s:option value="Viet Nam">Viet Nam</s:option>
					<s:option value="India">India</s:option>
					<s:option value="Australia">Australia</s:option>
					<s:option value="Japan">Japan</s:option>
					<s:option value="America">America</s:option>
					<s:option value="South Africa">South Africa</s:option>
					<s:option value="Sri Lanka">Sri Lanka</s:option>
				</s:select>
			</div>
				
			<div class="form-group border border-success">
				<s:textarea path="address" placeholder="Enter Address"
				class="form-control" />
			</div>
			<input type="submit" value="Save" class="btn btn-outline-success" />&nbsp; 
			<input type="reset" value="Reset" class="btn btn-outline-danger" />

		</s:form>
		<hr />
		<a href="listOfFarmily">Back to List</a>
	</div>
	<script
		src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var hobbies = $("#hobbies").val().split(",");
			var $checkboxes = $("input[type=checkbox]");
			$checkboxes.each(function(idx, element) {
				if (hobbies.indexOf(element.value) != -1) {
					element.setAttribute("checked", "checked");
					$("#hobbies").val("");
				} else {
					element.removeAttribute("checked");
				}
			});
		});
	</script>
</body>
</html>