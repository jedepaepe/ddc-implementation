package test.boundary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ddc.boundary.ExceptionUI;
import ddc.router.Route;

class ExceptionUITest {

	@Test
	void testOverflow() {
		System.out.println("\n\n\n> dépassement d'un tableau\n");
		int[] tab = new int[2];
		try {
			int troisieme = tab[2];
		} catch(Exception ex) {
			Route route = new ExceptionUI().run(new Exception("test-exception"));
			assertEquals(Route.PRINCIPAL_PAGE, route.nom);
		}
	}
	
	@Test
	void testSimple() {
		System.out.println("\n\n\n> simple\n");
		Route route = new ExceptionUI().run(new Exception("test-exception"));
		assertEquals(Route.PRINCIPAL_PAGE, route.nom);
	}

}
