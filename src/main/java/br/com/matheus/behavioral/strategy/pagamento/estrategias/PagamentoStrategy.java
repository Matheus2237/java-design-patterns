package br.com.matheus.behavioral.strategy.pagamento.estrategias;

import java.math.BigDecimal;

public interface PagamentoStrategy {
    	
    void processar(BigDecimal valor);
}
