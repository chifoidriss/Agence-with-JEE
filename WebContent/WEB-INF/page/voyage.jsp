<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty sessionScope.chef}">
	<c:redirect url="/connectChef"></c:redirect>
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
		<h2>Voyage</h2>
		
		<div class="row card">
			<div class="list-group col-md-12">
				<div class="list-group-item">
					<h4 class="list-group-item-heading">${voy.depart.nom} ${voy.depart.adresse}</h4>
				</div>
				<div class="list-group-item">
					<h4 class="list-group-item-heading">${voy.arrivee.nom} ${voy.arrivee.adresse}</h4>
				</div>
				<div class="list-group-item">
					<h4 class="list-group-item-heading">Heure de départ: ${voy.dateDepart}</h4>
				</div>
				<div class="list-group-item">
					<h4 class="list-group-item-heading">Heure d'arrivée: ${voy.dateArrivee}</h4>
				</div>
				<div class="list-group-item">
					<h4 class="list-group-item-heading">Prix: ${voy.prix} FCFA</h4>
				</div>
				<div class="list-group-item">
					<h4 class="list-group-item-heading">Type: ${voy.type}</h4>
				</div>
				<div class="list-group-item">
					<h4 class="list-group-item-heading">Voiture: ${voy.v.immatriculation}</h4>
				</div>
				
				<div class="list-group-item">
					<h4 class="list-group-item-heading">Nombre de places: ${voy.v.nbPlaces}</h4>
				</div>
			</div>
			
			<div class="list-group col-sm-12">
				<div class="list-group-item active">
					<h4 class="list-group-item-heading">Liste des Réservations</h4>
				</div>
				<c:forEach items="${ress}" var="res">
					<div class="list-group-item">
						<p class="list-group-item-text">${res.idCli.nom} ${res.idCli.prenom}</p>
						<p class="list-group-item-text">Tel: ${res.idCli.telephone}</p>
						<p class="list-group-item-text">Le ${res.dateReserve}</p>
					</div>
				</c:forEach>
			</div>
		
		</div>
	</section>
</body>
</html>