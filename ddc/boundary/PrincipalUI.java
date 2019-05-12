package ddc.boundary;

import java.util.HashMap;
import java.util.Map;

import ddc.boundary.helper.UIHelper;

public class PrincipalUI {
	public UIHelper ui = new UIHelper();
	
	public void run() throws Exception {
		ui.writeTitle("HOME PAGE");
		ui.writeFormHeader("");
		Map<String, String> multiChoix = new HashMap<String, String>();
		multiChoix.put("D", "Demander un congé");
		multiChoix.put("Q", "Quitter l'application");
		String option = ui.readMultiChoix("Choississez parmi les options suivantes", multiChoix, 1);
		
	}

}
