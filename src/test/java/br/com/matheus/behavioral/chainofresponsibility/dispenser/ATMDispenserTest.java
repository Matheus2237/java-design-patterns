package br.com.matheus.behavioral.chainofresponsibility.dispenser;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.matheus.behavioral.chainofresponsibility.Receipt;

class ATMDispenserTest {

	private ATMDispenser dispenser;

	@BeforeEach
	void setUp() {
		this.dispenser = new ATMDispenser();
	}
	
	@Test
	void test() throws DispenserException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Receipt receipt = dispenser.dispense(BigInteger.TWO);
		Field reflectedBills = receipt.getClass().getDeclaredField("bills");
		reflectedBills.setAccessible(true);
		@SuppressWarnings("unchecked") Map<Integer, Long> bills = (Map<Integer, Long>) reflectedBills.get(receipt);
		Assertions.assertAll("Verificando se ao final da execução a receita tem todas as notas atribuidas",
				() -> Assertions.assertTrue(bills.containsKey(2)),
				() -> Assertions.assertTrue(bills.containsKey(5)),
				() -> Assertions.assertTrue(bills.containsKey(10)),
				() -> Assertions.assertTrue(bills.containsKey(20)),
				() -> Assertions.assertTrue(bills.containsKey(50)),
				() -> Assertions.assertTrue(bills.containsKey(100)),
				() -> Assertions.assertTrue(bills.containsKey(200)));
	}
	
	@Test
	void deveLancarExcecaoAoTentarRealizarOSaqueDeUmValorInteiroMenorQueDoisOuTres() {
		Assertions.assertAll("Teste de saque de valores inteiros menores que dois ou tres",
				() -> Assertions.assertThrows(DispenserException.class, () -> dispenser.dispense(BigInteger.ONE)),
				() -> Assertions.assertThrows(DispenserException.class, () -> dispenser.dispense(BigInteger.ZERO)),
				() -> Assertions.assertThrows(DispenserException.class, () -> dispenser.dispense(BigInteger.valueOf(-1))),
				() -> Assertions.assertThrows(DispenserException.class, () -> dispenser.dispense(BigInteger.valueOf(3))));
	}
}