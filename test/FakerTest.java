package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ddc.entity.CongeListe;
import ddc.entity.EmployeListe;

class FakerTest {

	@Test
	void test() throws Exception {
		new Faker().reset();
		assertEquals(EmployeListe.instance.employes.size(), 2);
		assertEquals(CongeListe.instance.conges.size(), 2);
	}

}
