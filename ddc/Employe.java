package ddc;

/**
 * couche/Layer entité/entity (aussi appelé "domain", "business")
 * Modèle pour l'employé
 */
public class Employe {
	/**
	 * matricule de l'employé
	 * Le matricule identifie l'employé au sein de l'entreprise
	 */
    public String matricule;
    
    /**
     * référence vers le manager
     * cette référence est nulle si l'employé n'a pas de manager
     */
    public Manager manager;
    
    // TODO ajouter les autres attributs
    // TODO encapsuler les attributs
    // TODO écrire les constructeurs
}
