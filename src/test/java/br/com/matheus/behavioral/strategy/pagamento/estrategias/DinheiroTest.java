package br.com.matheus.behavioral.strategy.pagamento.estrategias;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import br.com.matheus.behavioral.strategy.pagamento.integracao.RegistroPagamento;

class DinheiroTest {

	@Test
	void deveRegistrarAVendaPagaEmDinheiro() {
		try (MockedStatic<RegistroPagamento> registroPagamentoMock = Mockito.mockStatic(RegistroPagamento.class)) {
			Dinheiro dinheiro = new Dinheiro();
			dinheiro.processar(BigDecimal.TEN);
			registroPagamentoMock.verify(() -> RegistroPagamento.registraPagamento(BigDecimal.TEN));
		}
	}
}