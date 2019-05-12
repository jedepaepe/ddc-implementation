package test.boundary;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import ddc.boundary.ListeCongeUI;
import test.Faker;

class ListeCongeUITest {

	@Test
	void test() throws Exception {
		String expected = "1";
		Faker faker = new Faker();
		faker.clean();
		faker.init();
		ListeCongeUI boundary = new ListeCongeUI();
		boundary.ui.scan = new Scanner(expected);
		String actual = boundary.run(null).nom;
		assertEquals(expected, actual);
	}
}
