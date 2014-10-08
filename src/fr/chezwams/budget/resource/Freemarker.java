package fr.chezwams.budget.resource;

import org.restlet.Context;

import fr.chezwams.budget.StartServer;
import freemarker.cache.ClassTemplateLoader;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

public class Freemarker {

	public static Configuration configure(Context context) {
		Configuration configuration = new Configuration();
		ClassTemplateLoader loader = new ClassTemplateLoader(StartServer.class, "/fr/chezwams/budget/template/");
		configuration.setTemplateLoader(loader);
		configuration.setObjectWrapper(new DefaultObjectWrapper());
		configuration.setDefaultEncoding("UTF-8");
		return configuration;
	}

	public static TemplateModel staticOf(String klass) throws TemplateModelException {
		return BeansWrapper.getDefaultInstance().getStaticModels().get(klass);
	}
}
