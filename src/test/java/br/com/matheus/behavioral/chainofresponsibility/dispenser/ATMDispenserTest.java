package br.com.matheus.behavioral.chainofresponsibility.dispenser;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.Map;

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
		assertAll("Verificando se ao final da execução a receita tem todas as notas atribuidas",
				() -> assertTrue(bills.containsKey(2)),
				() -> assertTrue(bills.containsKey(5)),
				() -> assertTrue(bills.containsKey(10)),
				() -> assertTrue(bills.containsKey(20)),
				() -> assertTrue(bills.containsKey(50)),
				() -> assertTrue(bills.containsKey(100)),
				() -> assertTrue(bills.containsKey(200)));
	}
	
	@Test
	void deveLancarExcecaoAoTentarRealizarOSaqueDeUmValorInteiroMenorQueDoisOuTres() {
		assertAll("Teste de saque de valores inteiros menores que dois ou tres",
				() -> assertThrows(DispenserException.class, () -> dispenser.dispense(BigInteger.ONE)),
				() -> assertThrows(DispenserException.class, () -> dispenser.dispense(BigInteger.ZERO)),
				() -> assertThrows(DispenserException.class, () -> dispenser.dispense(BigInteger.valueOf(-1))),
				() -> assertThrows(DispenserException.class, () -> dispenser.dispense(BigInteger.valueOf(3))));
	}
}