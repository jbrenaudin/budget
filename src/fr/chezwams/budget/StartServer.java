package fr.chezwams.budget;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

import fr.chezwams.budget.resource.BudgetResource;

public class StartServer extends Application {

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		router.attach("/budgets", BudgetResource.class);
		return router;
	}

	public static void main(String[] args) throws Exception {
		Component component = new Component();
		component.getServers().add(Protocol.HTTP, 8182);
		component.getDefaultHost().attach(new StartServer());
		component.start();
	}
}
