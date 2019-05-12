package ddc.boundary;

import java.util.LinkedHashMap;
import java.util.Map;

import ddc.control.DemandeCongeCtrl;
import ddc.entity.Conge;
import ddc.router.Route;

public class ApprouveCongeUI extends IPageUI {
	public DemandeCongeCtrl control = new DemandeCongeCtrl();

	@Override
	public Route run(Object bag) {
		ui.writeTitle("APPROBATION D'UN CONGE");
		int congeId = (Integer) bag;
		Conge conge = control.getDdc(congeId);
		ui.writeFormHeader("Détail du congé");
		ui.writeTextLeft("matricule : " + conge.demandeur.matricule);
		ui.writeTextLeft("début     : " + conge.debut);
		Map<String, String> multiChoix = new LinkedHashMap<String, String>();;
		multiChoix.put("A", "Approuve");
		multiChoix.put("R", "Rejette");
		try {
			String choix = ui.readMultiChoix("Choissisez entre", multiChoix, 1);
			String raison = null;
			if(choix.equals("A")) {
				control.approuveDdc(congeId);
			} else {
				raison = ui.readInput("Raison du rejet");
				control.refuseDdc(congeId, raison);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new Route(Route.LISTE_CONGE_PAGE);
	}

}
