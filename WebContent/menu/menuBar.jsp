<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="fr.eni.QCM.BO.Formateur"%>
<%@page import="fr.eni.QCM.BO.Candidat"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <span>
          	<a class="navbar-brand" href="/RomainAntoineQCM/">QCM ENI</a>
          	<img src="http://www.lemag-numerique.com/wp-content/uploads/2014/02/photo.jpg" style="height:50px;width:50px" />
          </span>
        </div>
        
   	<%
		if(session.getAttribute("user") == "2"){
			Candidat c = (Candidat) session.getAttribute("Candidat");
			%>
			<div id="navbar" class="navbar-collapse collapse">
				<p>Bienvenue <%= c.getNom() %></p>          
        	</div><!--/.navbar-collapse -->
			<%
		}else if (session.getAttribute("user") == "1"){
			Formateur f = (Formateur) session.getAttribute("Formateur");
		%>
		<div id="navbar" class="navbar-collapse collapse">
			<p>Bienvenue <%= f.getNom() %></p>
		</div><!--/.navbar-collapse -->
		<%
		}else{
		%>
		<div id="navbar" class="navbar-collapse collapse">
          <form action="<%=request.getContextPath() %>/Connexion" method="POST" class="navbar-form navbar-right">
            <div class="form-group">
              <input name="login" type="text" placeholder="Login" class="form-control">
            </div>
            <div class="form-group">
              <input name="pwd" type="password" placeholder="Mot de passe" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Connexion</button>
          </form>
        </div><!--/.navbar-collapse -->
		<%
		}
	%>
        
        
        
        
      </div>
    </nav>