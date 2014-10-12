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
		<div class="container-fluid">
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title text-center">Budget du mois de ${budget.month()}</h3>
					</div>

<table class="table">
	<tr>
		<th colspan='2'></th>
		<#list persons as person>
			<th class="text-center">${person}</th>
		</#list>
		<th class="text-center">Total</th>
	</tr>
	<tr class="info">
		<td colspan='2'>Revenue</td>
		<#list persons as person>
			<td class="text-center">${budget.totalRevenues(person)} €</td>
		</#list>
		<td class="text-center">${budget.totalRevenues()} €</td>
	</tr>
	<#list categories as category>
		<tr class="warning">
			<td colspan='2'>${category.name()}</td>
			<#list persons as person>
				<td class="text-center">${budget.totalDepenses(category, person)} €</td>
			</#list>
			<td class="text-center">${budget.totalDepenses(category)} €</td>
		</tr>
		<#list category.subCategories() as subCategory>
			<tr>
				<td></td>
				<td>${subCategory.name()}</td>
				<#list persons as person>
					<td class="text-center">${budget.totalDepenses(subCategory, person)} €</td>
				</#list>
				<td class="text-center">${budget.totalDepenses(subCategory)} €</td>
			</tr>
		</#list>
	</#list>
	<tr class="danger">
		<td colspan='2'>Reste</td>
		<#list persons as person>
			<td class="text-center">${budget.totalRevenues(person) - budget.totalDepenses(person)} €</td>
		</#list>
		<td class="text-center">${budget.totalRevenues() - budget.totalDepenses()} €</td>
	</tr>
</table>

				</div>
			</div>
		</div>
	</body>
</html>