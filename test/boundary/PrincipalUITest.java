package test.boundary;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import ddc.boundary.PrincipalUI;
import ddc.router.Route;

public class PrincipalUITest {

	@Test
	public void test() {
		PrincipalUI boundary = new PrincipalUI();
		String expected = Route.DEMANDE_CONGE_PAGE;
		boundary.ui.scan = new Scanner(expected);
		String actual = boundary.run(null).nom;
		assertEquals(expected, actual);
	}
}
