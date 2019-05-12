package ddc;

import java.util.Scanner;

/**
 * couche/layer boundary (Interface Utilisateur - aussi appelé "dialogue")
 * Page/Formulaire de demande de congé
 */
public class DemandeCongeUI {
	
	/**
	 * démarre l'interface utilisateur
	 * @param controller : référence vers le controller
	 */
    public void run(DemandeCongeCtrl controller) {
    	// affiche l'entête de la page
        Scanner scan = new Scanner(System.in);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+");
        System.out.println("++++++++++++ DEMANDE DE CONGE ++++++++++++++++++++++++");
        System.out.println("+");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        
        // affiche le formulaire 
        System.out.println("+");
        System.out.println("+   Veullez entrer les données nécessaires à la demande");

        // demande d'encoder le matricule
        System.out.print("+   matricule: ");
        String matricule = scan.nextLine();
        // TODO validation
        
        // demande d'encoder la date de déut de congé
        System.out.print("+   début: ");
        String debut = scan.nextLine();
        // TODO validation et conversion en LocalDate
        
        System.out.println("+");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        
        // envoie la demande de congé au controller (instance de DemandeCongeCtrl)
        controller.demandeConge(matricule, debut);
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
