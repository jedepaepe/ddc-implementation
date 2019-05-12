package test.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ddc.entity.Conge;
import ddc.entity.Conge.CongeStatut;

class CongeTest {

	@Test
	void testHappyPath() throws Exception {
		Conge conge = new Conge();
		assertEquals(CongeStatut.DEMANDE, conge.statut);
		conge.approuve();
		assertEquals(CongeStatut.APPROUVE_MANAGER, conge.statut);
		conge.approuve();
		assertEquals(CongeStatut.APPROUVE_RH, conge.statut);
		conge.consomme();
		assertEquals(CongeStatut.CONSOMME, conge.statut);
	}
	
	@Test
	void testManagerRejette() throws Exception {
		Conge conge = new Conge();
		assertEquals(CongeStatut.DEMANDE, conge.statut);
		conge.rejette("manager-rejet");
		assertEquals(CongeStatut.REJETE_MANAGER, conge.statut);
		assertEquals("manager-rejet", conge.rejetRaison);
	}
	
	@Test
	void testRhRejette() throws Exception {
		Conge conge = new Conge();
		assertEquals(CongeStatut.DEMANDE, conge.statut);
		conge.approuve();
		assertEquals(CongeStatut.APPROUVE_MANAGER, conge.statut);
		conge.rejette("rh-rejette");
		assertEquals(CongeStatut.REJETE_RH, conge.statut);
		assertEquals("rh-rejette", conge.rejetRaison);
	}
	
	@Test
	void testEmployeAnnule() throws Exception {
		Conge conge = new Conge();
		assertEquals(CongeStatut.DEMANDE, conge.statut);
		conge.approuve();
		assertEquals(CongeStatut.APPROUVE_MANAGER, conge.statut);
		conge.approuve();
		assertEquals(CongeStatut.APPROUVE_RH, conge.statut);
		conge.annule();
		assertEquals(CongeStatut.ANNULLE, conge.statut);
	}

}
