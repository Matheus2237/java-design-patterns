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

class VinteReaisDispenserTest {

	@InjectMocks
	private VinteReaisDispenser vinteReaisDispenser;

	@Mock
	private DezReaisDispenser dezReaisDispenser;
	
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
		vinteReaisDispenser.setNextInChain(dezReaisDispenser);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		this.mocks.close();
	}
	
	@Test
	void deveInserirAQuantidadeDeNotasDeVinteReaisASeremRecebidasNaReceita() {
		doNothing().when(receiptMock).receiveBills(anyInt(), anyLong());
		vinteReaisDispenser.dispense(BigInteger.valueOf(20), receiptMock);
		verify(receiptMock).receiveBills(integerCaptor.capture(), longCaptor.capture());
		assertEquals(20, integerCaptor.getValue().intValue());
		assertEquals(1, longCaptor.getValue().intValue());
	}
	
	@Test
	void deveInserirOValorZeroParaQuantidadeDeNotasDeVinteReaisASeremRecebidasNaReceitaQuandoOValorRecebidoForMenorQueDezenove() {
		doNothing().when(receiptMock).receiveBills(anyInt(), anyLong());
		vinteReaisDispenser.dispense(BigInteger.valueOf(19), receiptMock);
		verify(receiptMock).receiveBills(integerCaptor.capture(), longCaptor.capture());
		assertEquals(20, integerCaptor.getValue().intValue());
		assertEquals(0, longCaptor.getValue().intValue());
	}
	
	@Test
	void deveChamarOMetodoDispenseDoProximoObjetoNaCadeia() {
		doNothing().when(dezReaisDispenser).dispense(BigInteger.valueOf(0), receiptMock);
		vinteReaisDispenser.dispense(BigInteger.valueOf(20), receiptMock);
		verify(dezReaisDispenser).dispense(BigInteger.valueOf(20).remainder(BigInteger.valueOf(20)), receiptMock);
	}
}
