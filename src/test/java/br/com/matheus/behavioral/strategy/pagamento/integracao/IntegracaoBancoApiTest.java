package br.com.matheus.behavioral.strategy.pagamento.integracao;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.math.BigDecimal;

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
		ResponseEntity<String> cartaoCreditoResponse = IntegracaoBancoApi.realizaTransacaoCartao(BigDecimal.TEN, Mockito.mock(CartaoDeCredito.class));
		ResponseEntity<String> cartaoDebitoResponse = IntegracaoBancoApi.realizaTransacaoCartao(BigDecimal.TEN, Mockito.mock(CartaoDeDebito.class));
		assertAll(
				() -> assertEquals(mensagemSucessoProessamento, cartaoCreditoResponse.getBody()),
				() -> assertEquals(mensagemSucessoProessamento, cartaoDebitoResponse.getBody()),
				() -> assertEquals(HttpStatus.OK, cartaoCreditoResponse.getStatusCode()),
				() -> assertEquals(HttpStatus.OK, cartaoDebitoResponse.getStatusCode()));
	}
	
	@Test
	void deveRetornarUmaRespostaHttpBadRequestAoRealizarATransacaoComTipoDePagamentoQueNaoECartao()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field mensagemTipoPagamentoInvalidoReflected = IntegracaoBancoApi.class.getDeclaredField("TIPO_PAGAMENTO_INVALIDO");
		mensagemTipoPagamentoInvalidoReflected.setAccessible(true);
		String mensagemTipoPagamentoInvalido = (String) mensagemTipoPagamentoInvalidoReflected.get(null);
		ResponseEntity<String> dinheiroResponse = IntegracaoBancoApi.realizaTransacaoCartao(BigDecimal.TEN, Mockito.mock(Dinheiro.class));
		ResponseEntity<String> pixResponse = IntegracaoBancoApi.realizaTransacaoCartao(BigDecimal.TEN, Mockito.mock(Pix.class));
		assertAll(
				() -> assertEquals(mensagemTipoPagamentoInvalido, dinheiroResponse.getBody()),
				() -> assertEquals(mensagemTipoPagamentoInvalido, pixResponse.getBody()),
				() -> assertEquals(HttpStatus.BAD_REQUEST, dinheiroResponse.getStatusCode()),
				() -> assertEquals(HttpStatus.BAD_REQUEST, pixResponse.getStatusCode()));
	}
	
	@Test
	void deveRetornarUmaRespostaHttpOkAoRealizarATransacaoComTipoDePagamentoPix()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field mensagemSucessoProessamentoReflected = IntegracaoBancoApi.class.getDeclaredField("SUCESSO_PROCESSAMENTO");
		mensagemSucessoProessamentoReflected.setAccessible(true);
		String mensagemSucessoProessamento = (String) mensagemSucessoProessamentoReflected.get(null);
		ResponseEntity<String> pixResponse = IntegracaoBancoApi.realizaTransacaoPix(BigDecimal.TEN);
		assertAll(
				() -> assertEquals(mensagemSucessoProessamento, pixResponse.getBody()),
				() -> assertEquals(HttpStatus.OK, pixResponse.getStatusCode()));
	}
	
	@Test
	void deveRetornarUmaRespostaHttpBadRequestAoRealizarATransacaoComValorDePagamentoNuloOuNegativo()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field mensagemPagamentoNegativoOuNuloReflected = IntegracaoBancoApi.class.getDeclaredField("PAGAMENTO_VALOR_NEGATIVO_NULO");
		mensagemPagamentoNegativoOuNuloReflected.setAccessible(true);
		String mensagemPagamentoNegativoOuNulo = (String) mensagemPagamentoNegativoOuNuloReflected.get(null);
		ResponseEntity<String> pixNuloResponse = IntegracaoBancoApi.realizaTransacaoPix(BigDecimal.ZERO);
		ResponseEntity<String> pixNegativoResponse = IntegracaoBancoApi.realizaTransacaoPix(BigDecimal.valueOf(-1));
		assertAll(
				() -> assertEquals(mensagemPagamentoNegativoOuNulo, pixNuloResponse.getBody()),
				() -> assertEquals(mensagemPagamentoNegativoOuNulo, pixNegativoResponse.getBody()),
				() -> assertEquals(HttpStatus.BAD_REQUEST, pixNuloResponse.getStatusCode()),
				() -> assertEquals(HttpStatus.BAD_REQUEST, pixNegativoResponse.getStatusCode()));
	}
}