package edu.elsmancs.enzinium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.elsmancs.enzinium.Address;
import edu.elsmancs.enzinium.TokenContract;

public class TokenContractTest {

	private Address dani = null;
	private TokenContract prueba = null;

	@Before
	public void setupTokenContract() {
		dani = new Address();
		dani.generateKeyPair();
		prueba = new TokenContract(dani);
		prueba.setTotalSupply(90);
		prueba.addOwner(dani.getPK(), prueba.totalSupply());
		prueba.setName("Mis entradillas");
		prueba.setSymbol("POG");
		assertEquals(1, prueba.numOwners());
	}

	@Test
	public void toStringTest() {
		System.out.println(prueba.toString());
	}
}
