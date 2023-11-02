package br.com.matheus.behavioral.chainofresponsibility;

import java.math.BigInteger;

import br.com.matheus.behavioral.chainofresponsibility.dispenser.ATMDispenser;
import br.com.matheus.behavioral.chainofresponsibility.dispenser.DispenserException;
import br.com.matheus.util.ExcludeFromCodeCoverageAnalysisGenerated;

@ExcludeFromCodeCoverageAnalysisGenerated
public class Main {

	public static void main(String[] args) throws DispenserException {
		ATMDispenser dispenser = new ATMDispenser();
		Receipt receipt = dispenser.dispense(BigInteger.valueOf(387));
		receipt.informReceiptBills();
	}
}