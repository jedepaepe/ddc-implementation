package ddc.boundary;

import java.util.List;

import ddc.control.DemandeCongeCtrl;
import ddc.entity.Conge;
import ddc.router.Route;
import ddc.router.Router;

public class ListeCongeUI extends IPageUI {

	DemandeCongeCtrl control = new DemandeCongeCtrl();

	@Override
	public Route run(Object bag) {
		List<Conge> conges = control.congeListe.conges;
		ui.writeTitle("LISTE DES CONGEs");
		ui.writeBR(1);
		if (conges.size() > 0) {
			for (int i = 0; i < conges.size(); ++i) {
				Conge conge = conges.get(i);
				ui.writeTextLeft("" + i + " - " + conge.demandeur.matricule + " - " + conge.debut);
			}
			ui.writeFooter();
			String choix = ui.readInput("Tapez un index entre 0 et " + (conges.size() - 1) + "ou P");
			try {
				Integer nr = Integer.parseInt(choix);
				return new Route(choix);
			} catch (Exception e) {
				// TODO manage error in the command
				return new Route(Route.PRINCIPAL_PAGE);
			}
		} else {
			ui.writeFormHeader("pas de congés dans la liste");
		}
		return new Route(Route.PRINCIPAL_PAGE);
	}

}
