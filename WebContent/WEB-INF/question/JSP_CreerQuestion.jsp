<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni.QCM.BO.Section"%>
<%@page import="fr.eni.QCM.BO.Question"%>
<%@page import="fr.eni.QCM.BO.Proposition"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Question</title>
	</head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<%
Question maQuestion = (Question)request.getAttribute("Question");
ArrayList<Proposition> lesPropositions = (ArrayList<Proposition>)request.getAttribute("Propositions");
%>
	<body>
		<%@ include file="../../menu/JSP_menuBar.jsp"%>
		<div class="col-md-12">
			<% if(maQuestion != null) { %>
				<h1 class="text-center">Modifier une Question</h1>
			<% } else { %>
				<h1 class="text-center">Créer une Question</h1>
			<% } %>
		</div>
		<div class="col-md-offset-2 col-md-8 well">
			<form action="./Question/Add" class="form-inline" method="POST">
			
				<!-- QUESTION -->
				<div class="creaTest form-group col-md-12">
				<input type="hidden" name="idQuestion"
					<% if(maQuestion != null) { %>
						value="<%= maQuestion.getId() %>"
					<% } else { %>
						value="0"
					<% } %>
				>
					<label class="col-md-3" for="nom">Question : </label>
					<% if(maQuestion != null) { %>
						<textarea required class="col-md-9" rows="2" name="libelle"><%= maQuestion.getLibelle() %></textarea>
					<% } else { %>
						<textarea required class="col-md-9" rows="2" name="libelle"></textarea>
					<% } %>
				</div>
			
				<!-- TYPE -->
				<div class="creaTest form-group col-md-12">
					<label class="col-md-3" for="nom">Type : </label>
					<label class="col-md-1"></label>
					<label class="col-md-1">QCU</label>
					<input class="col-md-1" name="type" type="radio" value="1"
						<% if(maQuestion != null && maQuestion.getType().getId() == 1) { %>
							checked="checked"
						<% } else {%>
							checked="checked"
						<% } %>
					>
					<label class="col-md-2"></label>
					<label class="col-md-1">QCM</label>
					<input class="col-md-1" name="type" type="radio" value="2"
						<% if(maQuestion != null && maQuestion.getType().getId() == 2) { %>
							checked="checked"
						<% } %>
					>
				</div>
				
				
				<% if(maQuestion != null) { %>
					<!-- Réponses -->
					<div class="creaTest form-group col-md-12">
					<label class="col-md-3" for="nom">Réponses : </label>
					<a href="<%=request.getContextPath() %>/Reponse?idQuestion=<%= maQuestion.getId() %>" style="float: right; margin-bottom: 1em;" class="btn btn-primary">
						<span class="glyphicon glyphicon-plus"></span>
						Ajouter une réponse
					</a>
						
					<% if(lesPropositions != null && !lesPropositions.isEmpty()) { %>
						<table class="table table-bordred table-striped">
							<tbody>
							<% for (Proposition p : lesPropositions) { %>
								<tr>
									<% if(p.isReponse() == true) { %>
										<td><span class='glyphicon glyphicon-ok green'></span></td>
									<% } else { %>
										<td><span class='glyphicon glyphicon-remove red'></span></td>
									<% } %>
									<td><%= p.getLibelle() %></td>
									<td><a href="<%=request.getContextPath() %>/Reponse?idQuestion=<%= maQuestion.getId() %>&idProp=<%= p.getId() %>" class='btn btn-warning'><span class='glyphicon glyphicon-pencil'></span></a></td>
									<td><a href="<%=request.getContextPath() %>/Reponse?delProp=<%= p.getId() %>" class='btn btn-danger'><span class='glyphicon glyphicon-remove'></span></a></td>			
								</tr>							
							<% } %>
							</tbody>
						</table>
						<% } %>
					</div>
				<% } %>
				
				<!-- Type de Question -->
				<%
					ArrayList<Section> AllSections = (ArrayList<Section>)request.getAttribute("LesSections");
					Section maSection = (Section)request.getAttribute("maSection");
				%>
				<div class="creaTest form-group col-md-12">
					<label class="col-md-4" for="type">Type : </label>
					<select name="section" id="type" class="form-control">
<%						if (AllSections != null && !AllSections.isEmpty()) {
							for (Section s : AllSections) {
%>
								<option value="<%= s.getId() %>"
								<%	if(s.id == maSection.getId()){	%>
										selected="selected"
								<%	} %>
								>
									<%= s.getLibelle() %>
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
		
		
		
		

	</body>
</html>

<style>
	body {
		padding-top: 50px;
		padding-bottom: 20px;
	}
	
	.creaTest{
		padding-bottom:2em!important;
		margin-bottom:2em!important;
		border-bottom: 1px solid #AAA;
	}
	
	textarea {
		max-width: 75%;
		max-height: 200px;
	}
	
	.green {
		color: #5cb85c;
	}
	
	.red {
	 	color: #d9534f;
	}
</style>