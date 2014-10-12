package fr.chezwams.budget.resource;

import java.util.HashMap;
import java.util.Map;

import org.restlet.data.MediaType;
import org.restlet.ext.freemarker.TemplateRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import fr.chezwams.budget.domain.Repositories;
import freemarker.template.TemplateModelException;

public class BudgetResource extends ServerResource {
	
	@Get
	public Representation getByToday() throws TemplateModelException {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("budget", Repositories.ofBudget().getByToday());
		root.put("categories", Repositories.ofCategory().all());
		root.put("persons", Repositories.ofPerson().all());
		return new TemplateRepresentation("budgets/get.ftl", Freemarker.configure(getContext()), root, MediaType.TEXT_HTML);
	}
}
