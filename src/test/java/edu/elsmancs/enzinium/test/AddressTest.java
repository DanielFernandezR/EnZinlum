package edu.elsmancs.enzinium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.elsmancs.enzinium.Address;

public class AddressTest {

	Address prueba = new Address();

	@Test
	public void generateKeyPairTest() {
		prueba.generateKeyPair();
		System.out.println(prueba.toString());
	}

	@Test
	public void transferEZITest() {
		prueba.generateKeyPair();
		prueba.transferEZI(45d);
		double delta = 0.001;
		assertEquals(45, prueba.getBalance(), delta);
		System.out.println(prueba.toString());
	}
}
