package ddc.boundary;

import java.util.Scanner;

import ddc.boundary.helper.UIHelper;
import ddc.control.DemandeCongeCtrl;
import ddc.router.Route;
import ddc.router.Router;

/**
 * couche/layer boundary (Interface Utilisateur - aussi appelé "dialogue")
 * Page/Formulaire de demande de congé
 */
public class DemandeCongeUI extends IPageUI {	
	// référence sur le controller
	public DemandeCongeCtrl control = new DemandeCongeCtrl();
	
	/**
	 * démarre l'interface utilisateur
	 * @param controller : référence vers le controller
	 */
    public Route run(Object bag) {
    	// affiche le titre
    	ui.writeTitle("DEMANDE DE CONGE");

    	// affiche le formulaire 
        ui.writeFormHeader("Veullez entrer les données nécessaires à la demande");

        // demande d'encoder le matricule
        String matricule = ui.readInput("matricule");
        // TODO validation
        
        // demande d'encoder la date de début de congé
        String debut = ui.readInput("début");
        // TODO validation et conversion en LocalDate
        
        ui.writeFooter();
        
        // envoie la demande de congé au controller (instance de DemandeCongeCtrl)
        control.effectueDdc(matricule, debut);
        
        // TODO show the result
        
        // TODO manage user wants to change/return to principal/quit the application
        
        // return to principal page
        return new Route(Route.PRINCIPAL_PAGE);
    }
}
