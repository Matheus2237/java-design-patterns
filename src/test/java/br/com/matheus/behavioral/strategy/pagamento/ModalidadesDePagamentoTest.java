package br.com.matheus.behavioral.strategy.pagamento;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.matheus.behavioral.strategy.pagamento.estrategias.CartaoDeCredito;
import br.com.matheus.behavioral.strategy.pagamento.estrategias.CartaoDeDebito;
import br.com.matheus.behavioral.strategy.pagamento.estrategias.Dinheiro;
import br.com.matheus.behavioral.strategy.pagamento.estrategias.Pix;

class ModalidadesDePagamentoTest {

	@Test
	void deveRetornarUmObjetoInstanciadoDaClasseReferenteAoMetodo() {
		Assertions.assertAll("Assertivas para instancias das classes",
				() -> Assertions.assertInstanceOf(CartaoDeCredito.class, ModalidadesDePagamento.cartaoDeCredito()),
				() -> Assertions.assertInstanceOf(CartaoDeDebito.class, ModalidadesDePagamento.cartaoDeDebito()),
				() -> Assertions.assertInstanceOf(Dinheiro.class, ModalidadesDePagamento.dinheiro()),
				() -> Assertions.assertInstanceOf(Pix.class, ModalidadesDePagamento.pix()));
	}
}
