package edu.elsmancs.enzinium;

import java.security.KeyPair;

public class Address {

	private int PK = 0;
	private int SK = 0;
	private Double balance = 0.d;
	private final String symbol = "EZI";

	public Address() {
	}

	private int getPK() {
		return this.PK;
	}

	private void setPK(int PK) {
		this.PK = PK;
	}

	private int getSK() {
		return this.SK;
	}

	private void setSK(int SK) {
		this.SK = SK;
	}

	private Double getBalance() {
		return this.balance;
	}

	private String getSymbol() {
		return this.symbol;
	}

	@Override
	public String toString() {
		return ("\n" + "PK = " + getPK() + "\n" + "Balance = " + getBalance() + " " + getSymbol());
	}

	public void generateKeyPair() {
		KeyPair pair = GenSig.generateKeyPair();
		this.setPK(pair.getPublic().hashCode());
		this.setSK(pair.getPrivate().hashCode());
	}
}
