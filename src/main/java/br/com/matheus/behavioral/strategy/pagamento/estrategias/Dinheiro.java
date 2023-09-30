package br.com.matheus.behavioral.strategy.pagamento.estrategias;

import java.math.BigDecimal;

import br.com.matheus.behavioral.strategy.pagamento.integracao.RegistroPagamento;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dinheiro implements PagamentoStrategy {
    
	private static final String MENSAGEM_PAGAMENTO_CONCLUIDO ="""
			
			Pagamento realizado!
			  Valor pago: R$ %.2f
			  Modalidade: Dinheiro""";

    @Override
    public void processar(BigDecimal valor) {
    	logger.info("Processando pagamento...");
    	RegistroPagamento.registraPagamento(valor);
    	logger.info(String.format(MENSAGEM_PAGAMENTO_CONCLUIDO, valor));
    }
}