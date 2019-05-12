package test.boundary;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import ddc.boundary.ApprouveCongeUI;
import ddc.entity.Conge;
import ddc.entity.Conge.CongeStatut;
import ddc.entity.CongeListe;
import ddc.router.Route;
import test.Faker;

class ApprouveCongeUITest {

	@Test
	void testApprobation() throws Exception {
		System.out.println("\n\n\ntest de l'approbation d'un congé\n");
		new Faker().reset();
		ApprouveCongeUI boundary = new ApprouveCongeUI();
		boundary.ui.scan = new Scanner("A");
		String actual = boundary.run(1).nom;
		assertEquals(Route.LISTE_CONGE_PAGE, actual);
		Conge conge = CongeListe.instance.ofId(1);
		assertEquals(CongeStatut.APPROUVE_MANAGER, conge.statut);
	}

	@Test
	void testRejet() throws Exception {
		System.out.println("\n\n\ntest du rejet d'un congé\n");
		new Faker().reset();
		ApprouveCongeUI boundary = new ApprouveCongeUI();
		boundary.ui.scan = new Scanner("R\nTrop de travail");
		String actual = boundary.run(1).nom;
		assertEquals(Route.LISTE_CONGE_PAGE, actual);
		Conge conge = CongeListe.instance.ofId(1);
		assertEquals(CongeStatut.REJETE_MANAGER, conge.statut);		
		assertEquals("Trop de travail", conge.rejetRaison);
	}

}
