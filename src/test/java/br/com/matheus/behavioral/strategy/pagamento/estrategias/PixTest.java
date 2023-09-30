package br.com.matheus.behavioral.strategy.pagamento.estrategias;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import br.com.matheus.behavioral.strategy.pagamento.integracao.IntegracaoBancoApi;

class PixTest {

	@Mock
	private ResponseEntity<String> responseEntityMock;
	
	@InjectMocks
	private Pix pix;

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
	void deveChamarAIntegracaoComAAPIDoBancoParaRealizarPagamentoPix() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		try (MockedStatic<IntegracaoBancoApi> integracaoBancoApiMock = Mockito.mockStatic(IntegracaoBancoApi.class)) {
			integracaoBancoApiMock
						.when(() -> IntegracaoBancoApi.realizaTransacaoPix(BigDecimal.TEN))
						.thenReturn(responseEntityMock);
			Mockito.when(responseEntityMock.getBody()).thenReturn("");
			pix.processar(BigDecimal.TEN);
			integracaoBancoApiMock.verify(() -> IntegracaoBancoApi.realizaTransacaoPix(BigDecimal.TEN));
		}
	}
}
