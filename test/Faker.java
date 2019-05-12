package test;

import java.util.List;

import ddc.entity.Conge;
import ddc.entity.CongeListe;
import ddc.entity.Employe;
import ddc.entity.EmployeListe;
import ddc.entity.Manager;

public class Faker {
	
	public void reset() throws Exception {
		clean();
		init();
	}
	
	public void clean() {
		CongeListe.instance.conges.clear();
		EmployeListe.instance.employes.clear();
	}

	public void init() throws Exception {
		initEmployes();
		try {
			initConges();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    /**
     * remplit la liste employees avec des données de test
     * TODO : mettre cela dans un test unitaire
     * TODO : remplacer dans un DB ou l'Active Directory
     * @throws Exception 
     */
    public void initEmployes() throws Exception {
    	List<Employe> employes = EmployeListe.instance.employes;
    	if(employes.size() != 0) throw new Exception("Liste des employés n'est pas vide");
    	
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
    
    public void initConges() throws Exception {
    	List<Employe> employes = EmployeListe.instance.employes;
    	if(employes.size() == 0) throw new Exception("Doit avoir des employés");
    	
    	List<Conge> conges = CongeListe.instance.conges;
    	if(conges.size() != 0) throw new Exception("Liste des congés n'est pas vide");
    	conges.add(new Conge(employes.get(1), "2019-06-01"));
    	conges.add(new Conge(employes.get(1), "2019-07-15"));
    }

}
