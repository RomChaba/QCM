<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni.QCM.BO.TypeTest"%>
<%@page import="fr.eni.QCM.BO.Test"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste Test</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<style>
/* Move down content because we have a fixed navbar that is 50px tall */
body {
  padding-top: 50px;
  padding-bottom: 20px;
}
#timermin,#timersec{
	width:5em!important;
}
.creaTest{
	padding-bottom:1em!important;
}
</style>

<body>
<%@ include file="../../menu/JSP_menuBar.jsp"%>
<%
	Test leTest = (Test)request.getAttribute("test");
	ArrayList<TypeTest> AllTypes = (ArrayList<TypeTest>)request.getAttribute("types");
%>
	
	
<div class="col-md-12">
<%	if(leTest != null) { %>
	<h1 class="text-center">Modification d'un test</h1>
<%	} else { %>
	<h1 class="text-center">Création d'un test</h1>
<% } %>

	<div class="col-md-offset-2 col-md-8 well">
		<form action="./Test/Add" class="form-inline" method="POST">
			<div class="creaTest form-group col-md-12">
				<label class="col-md-4" for="nom">Nom : </label>
				<%	if(leTest != null) { %>
						<input type="hidden" name="update" value="<%= leTest.getId() %>" />
						<input class="form-control" type="text" name="nom" id="nom" value="<%= leTest.getLibelle() %>"/>
				<%	} else { %>
						<input type="hidden" name="update" value="0" />
						<input class="form-control" type="text" name="nom" id="nom" />
				<% 	} %>
			</div>
				<div class="creaTest form-group col-md-12">
					<label class="col-md-4" for="timer">Timer : </label>
					<%	if(leTest != null) { %>
						<span><input class="form-control" type="number" name="timermin" id="timermin" min="0" max="60" value="<%= leTest.getTimer() / 60 %>"/>&nbsp;minutes</span>
						<span><input class="form-control" type="number" name="timersec" id="timersec" min="0"  max="60" value="<%= leTest.getTimer() % 60 %>"/> secondes</span>
					<%	} else { %>
						<span><input class="form-control" type="number" name="timermin" id="timermin" min="0"  max="60" value="0" />&nbsp;minutes</span>
						<span><input class="form-control" type="number" name="timersec" id="timersec" min="0"  max="60" value="0" /> secondes</span>
					<% 	} %>
				</div>
				<div class="creaTest form-group col-md-12">
					<label class="col-md-4" for="type">Type : </label>
					<select name="type" id="type" class="form-control">
<%						if (AllTypes != null && !AllTypes.isEmpty()) {
							for (TypeTest type : AllTypes) {
%>
								<option value="<%= type.getId() %>" 
									<%	if(leTest != null && leTest.getTypeTest().getId() == type.getId()) { %>
											selected="selected"
									<%	} %>
								>
									<%= type.getLibelle() %>
								</option>	
<%							}
						}
%>					</select>
				</div>
				<div class="text-center">
					<a style="margin-right:1em" href="/" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-arrow-left"></span>Annuler</a>
					<input type="submit" class="btn btn-success btn-lg" value="Sauvegarder"/>
				</div>
			</form>
		</div>

</div>		

</body>
</html>