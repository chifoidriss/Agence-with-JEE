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
<title>Admin</title>
<%@ include file="../include/link-css.jsp" %>
</head>
<body>
	<%@ include file="../include/header.jsp" %>
	
	<section class="container-fluid margin-top">
		<h2>Administration</h2>
		
		<div class="row">
			<div class="list-group col-sm-3">
				<div class="list-group-item active">
					<h4 class="list-group-item-heading">Gestion des Agences</h4>
				</div>
				<a href="add-agence" class="list-group-item">
					<p class="list-group-item-text">Ajouter une agence</p>
					<p class="list-group-item-text">Lister les agence</p>
					<button class="btn btn-primary btn-block">Gérer</button>
				</a>
			</div>
			
			<div class="list-group col-sm-3">
				<div class="list-group-item active">
					<h4 class="list-group-item-heading">Gestion des Voitures</h4>
				</div>
				<a href="add-voiture" class="list-group-item">
					<p class="list-group-item-text">Ajouter une voiture</p>
					<p class="list-group-item-text">Lister les voitures</p>
					<button class="btn btn-primary btn-block">Gérer</button>
				</a>
			</div>
			
			<div class="list-group col-sm-3">
				<div class="list-group-item active">
					<h4 class="list-group-item-heading">Gestion des Chefs d'agences</h4>
				</div>
				<a href="register-chef" class="list-group-item">
					<p class="list-group-item-text">Ajouter un chef d'agence</p>
					<p class="list-group-item-text">Lister les chefs d'agence</p>
					<button class="btn btn-primary btn-block">Gérer</button>
				</a>
			</div>
			
			<div class="list-group col-sm-3">
				<div class="list-group-item active">
					<h4 class="list-group-item-heading">Gestion des Voyages</h4>
				</div>
				<div class="list-group-item">
					<p class="list-group-item-text">Programmer un Voyage</p>
					<p class="list-group-item-text">Lister les Voyages</p>
					<p class="list-group-item-text">Détail d'un Voyage</p>
					<a href="add-voyage">
						<button class="btn btn-primary btn-block">Gérer</button>
					</a>
				</div>
			</div>
		</div>
	</section>
</body>
</html>