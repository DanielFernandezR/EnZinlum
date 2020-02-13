package edu.elsmancs.enzinium.test;

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
	public void
}
