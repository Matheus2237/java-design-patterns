package br.com.matheus.behavioral.strategy.pagamento;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.matheus.behavioral.strategy.pagamento.estrategias.PagamentoStrategy;

class ProcessadorDePagamentoTest {

	@Mock
	private BigDecimal bigDecimalMock;

	@Mock
	private PagamentoStrategy pagamentoStrategyMock;
	
	private AutoCloseable mocks; 
	
	@BeforeEach
	void setUp() { this.mocks = MockitoAnnotations.openMocks(this); }
	
	@AfterEach
	void tearDown() throws Exception { this.mocks.close(); }
	
	@Test
	void deveExecutarUmaChamadaParaOMetodoProcessarDaPagamentoStrategyAoChamarOMetodoProcessar() {
		ProcessadorDePagamento.processar(bigDecimalMock, pagamentoStrategyMock);
		Mockito.verify(pagamentoStrategyMock).processar(bigDecimalMock);
	}
	
	@Test
	void deveLancarUmaConstraintViolationExceptionAoPassarUmParamtroNuloAoMetodoProcessar() {
		Assertions.assertAll(
				() -> Assertions.assertThrows(NullPointerException.class,
						() -> ProcessadorDePagamento.processar(null, pagamentoStrategyMock)),
				() -> Assertions.assertThrows(NullPointerException.class,
						() -> ProcessadorDePagamento.processar(bigDecimalMock, null)),
				() -> Assertions.assertThrows(NullPointerException.class,
						() -> ProcessadorDePagamento.processar(null, null)));
	}
}
