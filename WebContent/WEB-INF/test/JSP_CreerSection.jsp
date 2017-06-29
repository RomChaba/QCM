<%@page import="fr.eni.QCM.BO.Question"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="fr.eni.QCM.BO.Section"%>
    <%@page import="fr.eni.QCM.DAL.QuestionDAO"%>
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
	
	.green {
		color: #5cb85c;
	}
	
	.red {
	 	color: #d9534f;
	}
</style>

<body>
<%@ include file="../../menu/JSP_menuBar.jsp"%>
<div class="col-md-12">
<%
if(request.getAttribute("section")!=null){
	
	%>
	<h1>Modification d'une section :</h1>
<%
}else{
%>
	<h1>Création de section :</h1>
<%	
}
%>
<div class="text-center">
<form action="<%=request.getContextPath()%>/SectionController" class="form-inline" method="POST">
<div class="form-group">
<label for="libelle">Libelle : </label>

<%
if(request.getAttribute("section")!=null){
	Section s = (Section)request.getAttribute("section");
	%>
	<input type="hidden" name="modif" value="<%= s.getId() %>"/>
	<input type="text" name="libelle" id="libelle" class="form-control" value="<%= s.getLibelle() %>" />
<%
}else{
%>
	<input type="hidden" name="add" />
	<input type="text" name="libelle" id="libelle" class="form-control" />
<%	
}
%>
</div>
<button type="submit" class="btn btn-success form-control" ><span class="glyphicon glyphicon-arrow-right"></span>&nbsp;Valider</button>
</form>
</div>
<br><br>

<%
if(request.getAttribute("section")!=null){
	Section s = (Section)request.getAttribute("section");

	ArrayList<Question> LesQuestions = (ArrayList<Question>)request.getAttribute("LesQuestions");
%>
		<div class="col-md-6" style="margin: 0 auto; float: none">
		<h2 style="float: left;">Liste des Questions : </h2>
		<a href="./Question?section=<%= s.getId() %>" style="float: right;" class="btn btn-primary">
			<span class="glyphicon glyphicon-plus"></span>
			Aj	outer une Question
		</a>
		<table class="table table-bordred table-striped">
		<tbody>
			<%
			if (LesQuestions != null && !LesQuestions.isEmpty()) {
				for (Question q : LesQuestions) { %>
					<tr>
						<td><%= q.getLibelle() %></td>
						<td style="width: 30px"><a href="<%=request.getContextPath() %>/Question?update=<%= q.getId() %>" class='btn btn-warning'><span class='glyphicon glyphicon-pencil'></span></a></td>
						<td style="width: 30px"><a href="<%=request.getContextPath() %>/Question?delete=<%= q.getId() %>" class='btn btn-danger'><span class='glyphicon glyphicon-remove'></span></a></td>			
					</tr>
				<% }
			}%>
	</tbody>
	</table>
</div>	
	
</div>
<div class="text-center">
<a href="" class="btn btn-default"><span class="glyphicon glyphicon-arrow-left"></span>&nbsp;Annuler</a>
<a href="" class="btn btn-default"><span class="glyphicon glyphicon-arrow-left"></span>&nbsp;Retour</a>
</div>		
<% } %>
</body>
</html>