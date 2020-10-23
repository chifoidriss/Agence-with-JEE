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
<title>Add Voiture</title>
<%@ include file="../include/link-css.jsp" %>
</head>
<body>
	<%@ include file="../include/header.jsp" %>
	
	<div class="container-fluid">
		<h2>Ajouter une Voiture</h2>
		<form method="POST" class="form">
			<c:if test="${!empty msg}"><div class="alert alert-warning"> ${msg} </div></c:if>
			<div class="form-group">
				<label>Immatriculation:</label>
				<input type="text" name="immatriculation" class="form-control">
			</div>
			<div class="form-group">
				<label>Nombre de places:</label>
				<input type="text" name="nbPlaces" class="form-control">
			</div>
			<div class="form-group">
				<label>Categories:</label>
				<input type="text" name="categorie" class="form-control">
			</div>
			<button type="submit" class="btn bnt-primary">Ajouter</button>
		</form>
	
		<h2>Liste des Voitures</h2><hr>
		<table class="table table-responsive table-striped table-bordered">
			<thead>
				<tr>
					<th>Immatriculation</th>
					<th>Nombre de places</th>
					<th>Categories</th>
				</tr>
			</thead>
			<tbody>				
				<c:forEach items="${voit}" var="v">
					<tr>
						<td>${v.immatriculation}</td>
						<td>${v.nbPlaces}</td>
						<td>${v.categorie}</td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
	</div>
</body>
</html>