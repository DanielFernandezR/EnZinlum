package edu.elsmancs.enzinium;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Address {

	private PublicKey PK = null;
	private PrivateKey SK = null;
	private Double balance = 0.d;
	private final String symbol = "EZI";

	public Address() {
	}

	public PublicKey getPK() {
		return this.PK;
	}

	public void setPK(PublicKey PK) {
		this.PK = PK;
	}

	public PrivateKey getSK() {
		return this.SK;
	}

	public void setSK(PrivateKey SK) {
		this.SK = SK;
	}

	public Double getBalance() {
		return this.balance;
	}

	public String getSymbol() {
		return this.symbol;
	}

	@Override
	public String toString() {
		return ("\n" + "PK = " + getPK().hashCode() + "\n" + "Balance = " + getBalance() + " " + getSymbol());
	}

	public void generateKeyPair() {
		KeyPair pair = GenSig.generateKeyPair();
		this.setPK(pair.getPublic());
		this.setSK(pair.getPrivate());
	}

	public void transferEZI(double EZI) {
		this.balance = balance + EZI;
	}

	public void send(TokenContract contract, double EZI) {
		if (EZI <= this.balance) {
			contract.payable(getPK(), EZI);
			this.balance -= EZI;
		}
	}
}
