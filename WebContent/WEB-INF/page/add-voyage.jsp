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
<title>Add Voyage</title>
<%@ include file="../include/link-css.jsp" %>
</head>
<body>
	<%@ include file="../include/header.jsp" %>
	
	<div class="container-fluid">
		<h2>Ajouter un Voyage</h2>
		<form method="POST" class="form">
			<c:if test="${!empty msg}"><div class="alert alert-warning"> ${msg} </div></c:if>
			<div class="form-group">
				<label>Depart:</label>
				<select name="depart" class="form-control">
					<c:forEach items="${ag}" var="a">
						<option value="${a.id}">[ ${a.nom} ] - [ ${a.adresse}]</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label>Arrivee:</label>
				<select name="arrivee" class="form-control">
					<c:forEach items="${ag}" var="a">
						<option value="${a.id}">[ ${a.nom} ] - [ ${a.adresse}]</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label>Date de depart:</label>
				<input type="datetime" name="dateDepart" class="form-control">
			</div>
			<div class="form-group">
				<label>Date d'arrivee:</label>
				<input type="datetime" name="dateArrivee" class="form-control">
			</div>
			<div class="form-group">
				<label>Prix:</label>
				<input type="number" name="prix" class="form-control">
			</div>
			<div class="form-group">
				<label>Type:</label>
				<select name="type" class="form-control">
					<option value="CLASSIC">Classic</option>
					<option value="VIP">VIP</option>
				</select>
			</div>
			<div class="form-group">
				<label>Selectionner une voiture:</label>
				<select name="idVoit" class="form-control">
					<c:forEach items="${voit}" var="v">
						<option value="${v.id}">[ ${v.immatriculation} ] - [ ${v.nbPlaces}] - [ ${v.categorie} ]</option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn bnt-primary">Ajouter</button>
		</form>
	
		<h2>liste des Voyages</h2><hr>
		<table class="table table-responsive table-striped table-bordered">
			<thead>
				<tr>
					<th>Depart</th>
					<th>Arrivee</th>
					<th>Date Depart</th>
					<th>Date Arrivee</th>
					<th>Prix</th>
					<th>Type</th>
					<th>Voiture</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>				
				<c:forEach items="${voy}" var="v">
					
						<tr>
							<td>${v.depart.nom} [${v.depart.adresse}]</td>
							<td>${v.arrivee.nom} [${v.arrivee.adresse}]</td>
							<td>${v.dateDepart}</td>
							<td>${v.dateArrivee}</td>
							<td>${v.prix}</td>
							<td>${v.type}</td>
							<td>${v.v.immatriculation}</td>
							<td>
								<a href="voyage?idVoy=${v.id}">	
									<button class="btn btn-success">info</button>
								</a>
							</td>
						</tr>
						
				</c:forEach>
					
			</tbody>
		</table>
	</div>
</body>
</html>