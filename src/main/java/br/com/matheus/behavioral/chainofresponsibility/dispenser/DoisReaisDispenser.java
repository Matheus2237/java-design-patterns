package br.com.matheus.behavioral.chainofresponsibility.dispenser;

import java.math.BigInteger;

import br.com.matheus.behavioral.chainofresponsibility.Receipt;
import br.com.matheus.util.ExcludeFromCodeCoverageAnalysisGenerated;

public class DoisReaisDispenser implements DispenserChain {

	@SuppressWarnings("unused")
	private DispenserChain nextInChain;

	@Override
	public void dispense(BigInteger value, Receipt receipt) {
		long quantityOfBills = value.divide(BigInteger.TWO).longValue();
		receipt.receiveBills(2, quantityOfBills);
	}

	@Override
	@ExcludeFromCodeCoverageAnalysisGenerated(reason = "There isn't a next dispenser after this one.")
	public void setNextInChain(DispenserChain next) {
		this.nextInChain = next;
	}
}