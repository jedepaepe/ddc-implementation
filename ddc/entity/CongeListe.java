package ddc.entity;

import java.util.ArrayList;

/**
 * couche/Layer entité/entity (aussi appelé "domain", "business")
 * Classe qui modélise la liste des congés
 */
public class CongeListe {
	/**
	 * liste des congés
	 * TODO : encapsuler
	 */
    public ArrayList<Conge> conges = new ArrayList<>();

    /**
     * méthode pour créer un nouveau congé et l'ajoute dans la liste des congés
     * @param demandeur
     * @param debut 
     */
    public Conge create(Employe demandeur, String debut) {
        // créer le nouveau congé (TODO : utiliser un constructeur)
        Conge conge = new Conge();
        conge.demandeur = demandeur;
        conge.debut = debut;
        
        // ajoute le congé dans la liste
        conges.add(conge);
        
        // retourne la référence du congé
        return conge;
    }
}
