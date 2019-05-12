package ddc.control;

import ddc.entity.Conge;
import ddc.entity.CongeListe;
import ddc.entity.Employe;
import ddc.entity.EmployeListe;

/**
 * couche/layer Control (aussi appelé Controller)
 * Responsable de l'orchestration de la demande de congé
 */
public class DemandeCongeCtrl {
	/**
	 * liste des employés
	 */
    public EmployeListe employeListe = EmployeListe.instance;
    
    /**
     * liste des congés
     */
    public CongeListe congeListe = CongeListe.instance;
    
    // TODO : encapsuler les attributs
    // TODO : implémenter les constructeurs
    
    /**
     * crée une nouvelle demande de congé
     * @param matricule : matricule du demandeur
     * @param debut : date de début de congé (TODO: String => LocalDate)
     * TODO : gestion des erreurs
     * 		.) demandeur est null (pas d'employé avec le matricule)
     *		.) demandeur.manager est null (l'employé n'a pas de manager)
     */
    public void effectueDdc(String matricule, String debut) {
        // trouver le demandeur dans la liste des employés
        Employe demandeur = employeListe.ofMatricule(matricule);
        
        // ajoute le congé dans la liste des congés
        Conge conge = congeListe.create(demandeur, debut);
        
        // TODO => nouvelle classe boundary par exemple NotifieBoundary
        // notifie le manager
        // TODO vérifier que le demandeur a un manager
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(">>> Notification au manager");
        System.out.println(">>>    envoyé à: " + demandeur.manager.matricule);
        System.out.println(">>>    message:");
        System.out.println(">>>       Veuillez vérifier la demande de congé:");
        System.out.println(">>>           demandeur: " + demandeur.matricule);
        System.out.println(">>>           début:     " + conge.debut);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();
        
        // notifie le manager
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(">>> Notification au demandeur");
        System.out.println(">>>    envoyé à: " + demandeur.matricule);
        System.out.println(">>>    message:");
        System.out.println(">>>       Votre demande de congé:");
        System.out.println(">>>           demandeur: " + demandeur.matricule);
        System.out.println(">>>           début:     " + conge.debut);
        System.out.println(">>>       a été envoyée à votre manager " + demandeur.manager.matricule);
        System.out.println(">>>       pour approbation");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();
    }
    
    public Conge getDdc(int id) {
    	return congeListe.ofId(id);
    }

	public void approuveDdc(int index) throws Exception {
		congeListe.approuve(index);
	}
	
	public void refuseDdc(int index, String raison) throws Exception {
		congeListe.refuse(index, raison);
	}
}
