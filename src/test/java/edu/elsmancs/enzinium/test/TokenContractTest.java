package edu.elsmancs.enzinium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.elsmancs.enzinium.Address;
import edu.elsmancs.enzinium.TokenContract;

public class TokenContractTest {

	private Address dani = null;
	private Address pepe = null;
	private Address manolo = null;
	private TokenContract prueba = null;

	@Before
	public void setupTokenContract() {
		dani = new Address();
		dani.generateKeyPair();
		pepe = new Address();
		pepe.generateKeyPair();
		manolo = new Address();
		manolo.generateKeyPair();

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

	@Test
	public void balanceOfTest() {
		double delta = 0.001;
		assertEquals(90, prueba.balanceOf(dani.getPK()), delta);
	}

	@Test
	public void balanceOfTestWithNoOwner() {
		double delta = 0.001;
		assertEquals(0, prueba.balanceOf(pepe.getPK()), delta);
	}

	@Test
	public void transferTest() {
		double delta = 0.001;
		prueba.transfer(pepe.getPK(), 5d);
		assertEquals(5, prueba.balanceOf(pepe.getPK()), delta);
		assertEquals(85, prueba.balanceOf(dani.getPK()), delta);
	}

	@Test
	public void transferTestFallaPorRequire() {
		pepe.generateKeyPair();
		double delta = 0.001;
		prueba.transfer(pepe.getPK(), 200d);
		assertEquals(0, prueba.balanceOf(pepe.getPK()), delta);
	}

	@Test
	public void transferTestCon3Argumentos() {
		double delta = 0.001;
		prueba.transfer(dani.getPK(), pepe.getPK(), 80d);
		assertEquals(80, prueba.balanceOf(pepe.getPK()), delta);
		assertEquals(10, prueba.balanceOf(dani.getPK()), delta);
	}

	@Test
	public void ownersAndTotalTokenSellTest() {
		double delta = 0.001;
		prueba.transfer(dani.getPK(), pepe.getPK(), 80d);
		prueba.transfer(dani.getPK(), manolo.getPK(), 5d);
		prueba.owners();
		assertEquals(85, prueba.totalTokensSold(), delta);
	}

}
