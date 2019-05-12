package ddc.entity;

/**
 * couche/Layer entité/entity (aussi appelé "domain", "business")
 * Classe qui modélise un congé
 */
public class Conge {
	/**
	 * référence vers l'employé qui demande le congé
	 */
    public Employe demandeur;
    
    /**
     * date de début du congé
     * TODO => LocalDate
     */
    public String debut;
    
    // TODO ajouter les autres attributs (fin, raison, statut)
    // TODO encapsuler les attributs
    // TODO �crire les constructeurs
}
