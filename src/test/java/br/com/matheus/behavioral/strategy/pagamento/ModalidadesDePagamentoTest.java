package br.com.matheus.behavioral.strategy.pagamento;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;

import br.com.matheus.behavioral.strategy.pagamento.estrategias.CartaoDeCredito;
import br.com.matheus.behavioral.strategy.pagamento.estrategias.CartaoDeDebito;
import br.com.matheus.behavioral.strategy.pagamento.estrategias.Dinheiro;
import br.com.matheus.behavioral.strategy.pagamento.estrategias.Pix;

class ModalidadesDePagamentoTest {

	@Test
	void deveRetornarUmObjetoInstanciadoDaClasseReferenteAoMetodo() {
		assertAll("Assertivas para instancias das classes",
				() -> assertInstanceOf(CartaoDeCredito.class, ModalidadesDePagamento.cartaoDeCredito()),
				() -> assertInstanceOf(CartaoDeDebito.class, ModalidadesDePagamento.cartaoDeDebito()),
				() -> assertInstanceOf(Dinheiro.class, ModalidadesDePagamento.dinheiro()),
				() -> assertInstanceOf(Pix.class, ModalidadesDePagamento.pix()));
	}
}
