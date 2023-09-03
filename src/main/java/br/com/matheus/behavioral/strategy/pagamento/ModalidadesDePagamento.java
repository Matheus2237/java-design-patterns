package br.com.matheus.behavioral.strategy.pagamento;

import br.com.matheus.behavioral.strategy.pagamento.estrategias.CartaoDeCredito;
import br.com.matheus.behavioral.strategy.pagamento.estrategias.CartaoDeDebito;
import br.com.matheus.behavioral.strategy.pagamento.estrategias.Dinheiro;
import br.com.matheus.behavioral.strategy.pagamento.estrategias.PagamentoStrategy;
import br.com.matheus.behavioral.strategy.pagamento.estrategias.Pix;

public class ModalidadesDePagamento {

	private ModalidadesDePagamento() {}
	
    public static PagamentoStrategy cartaoDeCredito() {
        return new CartaoDeCredito();
    }

    public static PagamentoStrategy cartaoDeDebito() {
        return new CartaoDeDebito();
    }

    public static PagamentoStrategy dinheiro() {
        return new Dinheiro();
    }

    public static PagamentoStrategy pix() {
        return new Pix();
    }
}
