package br.com.matheus.behavioral.chainofresponsibility.dispenser;

import java.math.BigInteger;

import br.com.matheus.behavioral.chainofresponsibility.Receipt;

public class ATMDispenser {

	private DispenserChain firstDispenserOfChain;
	
	public ATMDispenser() {
		DispenserChain doisReaisDispenser = new DoisReaisDispenser();
		DispenserChain cincoReaisDispenser = new CincoReaisDispenser();
		DispenserChain dezReaisDispenser = new DezReaisDispenser();
		DispenserChain vinteReaisDispenser = new VinteReaisDispenser();
		DispenserChain cinquentaReaisDispenser = new CinquentaReaisDispenser();
		DispenserChain cemReaisDispenser = new CemReaisDispenser();
		DispenserChain duzentosReaisDispenser = new DuzentosReaisDispenser();
		cincoReaisDispenser.setNextInChain(doisReaisDispenser);
		dezReaisDispenser.setNextInChain(cincoReaisDispenser);
		vinteReaisDispenser.setNextInChain(dezReaisDispenser);
		cinquentaReaisDispenser.setNextInChain(vinteReaisDispenser);
		cemReaisDispenser.setNextInChain(cinquentaReaisDispenser);
		duzentosReaisDispenser.setNextInChain(cemReaisDispenser);
		this.firstDispenserOfChain = duzentosReaisDispenser;
	}
	
	public Receipt dispense(BigInteger value) throws DispenserException {
		if (value.longValue() < 2 || value.longValue() == 3)
			throw new DispenserException("Receipt value is not compatible.");
		Receipt receipt = new Receipt();
		firstDispenserOfChain.dispense(value, receipt);
		return receipt;
	}
}