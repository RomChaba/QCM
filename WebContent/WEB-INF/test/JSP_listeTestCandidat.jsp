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

</style>

<body>
<%@ include file="../../menu/JSP_menuBar.jsp"%>

<div class="col-md-12">
	<h1>Liste des tests : </h1>
	<table class="table table-bordred table-striped">
	<thead>
		<th>Titre</th>
		<th>Nb question</th>
		<th>Date de création</th>
		<th>Commencer</th>
	</thead>
	<tbody>
	<%-- Exemple a utiliser pour l'automatisation --%>
	<tr>
	<td>PHP</td>
	<td>50</td>
	<td>20/05/2017</td>
	<td><a class="btn btn-primary"><span class="glyphicon glyphicon-list-alt"></span></a></td>
	</tr>
	</tbody>
	</table>
</div>		

</body>
</html>