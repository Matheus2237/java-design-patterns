package br.com.matheus.behavioral.chainofresponsibility.dispenser;

import java.math.BigInteger;

import br.com.matheus.behavioral.chainofresponsibility.Receipt;

public class DuzentosReaisDispenser implements DispenserChain {

	private DispenserChain nextInChain;

	@Override
	public void dispense(BigInteger value, Receipt receipt) {
		long quantityOfBills = value.divide(BigInteger.valueOf(200)).longValue();
		receipt.receiveBills(200, quantityOfBills);
		nextInChain.dispense(value.remainder(BigInteger.valueOf(200)), receipt);
	}
	
	@Override
	public void setNextInChain(DispenserChain next) {
		this.nextInChain = next;
	}
}