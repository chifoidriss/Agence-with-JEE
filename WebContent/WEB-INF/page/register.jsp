<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${!empty sessionScope.personne}">
	<c:redirect url="/home"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<%@ include file="../include/link-css.jsp"%>
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	
	<section class="container-fluid">
		<div class="form">
			<h2>Créer un compte</h2>
			<form method="POST">
				<c:if test="${!empty msg}"><div class="alert alert-warning"> ${msg} </div></c:if>
				<div class="form-group">
					<label>Nom:</label>
					<input type="text" name="nom" class="form-control">
				</div>
				<div class="form-group">
					<label>Prenom:</label>
					<input type="text" name="prenom" class="form-control">
				</div>
				<div class="form-group">
					<label>Adresse Email:</label>
					<input type="email" name="email" class="form-control">
				</div>
				<div class="form-group">
					<label>Numéro:</label>
					<input type="number" name="telephone" class="form-control">
				</div>
				<div class="form-group">
					<label>Mot de passe:</label>
					<input type="password" name="password" class="form-control">
				</div>
				<div class="form-group">
					<label>Confirmation</label>
					<input type="password" name="confirm" class="form-control">
				</div>
				<button type="submit" class="btn btn-success btn-theme">Créer maintenant</button>
				<br><br>
				<a href="login"><button type="button" class="btn btn-primary">Se connecter</button></a>
			</form>
		</div>
	</section>
	
	<%@ include file="../include/footer.jsp"%>

  	<%@ include file="../include/link-js.jsp"%>
</body>
</html>