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
  		if(session.getAttribute("type") != null){
	   		int type = Integer.valueOf(session.getAttribute("type").toString());
			if(type == 2){
				Candidat c = (Candidat) session.getAttribute("Candidat");
				%>
				
					<a class="navbar-brand" style="color:white">Bienvenue <%= c.getPrenom() %> <%= c.getNom() %></a>          
					<a class="btn btn-warning form-control" href="<%=request.getContextPath() %>/Connexion?deconnexion=1">Déconnexion</a>
					
	        	</div>
				<%
			}else if (type == 1){
				Formateur f = (Formateur) session.getAttribute("Formateur");
			%>
			
				<a class="navbar-brand text-center" style="color:white;padding-left:1em">Bienvenue <%=f.getPrenom() %> <%= f.getNom() %></a>
				<div class="navbar-form navbar-right">
				<div class="form-group">
				<a class="btn btn-default form-control" href="<%=request.getContextPath()%>/ListeTest">Liste Test</a>
				</div>
				<div class="form-group">
				<a class="btn btn-warning form-control" href="<%=request.getContextPath() %>/Connexion?deconnexion=1">Déconnexion</a>
				</div>
				</div>
				
			<%
			}
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