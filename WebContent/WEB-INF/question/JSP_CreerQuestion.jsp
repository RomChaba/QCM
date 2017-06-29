<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni.QCM.BO.TypeTest"%>
<%@page import="fr.eni.QCM.BO.Test"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cr�er une Question</title>
	</head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">


	<body>
		<%@ include file="../../menu/JSP_menuBar.jsp"%>
		
		<div class="col-md-12">
			<h1 class="text-center">Cr�er une Question</h1>
		</div>
		
		
		<div class="col-md-offset-2 col-md-8 well">
			<form action="./Test/Add" class="form-inline" method="POST">
			
				<!-- QUESTION -->
				<div class="creaTest form-group col-md-12">
					<label class="col-md-3" for="nom">Question : </label>
					<textarea class="col-md-9" rows="2" name="libelle"></textarea>
				</div>
			
				<!-- TYPE -->
				<div class="creaTest form-group col-md-12">
					<label class="col-md-3" for="nom">Type : </label>
					<label class="col-md-1"></label>
					<label class="col-md-1">QCU</label>
					<input class="col-md-1" name="type" type="radio" value="1">
					<label class="col-md-2"></label>
					<label class="col-md-1">QCM</label>
					<input class="col-md-1" name="type" type="radio" value="2">
				</div>
				
				<!-- R�ponses -->
				<div class="creaTest form-group col-md-12">
				<label class="col-md-3" for="nom">R�ponses : </label>
					<table class="table table-bordred table-striped">
						<tbody>
							<tr>
								<td><span class='glyphicon glyphicon-ok green'></span></td>
								<td>Hypertexte Processor</td>
								<td><a class='btn btn-warning'><span class='glyphicon glyphicon-pencil'></span></a></td>
								<td><a class='btn btn-danger'><span class='glyphicon glyphicon-remove'></span></a></td>			
							</tr>
							<tr>
								<td><span class='glyphicon glyphicon-remove red'></span></td>
								<td>reponse 2</td>
								<td><a class='btn btn-warning'><span class='glyphicon glyphicon-pencil'></span></a></td>
								<td><a class='btn btn-danger'><span class='glyphicon glyphicon-remove'></span></a></td>			
							</tr>	
						</tbody>
					</table>
				</div>
				
				<!-- Type de Question -->
				
				
				
				
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