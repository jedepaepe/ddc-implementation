package ddc.entity;

import java.util.ArrayList;

/**
 * couche/Layer entité/entity (aussi appelé "domain", "business")
 * Classe qui modélise la liste des congés
 */
public class CongeListe {
	/**
	 * crée un instance globale de la liste
	 * TODO: remplacer par le pattern singleton
	 */
	public static CongeListe instance = new CongeListe();
		
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

	public Conge ofId(int index) {
		return conges.get(index);
	}

	public void approuve(int index) throws Exception {
		Conge conge = ofId(index);
		conge.approuve();
		
	}

	public void refuse(int index, String raison) throws Exception {
		Conge conge = ofId(index);
		conge.rejette(raison);
		
	}
}
