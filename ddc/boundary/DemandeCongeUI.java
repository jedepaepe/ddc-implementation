package ddc.boundary;

import java.util.Scanner;

import ddc.boundary.helper.UIHelper;
import ddc.control.DemandeCongeCtrl;

/**
 * couche/layer boundary (Interface Utilisateur - aussi appelé "dialogue")
 * Page/Formulaire de demande de congé
 */
public class DemandeCongeUI {
	// référence sur la classe UIHelper (TODO => singleton)
	public UIHelper ui = new UIHelper();
	
	/**
	 * démarre l'interface utilisateur
	 * @param controller : référence vers le controller
	 */
    public void run(DemandeCongeCtrl controller) {
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
        controller.effectueDdc(matricule, debut);
    }
    
    /**
     * point d'entrée du programme (méthode de démarrage du programme)
     * uniquement pour test => TODO mettre dans un test
     * et ne joue que la demande effectuée par l'employé
     * note: cette méthode n'apparaît pas sur notre diagramme
     * @param args 
     */
    public static void main(String[] args) {
        // crée un objet du type 
    	DemandeCongeCtrl control = new DemandeCongeCtrl();
    	
    	// initie la liste des congés avec des fake data (pour tester)
        control.employeListe.initFake();

        // crée un objet du type DemandeCongeUI
        DemandeCongeUI boundary = new DemandeCongeUI();
        
        // affiche l'interface utilisateur
        boundary.run(control);
    }
}
