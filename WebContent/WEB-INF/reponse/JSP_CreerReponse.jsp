<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni.QCM.BO.TypeTest"%>
<%@page import="fr.eni.QCM.BO.Test"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Créer une Question</title>
	</head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">


	<body>
		<%@ include file="../../menu/JSP_menuBar.jsp"%>
		
		<div class="col-md-12">
			<h1 class="text-center">Créer une Réponse</h1>
		</div>
		
		
		<div class="col-md-offset-2 col-md-8 well">
		<h3>Question : <i style="color:red"><b>AJOUTER LE LIBELLE DE LA QUESTION</b></i></h3>
			<form action="./Test/Add" class="form-inline" method="POST">
				<div class="col-md-12 form-group">
					<label class="col-md-3" for="libelle">Libelle de la réponse : </label>
					<input type="text" name="libelle" id="libelle" class="col-md-9" />
				</div>
				<div class="col-md-12 form-group" style="padding-top:1em;padding-bottom:1em">
				<label style="padding-top:1em" class="col-md-5" for="verite">Cette réponse est la bonne réponse ?</label>
				<div class="col-md-7">
					<label class="checkbox-inline">
						<input value="1" type="radio" name="verite" id="verite1" class="form-control"/>
						OUI
					</label>
					<label class="checkbox-inline">
						<input value="0" type="radio" name="verite" id="verite2" class="form-control"/>
						NON
					</label>				
				</div>
				
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