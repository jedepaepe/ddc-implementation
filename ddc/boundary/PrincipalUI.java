package ddc.boundary;

import java.util.LinkedHashMap;
import java.util.Map;

import ddc.boundary.helper.UIHelper;
import ddc.router.Route;

public class PrincipalUI extends IPageUI {
	public UIHelper ui = UIHelper.instance;
	
	public Route run(Object bag) {
		ui.writeTitle("HOME PAGE");
		ui.writeFormHeader("");
		// TODO change to SortedMap
		Map<String, String> multiChoix = new LinkedHashMap<String, String>();
		multiChoix.put("D", "Demander un congé");
		multiChoix.put("Q", "Quitter l'application");
		try {
			String choix = ui.readMultiChoix(
					"Choississez parmi les options suivantes", 
					multiChoix, 
					1);
			return new Route(choix);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Route();
		
	}

}
