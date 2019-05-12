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
    
    /**
     * statut du congé
     */
    public CongeStatut statut = CongeStatut.DEMANDE;

    /**
     * raison du rejet du congé
     */
    public String rejetRaison;
    
	/**
	 * 
	 */
	public Conge() {
		super();
	}

	/**
	 * @param demandeur
	 * @param debut
	 */
	public Conge(Employe demandeur, String debut) {
		super();
		this.demandeur = demandeur;
		this.debut = debut;
	}
    
    // TODO ajouter les autres attributs (fin, raison, statut)
    // TODO encapsuler les attributs

	public void approuve() throws Exception {
		CongeStatut initial = statut;
		if(initial == CongeStatut.DEMANDE) {
			statut = CongeStatut.APPROUVE_MANAGER;
		} else if(initial == CongeStatut.APPROUVE_MANAGER) {
			statut = CongeStatut.APPROUVE_RH;
		} else {
			throw new Exception("Impossible d'approuver un congé dans l'état " + statut.toString());
		}
	}
	
	public void rejette(String raison) throws Exception {
		CongeStatut initial = statut;
		if(initial == CongeStatut.DEMANDE) {
			statut = CongeStatut.REJETE_MANAGER;
			rejetRaison = raison;
		} else if(initial == CongeStatut.APPROUVE_MANAGER) {
			statut = CongeStatut.REJETE_RH;
			rejetRaison = raison;
		} else {
			throw new Exception("Impossible de rejeter un congé dans l'état " + statut.toString());			
		}
	}

	public void annule() throws Exception {
		CongeStatut initial = statut;
		if(initial == CongeStatut.DEMANDE || initial == CongeStatut.APPROUVE_MANAGER || initial == CongeStatut.APPROUVE_RH) {
			statut = CongeStatut.ANNULLE;
		} else {
			throw new Exception("Impossible d'annuler un congé dans l'état " + statut.toString());			
		}
	}
	
	public void consomme() throws Exception {
		CongeStatut initial = statut;
		if(initial == CongeStatut.APPROUVE_RH) {
			statut = CongeStatut.CONSOMME;
		} else {
			throw new Exception("Impossible de consommé un congé dans l'état " + statut.toString());			
		}
	}

	public enum CongeStatut {
		DEMANDE,
		APPROUVE_MANAGER,
		APPROUVE_RH,
		CONSOMME,
		REJETE_MANAGER,
		REJETE_RH,
		ANNULLE
	}
    
}
