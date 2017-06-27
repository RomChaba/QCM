<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<%@ include file="../../menu/menuBar.jsp"%>
<div class="col-md-12">
<p class="text-center"><i>Veuilliez choisir ou créer une section du test</i></h1>
<div class="col-md-6">
	<div class="col-md-6">
	<p>Section du test : </p>
	</div>
	<div class="col-md-2">
	<a href="" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span>Créer une nouvelle section</a>
	</div>
	
	
	<div class="col-md-12">
	<table class="table table-bordred table-striped">
	<thead>
		<th>Titre</th>
		<th>Nb question</th>
		<th>Date de création</th>
		<th>Modifier</th>
		<th>Supprimer</th>
	</thead>
	<tbody>
	<%-- Exemple a utiliser pour l'automatisation --%>
	<tr>
	<td>Diag de Classe</td>
	<td class="text-center">50</td>
	<td>20/05/2017</td>
	<td class="text-center"><a class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span></a></td>
	<td class="text-center"><a class="btn btn-default"><span class="glyphicon glyphicon-remove"></span></a></td>
	</tr>
	</tbody>
	</table>
	
	</div>
</div>
<div class="col-md-6">
		<div class="col-md-6">
	<p>Sections disponible : </p>
	</div>
	<div class="col-md-12">
	<table class="table table-bordred table-striped">
	<thead>
		<th>Titre</th>
		<th>Nb question</th>
		<th>Date de création</th>
		<th>Ajouter</th>
	</thead>
	<tbody>
	<%-- Exemple a utiliser pour l'automatisation --%>
	<tr>
	<td>Diag de Classe</td>
	<td class="text-center">50</td>
	<td>20/05/2017</td>
	<td class="text-center"><a class="btn btn-default"><span class="glyphicon glyphicon-plus"></span></a></td>
	</tr>
	</tbody>
	</table>
	
	</div>
</div>
</div>
<div class="text-center">
<a href="" class="btn btn-default"><span class="glyphicon glyphicon-arrow-left"></span>&nbsp;Annuler</a>
<a href="" class="btn btn-default"><span class="glyphicon glyphicon-arrow-left"></span>&nbsp;Retour</a>
<a href="" class="btn btn-default"><span class="glyphicon glyphicon-arrow-right"></span>&nbsp;Valider</a>
</div>		

</body>
</html>