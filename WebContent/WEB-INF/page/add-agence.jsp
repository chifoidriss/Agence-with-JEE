<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty sessionScope.chef}">
	<c:redirect url="/home"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Agence</title>
<%@ include file="../include/link-css.jsp" %>
</head>
<body>
	<%@ include file="../include/header.jsp" %>
	
	<div class="container-fluid">
		<h2>Ajouter une Agence</h2>
		<form method="POST" class="form">
			<c:if test="${!empty msg}"><div class="alert alert-warning"> ${msg} </div></c:if>
			<div class="form-group">
				<label>Nom:</label>
				<input type="text" name="nom" class="form-control">
			</div>
			<div class="form-group">
				<label>Adresse:</label>
				<input type="text" name="adresse" class="form-control">
			</div>
			<button type="submit" class="btn bnt-primary">Ajouter</button>
		</form>
	
		<h2>liste des Agences</h2><hr>
		<table class="table table-responsive table-striped table-bordered">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Adresse</th>
				</tr>
			</thead>
			<tbody>				
				<c:forEach items="${ag}" var="a">
					<tr>
						<td>${a.nom}</td>
						<td>${a.adresse}</td>
					</tr>
				</c:forEach>
					
			</tbody>
		</table>
	</div>
</body>
</html>