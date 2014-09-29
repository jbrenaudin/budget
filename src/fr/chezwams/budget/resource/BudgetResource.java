package fr.chezwams.budget.resource;

import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import fr.chezwams.budget.domain.Budget;
import fr.chezwams.budget.domain.Category;
import fr.chezwams.budget.domain.Person;
import fr.chezwams.budget.domain.Repositories;
import fr.chezwams.budget.domain.SubCategory;

public class BudgetResource extends ServerResource {

	@Get
	public Representation getByToday() {
		Budget budget = Repositories.ofBudget().getByToday();
		
		String message = "Budget du mois de " + budget.month() + " :<br />";

		message += "<table width='100%' border='1'><tr>";
		message += "<th colspan='2'></th>";
		for (Person person : Repositories.ofPerson().all()) {
			message += "<th>" + person.name() + "</th>";
		}
		message += "<th>Total</th>";
		for (Category category : Repositories.ofCategory().all()) {
			message += "<tr>";
			message += "<td colspan='2'>" + category.name() + "</td>";
			for (Person person : Repositories.ofPerson().all()) {
				message += "<td>" + budget.totalDepenses(category, person) + "</td>";
			}
			message += "<td>" + budget.totalDepenses(category) + "</td>";
			message += "</tr>";
			for (SubCategory subCategory : category.subCategories()) {
				message += "<tr><td></td><td>" + subCategory.name() + "</td>";
				for (Person person : Repositories.ofPerson().all()) {
					message += "<td>" + budget.totalDepenses(subCategory, person) + "</td>";
				}
				message += "<td>" + budget.totalDepenses(subCategory) + "</td>";
				message += "</tr>";
			}
		}
		message += "<tr><td colspan='2'>Total</td>";
		for (Person person : Repositories.ofPerson().all()) {
			message += "<td>" + budget.totalDepenses(person) + "</td>";
		}
		message += "<td>" + budget.totalDepenses() + "</td></tr></table>";
		
		return new StringRepresentation(message, MediaType.TEXT_HTML);
	}
}
