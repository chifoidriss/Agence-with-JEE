<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty sessionScope.personne}">
	<c:redirect url="/login"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Réservation</title>
<%@ include file="../include/link-css.jsp" %>
</head>
<body>
	<%@ include file="../include/header.jsp" %>
	
	<div class="container-fluid">
		<h2>Informations sur le voyage</h2>
		
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
				
				<a href="reserve?idVoy=${voy.id}&idCli=${sessionScope.personne.id}" class="list-group-item">
					<button class="btn btn-primary btn-block">Réserver maintenant</button>
				</a>
			</div>
		</div>
	</div>
</body>
</html>