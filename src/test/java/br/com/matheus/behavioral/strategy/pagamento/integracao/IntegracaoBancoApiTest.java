package br.com.matheus.behavioral.strategy.pagamento.integracao;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.matheus.behavioral.strategy.pagamento.estrategias.CartaoDeCredito;
import br.com.matheus.behavioral.strategy.pagamento.estrategias.CartaoDeDebito;
import br.com.matheus.behavioral.strategy.pagamento.estrategias.Dinheiro;
import br.com.matheus.behavioral.strategy.pagamento.estrategias.Pix;

class IntegracaoBancoApiTest {
	
	@Test
	void deveRetornarUmaRespostaHttpOkAoRealizarATransacaoComTipoDePagamentoCartao()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field mensagemSucessoProessamentoReflected = IntegracaoBancoApi.class.getDeclaredField("SUCESSO_PROCESSAMENTO");
		mensagemSucessoProessamentoReflected.setAccessible(true);
		String mensagemSucessoProessamento = (String) mensagemSucessoProessamentoReflected.get(null);
		ResponseEntity<String> cartaoCreditoResponse = IntegracaoBancoApi.simulaTransacao(BigDecimal.TEN, Mockito.mock(CartaoDeCredito.class));
		ResponseEntity<String> cartaoDebitoResponse = IntegracaoBancoApi.simulaTransacao(BigDecimal.TEN, Mockito.mock(CartaoDeDebito.class));
		Assertions.assertAll(
				() -> Assertions.assertEquals(mensagemSucessoProessamento, cartaoCreditoResponse.getBody()),
				() -> Assertions.assertEquals(mensagemSucessoProessamento, cartaoDebitoResponse.getBody()),
				() -> Assertions.assertEquals(HttpStatus.OK, cartaoCreditoResponse.getStatusCode()),
				() -> Assertions.assertEquals(HttpStatus.OK, cartaoDebitoResponse.getStatusCode())
		);
	}
	
	@Test
	void deveRetornarUmaRespostaHttpBadRequestAoRealizarATransacaoComTipoDePagamentoQueNaoECartao()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field mensagemTipoPagamentoInvalidoReflected = IntegracaoBancoApi.class.getDeclaredField("TIPO_PAGAMENTO_INVALIDO");
		mensagemTipoPagamentoInvalidoReflected.setAccessible(true);
		String mensagemTipoPagamentoInvalido = (String) mensagemTipoPagamentoInvalidoReflected.get(null);
		ResponseEntity<String> dinheiroResponse = IntegracaoBancoApi.simulaTransacao(BigDecimal.TEN, Mockito.mock(Dinheiro.class));
		ResponseEntity<String> pixResponse = IntegracaoBancoApi.simulaTransacao(BigDecimal.TEN, Mockito.mock(Pix.class));
		Assertions.assertAll(
				() -> Assertions.assertEquals(mensagemTipoPagamentoInvalido, dinheiroResponse.getBody()),
				() -> Assertions.assertEquals(mensagemTipoPagamentoInvalido, pixResponse.getBody()),
				() -> Assertions.assertEquals(HttpStatus.BAD_REQUEST, dinheiroResponse.getStatusCode()),
				() -> Assertions.assertEquals(HttpStatus.BAD_REQUEST, pixResponse.getStatusCode())
		);
	}
}