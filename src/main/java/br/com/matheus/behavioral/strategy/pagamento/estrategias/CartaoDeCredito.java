package br.com.matheus.behavioral.strategy.pagamento.estrategias;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CartaoDeCredito implements PagamentoStrategy {
    
	private static final String MENSAGEM_PAGAMENTO_CONCLUIDO = """

			Pagamento realizado!
			  Valor pago: R$ %.2f
			  Modalidade: Cartão de Crédito

			""";

    @Override
    public void processar(BigDecimal valor) {
        try {
            logger.info("\nProcessando pagamento...");
            Thread.sleep(1_000);
            logger.info(String.format(MENSAGEM_PAGAMENTO_CONCLUIDO, valor));
        } catch (InterruptedException ie) {
            logger.error("Exception caught: ", ie);
            Thread.currentThread().interrupt();
        }
    }
}
