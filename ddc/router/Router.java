package ddc.router;

import java.util.HashMap;
import java.util.Map;

import ddc.boundary.ApprouveCongeUI;
import ddc.boundary.DemandeCongeUI;
import ddc.boundary.ExceptionUI;
import ddc.boundary.IPageUI;
import ddc.boundary.ListeCongeUI;
import ddc.boundary.PrincipalUI;
import ddc.boundary.QuitUI;

public class Router {
	public Map<String, IPageUI> routesMap  = new HashMap<String, IPageUI>();

	public Route startRoute = new Route(Route.PRINCIPAL_PAGE);

	public Router() {
		routesMap.put(Route.APPROBATION_CONGE_PAGE, new ApprouveCongeUI());
		routesMap.put(Route.DEMANDE_CONGE_PAGE, new DemandeCongeUI());
		routesMap.put(Route.EXCEPTION_PAGE, new ExceptionUI());
		routesMap.put(Route.LISTE_CONGE_PAGE, new ListeCongeUI());
		routesMap.put(Route.PRINCIPAL_PAGE, new PrincipalUI());
		routesMap.put(Route.QUIT_PAGE, new QuitUI());
	}
	
	public void run() {
		Route route = startRoute;
		while(route != null && route.nom != null) {
			/*debug*/ System.out.println("\n\n>>>>>>>> " + route.nom + "\n\n");
			try {
				IPageUI boundary = routesMap.get(route.nom);
				if(boundary == null) throw new Exception("Page non trouvée");
				route = boundary.run(route.bag);
			} catch(Exception ex) {
				route = new Route(Route.EXCEPTION_PAGE, ex);
			}
		}
	}
}