<!DOCTYPE html>
<html lang='en'>
	<head>
		<meta charset='utf-8'>
		<meta http-equiv='X-UA-Compatible' content='IE=edge'>
		<meta name='viewport' content='width=device-width, initial-scale=1'>
		<title>Budget</title>
		<link href="/img/favicon.ico" rel="icon" />
		<link href='/css/bootstrap.min.css' rel='stylesheet' />
		<script src='/js/jquery-1.11.1.min.js'></script>
		<script src='/js/bootstrap.min.js'></script>
	</head>
	<body>

<ul>
	<#list depenses as depense>
		<li>${depense.created()?date} - ${depense.person()} - ${depense.montant()} €</li>
	</#list>
</ul>

	</body>
</html>