package fr.chezwams.budget.resource;

import java.util.HashMap;
import java.util.Map;

import org.restlet.data.MediaType;
import org.restlet.ext.freemarker.TemplateRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import fr.chezwams.budget.domain.Budget;
import fr.chezwams.budget.domain.repository.Repositories;
import freemarker.template.TemplateModelException;

public class BudgetResource extends ServerResource {
	
	@Get
	public Representation getByMonth() throws TemplateModelException {
		int month = Integer.parseInt((String) getRequest().getAttributes().get("month"));
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("budget", new Budget(month));
		root.put("categories", Repositories.ofCategory().all());
		root.put("persons", Repositories.ofPerson().all());
		return new TemplateRepresentation("budgets/get.ftl", Freemarker.configure(getContext()), root, MediaType.TEXT_HTML);
	}
}
