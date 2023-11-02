package br.com.matheus.behavioral.chainofresponsibility.dispenser;

import java.math.BigInteger;

import br.com.matheus.behavioral.chainofresponsibility.Receipt;

public class DezReaisDispenser implements DispenserChain {

	private DispenserChain nextInChain;

	@Override
	public void dispense(BigInteger value, Receipt receipt) {
		long quantityOfBills = value.divide(BigInteger.valueOf(10)).longValue();
		receipt.receiveBills(10, quantityOfBills);
		nextInChain.dispense(value.remainder(BigInteger.valueOf(10)), receipt);
	}
	
	@Override
	public void setNextInChain(DispenserChain next) {
		this.nextInChain = next;
	}
}