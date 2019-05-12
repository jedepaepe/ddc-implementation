package ddc.entity;

import java.util.ArrayList;

/**
 * couche/Layer entité/entity (aussi appelé "domain", "business")
 * Liste des employées
 */
public class EmployeListe {
	/**
	 * instance globale de EmployeListe
	 * TODO : remplacer par le pattern singleton
	 */
	public static EmployeListe instance = new EmployeListe();
	
	/**
	 * liste des employé
	 */
    public ArrayList<Employe> employes = new ArrayList<>();

    /**
     * retourne l'employé de matricule donné
     * @param matricule
     * @return l'employé ou null si aucun employé n'a été trouvé
     */
    public Employe ofMatricule(String matricule) {
        // pour chaque Employe "e" de la liste employes
        for(Employe e : employes) {
            // si le matricule de l'employé == le matricule reçu en paramètre
            if(e.matricule.equals(matricule)) {
                return e;
            }
        }
        
        // si aucun employé n'a le matricule reçu en paramètre
        return null;
    }
    
    /**
     * remplit la liste employees avec des données de test
     * TODO : mettre cela dans un test unitaire
     * TODO : remplacer dans un DB ou l'Active Directory
     */
    public void initFake() {
    	// crée un manager et l'ajoute dans la liste des employés
        Manager patron = new Manager();
        patron.matricule = "A";
        employes.add(patron);
        
        // crée un employé avec un manager et l'ajoute dans la liste des employés
        Employe demandeur = new Employe();
        demandeur.matricule = "B";
        demandeur.manager = patron;
        employes.add(demandeur);
    }
}
