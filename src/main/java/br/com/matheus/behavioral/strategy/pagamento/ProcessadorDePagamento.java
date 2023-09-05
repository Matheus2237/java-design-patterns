package br.com.matheus.behavioral.strategy.pagamento;

import java.math.BigDecimal;

import br.com.matheus.behavioral.strategy.pagamento.estrategias.PagamentoStrategy;
import lombok.NonNull;

public class ProcessadorDePagamento {
    
	private ProcessadorDePagamento() {}
	
    public static void processar(@NonNull BigDecimal valor, @NonNull PagamentoStrategy estrategiaDePagamento) {
        estrategiaDePagamento.processar(valor);
    }
}
