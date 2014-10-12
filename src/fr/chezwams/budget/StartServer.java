package fr.chezwams.budget;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;

import fr.chezwams.budget.resource.BudgetResource;
import fr.chezwams.budget.resource.DepenseResource;

public class StartServer extends Application {

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		router.attach("/css", directoryOf("clap://class/fr/chezwams/budget/web/css/"));
		router.attach("/img", directoryOf("clap://class/fr/chezwams/budget/web/img/"));
		router.attach("/fonts", directoryOf("clap://class/fr/chezwams/budget/web/fonts/"));
		router.attach("/js", directoryOf("clap://class/fr/chezwams/budget/web/js/"));
		router.attach("/budgets/{month}", BudgetResource.class);
		router.attach("/depenses/{month}", DepenseResource.class);
		return router;
	}

	private Directory directoryOf(String path) {
		Directory directory = new Directory(getContext(), path);
		directory.setDeeplyAccessible(true);
		return directory;
	}

	public static void main(String[] args) throws Exception {
		Component component = new Component();
		component.getClients().add(Protocol.CLAP);
		component.getServers().add(Protocol.HTTP, 8080);
		component.getDefaultHost().attach(new StartServer());
		component.start();
	}
}
