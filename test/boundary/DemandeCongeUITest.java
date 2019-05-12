package test.boundary;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import ddc.boundary.DemandeCongeUI;
import ddc.router.Route;

public class DemandeCongeUITest {

	@Test
	public void testRun() {

        // crée un objet du type DemandeCongeUI
        DemandeCongeUI boundary = new DemandeCongeUI();

        // changer le scanner pour le test
        boundary.ui.scan = new Scanner("B\n2019-08-01");

        // initie la liste des congés avec des fake data (pour tester)
        boundary.control.employeListe.initFake();
        
        // affiche l'interface utilisateur
        String actual = boundary.run(null).nom;
        
        assertEquals(Route.PRINCIPAL_PAGE, actual);
	}

}
