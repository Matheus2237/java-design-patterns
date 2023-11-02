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

class CincoReaisDispenserTest {

	@InjectMocks
	private CincoReaisDispenser cincoReaisDispenser;

	@Mock
	private DoisReaisDispenser doisReaisDispenserMock;
	
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
		cincoReaisDispenser.setNextInChain(doisReaisDispenserMock);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		this.mocks.close();
	}
	
	@Test
	void deveInserirAQuantidadeDeNotasDeCincoReaisASeremRecebidasNaReceita() {
		doNothing().when(receiptMock).receiveBills(anyInt(), anyLong());
		cincoReaisDispenser.dispense(BigInteger.valueOf(5), receiptMock);
		verify(receiptMock).receiveBills(integerCaptor.capture(), longCaptor.capture());
		assertEquals(5, integerCaptor.getValue().intValue());
		assertEquals(1, longCaptor.getValue().intValue());
	}
	
	@Test
	void deveInserirOValorZeroParaQuantidadeDeNotasDeCincoReaisASeremRecebidasNaReceitaQuandoOValorRecebidoForMenorQueQuatro() {
		doNothing().when(receiptMock).receiveBills(anyInt(), anyLong());
		cincoReaisDispenser.dispense(BigInteger.valueOf(4), receiptMock);
		verify(receiptMock).receiveBills(integerCaptor.capture(), longCaptor.capture());
		assertEquals(5, integerCaptor.getValue().intValue());
		assertEquals(0, longCaptor.getValue().intValue());
	}
	
	@Test
	void deveChamarOMetodoDispenseDoProximoObjetoNaCadeia() {
		doNothing().when(doisReaisDispenserMock).dispense(BigInteger.valueOf(0), receiptMock);
		cincoReaisDispenser.dispense(BigInteger.valueOf(5), receiptMock);
		verify(doisReaisDispenserMock).dispense(BigInteger.valueOf(5).remainder(BigInteger.valueOf(5)), receiptMock);
	}
}