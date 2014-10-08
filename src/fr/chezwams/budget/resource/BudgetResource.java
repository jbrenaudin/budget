package fr.chezwams.budget.resource;

import java.util.HashMap;
import java.util.Map;

import org.restlet.data.MediaType;
import org.restlet.ext.freemarker.TemplateRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import fr.chezwams.budget.domain.Budget;
import fr.chezwams.budget.domain.Repositories;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModelException;

public class BudgetResource extends ServerResource {
	
	@Get
	public Representation getByToday() throws TemplateModelException {
		Budget budget = Repositories.ofBudget().getByToday();
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("budget", budget);
		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
		TemplateHashModel repositories = (TemplateHashModel) wrapper.getStaticModels().get("fr.chezwams.budget.domain.Repositories");
		root.put("budget", budget);
		root.put("repositories", repositories);
		return new TemplateRepresentation("budget.ftl", Freemarker.configure(getContext()), root, MediaType.TEXT_HTML);
	}
}
