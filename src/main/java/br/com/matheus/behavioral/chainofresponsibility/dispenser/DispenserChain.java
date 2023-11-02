package br.com.matheus.behavioral.chainofresponsibility.dispenser;

import java.math.BigInteger;

import br.com.matheus.behavioral.chainofresponsibility.Receipt;

public interface DispenserChain {

	void setNextInChain(DispenserChain next);

	void dispense(BigInteger value, Receipt receipt);
}