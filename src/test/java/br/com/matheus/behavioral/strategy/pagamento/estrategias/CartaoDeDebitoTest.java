package br.com.matheus.behavioral.strategy.pagamento.estrategias;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import br.com.matheus.behavioral.strategy.pagamento.integracao.IntegracaoBancoApi;

class CartaoDeDebitoTest {

	@Mock
	private ResponseEntity<String> responseEntityMock;
	
	@InjectMocks
	private CartaoDeDebito cartaoDeDebito;

	private AutoCloseable mocks;

	@BeforeAll
	static void setUpBeforeAll() {
		System.setProperty("logback.congirationFile", "src/test/resources/logback-test.xml");
	}
	
	@BeforeEach
	void setUp() {
		this.mocks = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		this.mocks.close();
	}
	
	@Test
	void deveChamarAIntegracaoComAAPIDoBanco() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		try (MockedStatic<IntegracaoBancoApi> integracaoBancoApiMock = Mockito.mockStatic(IntegracaoBancoApi.class)) {
			integracaoBancoApiMock
						.when(() -> IntegracaoBancoApi.realizaTransacaoCartao(BigDecimal.TEN, cartaoDeDebito))
						.thenReturn(responseEntityMock);
			when(responseEntityMock.getBody()).thenReturn("");
			cartaoDeDebito.processar(BigDecimal.TEN);
			integracaoBancoApiMock.verify(() -> IntegracaoBancoApi.realizaTransacaoCartao(BigDecimal.TEN, cartaoDeDebito));
		}
	}
}