<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> User Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					
					<c:if test="${user != null}">
            			Edit User
            		</c:if>
					<c:if test="${user == null}">
            			Add New User
            		</c:if>
					
				</caption>

				<%-- <c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if> --%>
				
				<fieldset class="form-group">
					<label>ID</label> <input type="text"
						value="<c:out value='${user.id}' />" class="form-control"
						name="id" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Name</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Unit</label> <input type="text"
						value="<c:out value='${user.unit}' />" class="form-control"
						name="unit">
				</fieldset>

				<fieldset class="form-group">
					<label>Taluk</label> <input type="text"
						value="<c:out value='${user.taluk}' />" class="form-control"
						name="taluk">
				</fieldset>
				
				<fieldset class="form-group">
					<label>District</label> <input type="text"
						value="<c:out value='${user.district}' />" class="form-control"
						name="district">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Father Name</label> <input type="text"
						value="<c:out value='${user.fatherName}' />" class="form-control"
						name="fatherName">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${user.address}' />" class="form-control"
						name="address">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Adhaar Number</label> <input type="text"
						value="<c:out value='${user.adhaarNo}' />" class="form-control"
						name="adhaarNo">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Mobile Number</label> <input type="text"
						value="<c:out value='${user.mobNo}' />" class="form-control"
						name="mobNo">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
	

</body>
</html>