package test.boundary;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import ddc.boundary.DemandeCongeUI;
import ddc.control.DemandeCongeCtrl;

class DemandeCongeUITest {

	@Test
	void testRun() {
        // crée un objet du type 
    	DemandeCongeCtrl control = new DemandeCongeCtrl();
    	
    	// initie la liste des congés avec des fake data (pour tester)
        control.employeListe.initFake();

        // crée un objet du type DemandeCongeUI
        DemandeCongeUI boundary = new DemandeCongeUI();
        
        // changer le scanner pour le test
        boundary.ui.scan = new Scanner("B\n2019-08-01");
        
        // affiche l'interface utilisateur
        boundary.run(control);
	}

}
