package br.com.matheus.behavioral.chainofresponsibility.dispenser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.math.BigInteger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.matheus.behavioral.chainofresponsibility.Receipt;

class CemReaisDispenserTest {

	@InjectMocks
	private CemReaisDispenser cemReaisDispenser;

	@Mock
	private CinquentaReaisDispenser cinquentaReaisDispenser;
	
	@Mock
	private Receipt receiptMock;

	@Captor
	private ArgumentCaptor<Long> longCaptor;
	
	@Captor
	private ArgumentCaptor<Integer> integerCaptor;
	
	private AutoCloseable mocks;
	
	@BeforeEach
	void setUp() {
		this.mocks = MockitoAnnotations.openMocks(this);
		cemReaisDispenser.setNextInChain(cinquentaReaisDispenser);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		this.mocks.close();
	}
	
	@Test
	void deveInserirAQuantidadeDeNotasDeCemReaisASeremRecebidasNaReceita() {
		doNothing().when(receiptMock).receiveBills(anyInt(), anyLong());
		cemReaisDispenser.dispense(BigInteger.valueOf(100), receiptMock);
		verify(receiptMock).receiveBills(integerCaptor.capture(), longCaptor.capture());
		assertEquals(100, integerCaptor.getValue().intValue());
		assertEquals(1, longCaptor.getValue().intValue());
	}
	
	@Test
	void deveInserirOValorZeroParaQuantidadeDeNotasDeCemReaisASeremRecebidasNaReceitaQuandoOValorRecebidoForMenorQueNoventaENove() {
		doNothing().when(receiptMock).receiveBills(anyInt(), anyLong());
		cemReaisDispenser.dispense(BigInteger.valueOf(99), receiptMock);
		verify(receiptMock).receiveBills(integerCaptor.capture(), longCaptor.capture());
		assertEquals(100, integerCaptor.getValue().intValue());
		assertEquals(0, longCaptor.getValue().intValue());
	}
	
	@Test
	void deveChamarOMetodoDispenseDoProximoObjetoNaCadeia() {
		doNothing().when(cinquentaReaisDispenser).dispense(BigInteger.valueOf(0), receiptMock);
		cemReaisDispenser.dispense(BigInteger.valueOf(100), receiptMock);
		verify(cinquentaReaisDispenser).dispense(BigInteger.valueOf(100).remainder(BigInteger.valueOf(100)), receiptMock);
	}
}
