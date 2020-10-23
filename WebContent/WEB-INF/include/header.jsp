<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Navigation -->
  <nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
          <span class="sr-only">Toggle nav</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>

        <!-- Logo text or image -->
        <a class="navbar-brand" href="home">RS Online</a>

      </div>
      <div class="navigation collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav">
          <li class="current"><a href="home">Home</a></li>
          <c:if test="${empty sessionScope.personne && empty sessionScope.chef}">
          	<li><a href="login">Se connecter</a></li>
          	<li><a href="connectChef">Admin</a></li>
          </c:if>
          <c:if test="${!empty sessionScope.chef}">
          	<li><a href="admin">Admin</a></li>
          </c:if>
          <c:if test="${!empty sessionScope.personne || !empty sessionScope.chef}">
          	<li><a href="sigout">Déconnexion</a></li>
          </c:if>
        </ul>
      </div>
    </div>
  </nav>