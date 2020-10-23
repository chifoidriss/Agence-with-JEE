<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <title>Home</title>
  <%@ include file="../include/link-css.jsp" %>
  <meta charset="utf-8" />
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
</head>

<body>

<%@ include file="../include/header.jsp" %>

  <!-- Services -->
  <section id="services" class="home-section bg-white">
    <div class="container">
      <div class="row">
        <div class="col-md-offset-2 col-md-8">
          <div class="section-heading">
            <h2>Nos Voyages</h2>
            <div class="heading-line"></div>
            <p>Ici sont listés les prochains voyages programmés.</p>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-12">
          <div id="carousel-service" class="service carousel slide">

            <!-- slides -->
            <div class="carousel-inner">
            	
	            <section class="container-fluid">
					<div class="row">
						<c:forEach items="${voy}" var="v">
							<div class="list-group col-sm-4">
								<div class="list-group-item">
									<h6 class="list-group-item-heading">
										${v.depart.nom} [${v.depart.adresse}]
									</h6>
								</div>
								<div class="list-group-item">
									<h6 class="list-group-item-heading">
										${v.arrivee.nom} [${v.arrivee.adresse}]
									</h6>
								</div>
								<div class="list-group-item">								
									De ${v.dateDepart}
								</div>
								<div class="list-group-item">						
									Pour ${v.dateArrivee}
								</div>
								<a href="reserver?idVoy=${v.id}" class="list-group-item">
									<button class="btn btn-primary btn-block">Réserver</button>
								</a>
							</div>
						</c:forEach>
					</div>	
				</section>
            </div> 
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- Team -->
  <section id="team" class="home-section bg-white">
    <div class="container">
      <div class="row">
        <div class="col-md-offset-2 col-md-8">
          <div class="section-heading">
            <h2>Notre équipe</h2>
            <div class="heading-line"></div>
            <p>Les membres du groupe</p>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
          <div class="box-team wow bounceInUp" data-wow-delay="0.1s">
            <img src="./assets/img/team/1.jpg" alt="" class="img-circle img-responsive" />
            <h4>Idriss CHIFO</h4>
            <p>Web Designer</p>
          </div>
        </div>
        <div class="col-xs-12 col-sm-3 col-md-3 col-lg-3" data-wow-delay="0.3s">
          <div class="box-team wow bounceInUp">
            <img src="./assets/img/team/2.jpg" alt="" class="img-circle img-responsive" />
            <h4>Ronaldo DIEFOUO</h4>
            <p>Backend Developper</p>
          </div>
        </div>
        <div class="col-xs-12 col-sm-3 col-md-3 col-lg-3" data-wow-delay="0.5s">
          <div class="box-team wow bounceInUp">
            <img src="./assets/img/team/3.jpg" alt="" class="img-circle img-responsive" />
            <h4>Lionel NGANSOP</h4>
            <p>Database Manager</p>
          </div>
        </div>
        <div class="col-xs-12 col-sm-3 col-md-3 col-lg-3" data-wow-delay="0.7s">
          <div class="box-team wow bounceInUp">
            <img src="./assets/img/team/4.jpg" alt="" class="img-circle img-responsive" />
            <h4>Alex KAMMEGNE</h4>
            <p>Backend Developper</p>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- Contact -->
  <section id="contact" class="home-section bg-gray">
    <div class="container">
      <div class="row">
        <div class="col-md-offset-2 col-md-8">
          <div class="section-heading">
            <h2>Nous Contacter</h2>
            <div class="heading-line"></div>
            <p>Si vous avez des problèmes veuillez nous contacter ici. </p>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-md-offset-2 col-md-8">
          <div id="sendmessage">Votre message a été envoyé. Merci!</div>
          <div id="errormessage"></div>

          <form action="" method="post" class="form-horizontal contactForm" role="form">
            <div class="col-md-offset-2 col-md-8">
              <div class="form-group">
                <input type="text" name="name" class="form-control" id="name" placeholder="Votre Nom" data-rule="minlen:4" data-msg="Entrer au moins 4 caractères" />
                <div class="validation"></div>
              </div>
            </div>

            <div class="col-md-offset-2 col-md-8">
              <div class="form-group">
                <input type="email" class="form-control" name="email" id="email" placeholder="Votre Email" data-rule="email" data-msg="Enter une email valid" />
                <div class="validation"></div>
              </div>
            </div>

            <div class="col-md-offset-2 col-md-8">
              <div class="form-group">
                <input type="text" class="form-control" name="subject" id="subject" placeholder="Sujet" data-rule="minlen:4" data-msg="Entrer entre 4 et 8 caractères pour le sujet" />
                <div class="validation"></div>
              </div>
            </div>

            <div class="col-md-offset-2 col-md-8">
              <div class="form-group">
                <textarea class="form-control" name="message" rows="5" data-rule="required" data-msg="Entrer quelque chose ici" placeholder="Message"></textarea>
                <div class="validation"></div>
              </div>
            </div>
            <div class="form-group">
              <div class="col-md-offset-2 col-md-8">
                <button type="submit" class="btn btn-theme btn-lg btn-block">Envoyer message</button>
              </div>
            </div>
          </form>

        </div>
      </div>

    </div>
  </section>

  <!-- Footer -->
  	<%@ include file="../include/footer.jsp" %>

</body>
</html>
