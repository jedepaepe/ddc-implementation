package ddc.boundary;

import java.util.LinkedHashMap;
import java.util.Map;

import ddc.boundary.helper.UIHelper;
import ddc.router.Route;

public class PrincipalUI extends IPageUI {
	public UIHelper ui = UIHelper.instance;
	
	public Route run(Object bag) {
		Route newRoute;
		ui.writeTitle("HOME PAGE");
		ui.writeFormHeader("");
		// TODO change to SortedMap
		Map<String, String> multiChoix = new LinkedHashMap<String, String>();
		multiChoix.put(Route.LISTE_CONGE_PAGE, "Liste des congés");
		multiChoix.put(Route.DEMANDE_CONGE_PAGE, "Demander un congé");
		multiChoix.put(Route.QUIT_PAGE, "Quitter l'application");
		try {
			String choix = ui.readMultiChoix(
					"Choississez parmi les options suivantes", 
					multiChoix, 
					1);
			newRoute = new Route(choix);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			newRoute = new Route(Route.PRINCIPAL_PAGE, bag);
		}
		ui.writeFooter();
		return newRoute;
	}

}
