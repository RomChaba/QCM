<%@page import="fr.eni.QCM.BO.Test"%>
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
</style>
<%
Test t = (Test)session.getAttribute("test");

%>

<body>
<%@ include file="../../menu/JSP_menuBar.jsp"%>

<div class="col-md-12">
	<h1>Test : <%= t.getLibelle() %></h1>
</div>

<div class="col-md-6">
	<div class="col-md-12">
	<table class="table table-bordred table-striped" style="margin-top: 2.5em;">
	<thead>
		<th>Titre</th>
		<th>Nb question</th>
		<th class="text-center">Modifier</th>
		<th class="text-center">Enlever</th>
	</thead>
	<tbody>
		<%
	Map<Section,Integer> sectionTest = (Map<Section,Integer>)request.getAttribute("sectionTest");
	
	Set<Section> sectioncles = sectionTest.keySet();
	
	Iterator sectionit = sectioncles.iterator();
	
	while(sectionit.hasNext()){
		Section s1 = (Section)sectionit.next();
		int nbquestion = sectionTest.get(s1);
		
		%>
		<tr>
			<td><%= s1.getLibelle() %></td>
			<td class="text-center"><%= nbquestion %></td>
			<td class="text-center"><a href="<%=request.getContextPath()%>/SectionController?modifid=<%=s1.getId() %>" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a></td>		
			<td class="text-center"><a href="<%=request.getContextPath()%>/SectionController?selectDel=<%=s1.getId()%>&idTest=<%=t.getId()%>" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span></a></td>
		</tr>
		<%
	}
	%>
	
	
	
	
	<%-- Exemple a utiliser pour l'automatisation --%>
	 <!--
	<tr>
	<td>Diag de Classe</td>
	<td class="text-center">50</td>
	<td class="text-center"><a class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span></a></td>
	<td class="text-center"><a class="btn btn-default"><span class="glyphicon glyphicon-remove"></span></a></td>
	</tr>
	-->
	</tbody>
	</table>
	
	</div>
</div>
<div class="col-md-6">
	<div class="col-md-6">
		<p>Sections disponible : </p>
	</div>
	<div class="col-md-2">
		<a href="<%=request.getContextPath()%>/CreerModifSection" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span>Créer une nouvelle section</a>
	</div>
	<div class="col-md-12">
	<table class="table table-bordred table-striped">
	<thead>
		<th>Titre</th>
		<th class="text-center">Nb question</th>
		<th class="text-center">Modifier</th>
		<th class="text-center">Supprimer</th>
		<th class="text-center">Ajouter</th>
	</thead>
	<tbody>
	<%-- Exemple a utiliser pour l'automatisation --%>
	<%
	Map<Section,Integer> secEtNbQue = (Map<Section,Integer>)request.getAttribute("sectionsEtQues");
	
	Set<Section> cles = secEtNbQue.keySet();
	
	Iterator it = cles.iterator();
	
	while(it.hasNext()){
		Section s = (Section)it.next();
		int nbquestion = secEtNbQue.get(s);
		
		%>
		<tr>
		<td><%= s.getLibelle() %></td>
		<td class="text-center"><%= nbquestion %></td>
		<td class="text-center"><a href="<%=request.getContextPath()%>/SectionController?modifid=<%=s.getId() %>" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a></td>		
		<td class="text-center"><a href="<%=request.getContextPath()%>/SectionController?suppid=<%=s.getId() %>" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span></a></td>
		<td class="text-center"><a href="<%=request.getContextPath()%>/SectionController?addid=<%=s.getId() %>&idtest=<%= t.getId()%>&nomTest=<%= t.getLibelle()%>" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span></a></td>
		
		</tr>
		<%
	}
	%>
	

	</tbody>
	</table>
	
	</div>
</div>
<div class="text-center">
<a href="<%=request.getContextPath() %>/Test" class="btn btn-default"><span class="glyphicon glyphicon-arrow-left"></span>&nbsp;Retour à la liste des tests</a>
</div>		

</body>
</html>