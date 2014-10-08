<!DOCTYPE html>
<html lang='en'>
	<head>
		<meta charset='utf-8'>
		<meta http-equiv='X-UA-Compatible' content='IE=edge'>
		<meta name='viewport' content='width=device-width, initial-scale=1'>
		<title>Budget</title>
		<link href='/css/bootstrap.min.css' rel='stylesheet'>
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
		<#list repositories.ofPerson().all() as person>
			<th class="text-center">${person.name()}</th>
		</#list>
		<th class="text-center">Total</th>
	</tr>
	<#list repositories.ofCategory().all() as category>
		<tr class="active">
			<td colspan='2'>${category.name()}</td>
			<#list repositories.ofPerson().all() as person>
				<td class="text-center">${budget.totalDepenses(category, person)} €</td>
			</#list>
			<td class="text-center">${budget.totalDepenses(category)} €</td>
		</tr>
		<#list category.subCategories() as subCategory>
			<tr>
				<td></td>
				<td>${subCategory.name()}</td>
				<#list repositories.ofPerson().all() as person>
					<td class="text-center">${budget.totalDepenses(subCategory, person)} €</td>
				</#list>
				<td class="text-center">${budget.totalDepenses(subCategory)} €</td>
			</tr>
		</#list>
	</#list>
	<tr class="danger">
		<td colspan='2'>Total</td>
		<#list repositories.ofPerson().all() as person>
			<td class="text-center">${budget.totalDepenses(person)} €</td>
		</#list>
		<td class="text-center">${budget.totalDepenses()} €</td>
	</tr>
</table>

				</div>
			</div>
		</div>
	</body>
</html>