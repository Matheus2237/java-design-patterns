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

class DuzentosReaisDispenserTest {

	@InjectMocks
	private DuzentosReaisDispenser duzentosReaisDispenser;

	@Mock
	private CemReaisDispenser cemReaisDispenser;
	
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
		duzentosReaisDispenser.setNextInChain(cemReaisDispenser);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		this.mocks.close();
	}
	
	@Test
	void deveInserirAQuantidadeDeNotasDeDuzentosReaisASeremRecebidasNaReceita() {
		doNothing().when(receiptMock).receiveBills(anyInt(), anyLong());
		duzentosReaisDispenser.dispense(BigInteger.valueOf(200), receiptMock);
		verify(receiptMock).receiveBills(integerCaptor.capture(), longCaptor.capture());
		assertEquals(200, integerCaptor.getValue().intValue());
		assertEquals(1, longCaptor.getValue().intValue());
	}
	
	@Test
	void deveInserirOValorZeroParaQuantidadeDeNotasDeDuzentosReaisASeremRecebidasNaReceitaQuandoOValorRecebidoForMenorQueCentoENoventaENove() {
		doNothing().when(receiptMock).receiveBills(anyInt(), anyLong());
		duzentosReaisDispenser.dispense(BigInteger.valueOf(199), receiptMock);
		verify(receiptMock).receiveBills(integerCaptor.capture(), longCaptor.capture());
		assertEquals(200, integerCaptor.getValue().intValue());
		assertEquals(0, longCaptor.getValue().intValue());
	}
	
	@Test
	void deveChamarOMetodoDispenseDoProximoObjetoNaCadeia() {
		doNothing().when(cemReaisDispenser).dispense(BigInteger.valueOf(0), receiptMock);
		duzentosReaisDispenser.dispense(BigInteger.valueOf(200), receiptMock);
		verify(cemReaisDispenser).dispense(BigInteger.valueOf(200).remainder(BigInteger.valueOf(200)), receiptMock);
	}
}