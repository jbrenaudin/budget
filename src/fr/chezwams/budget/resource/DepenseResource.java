package fr.chezwams.budget.resource;

import java.util.HashMap;
import java.util.Map;

import org.restlet.data.MediaType;
import org.restlet.ext.freemarker.TemplateRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import fr.chezwams.budget.domain.repository.Repositories;
import freemarker.template.TemplateModelException;

public class DepenseResource extends ServerResource {

	@Get
	public Representation getByMonth() throws TemplateModelException {
		int year = Integer.parseInt(getAttribute("year"));
		int month = Integer.parseInt(getAttribute("month"));
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("depenses", Repositories.ofDepense().getByMonth(month, year));
		return new TemplateRepresentation("depenses/list.ftl", Freemarker.configure(getContext()), root, MediaType.TEXT_HTML);
	}
}
