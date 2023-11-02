package br.com.matheus.behavioral.strategy.pagamento;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.matheus.behavioral.strategy.pagamento.estrategias.PagamentoStrategy;

class ProcessadorDePagamentoTest {

	@Mock
	private BigDecimal bigDecimalMock;

	@Mock
	private PagamentoStrategy pagamentoStrategyMock;
	
	private AutoCloseable mocks; 
	
	@BeforeEach
	void setUp() {
		this.mocks = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		this.mocks.close();
	}
	
	@Test
	void deveExecutarUmaChamadaParaOMetodoProcessarDaPagamentoStrategyAoChamarOMetodoProcessar() {
		ProcessadorDePagamento.processar(bigDecimalMock, pagamentoStrategyMock);
		verify(pagamentoStrategyMock).processar(bigDecimalMock);
	}
	
	@Test
	void deveLancarUmaConstraintViolationExceptionAoPassarUmParamtroNuloAoMetodoProcessar() {
		assertAll("Lançamento de exceção com passagem de parâmetros nulos.",
				() -> assertThrows(NullPointerException.class,
						() -> ProcessadorDePagamento.processar(null, pagamentoStrategyMock)),
				() -> assertThrows(NullPointerException.class,
						() -> ProcessadorDePagamento.processar(bigDecimalMock, null)),
				() -> assertThrows(NullPointerException.class,
						() -> ProcessadorDePagamento.processar(null, null)));
	}
}