package br.com.matheus.behavioral.strategy.pagamento;

import java.math.BigDecimal;

import br.com.matheus.behavioral.strategy.pagamento.estrategias.PagamentoStrategy;

public class ProcessadorDePagamento {
    
	private ProcessadorDePagamento() {}
	
    public static void processar(BigDecimal valor, PagamentoStrategy estrategiaDePagamento) {
        estrategiaDePagamento.processar(valor);
    }
}
