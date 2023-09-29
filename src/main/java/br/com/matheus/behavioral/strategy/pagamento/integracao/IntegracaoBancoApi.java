package br.com.matheus.behavioral.strategy.pagamento.integracao;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.matheus.behavioral.strategy.pagamento.estrategias.CartaoDeCredito;
import br.com.matheus.behavioral.strategy.pagamento.estrategias.CartaoDeDebito;
import br.com.matheus.behavioral.strategy.pagamento.estrategias.PagamentoStrategy;
import br.com.matheus.behavioral.strategy.pagamento.estrategias.TipoPagamentoImproprioException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntegracaoBancoApi {

	private static final String MENSAGEM_PAGAMENTO_CONCLUIDO = """
			
			Pagamento realizado!
			  Valor pago: R$ %.2f
			  Modalidade: %s
			""";
	
	
	private static final String TIPO_PAGAMENTO_INVALIDO = "Tipo de pagamento informado é inválido para essa requisição.";
	
	private static final String SUCESSO_PROCESSAMENTO = "Pagamento concluído com sucesso.";
	
	private IntegracaoBancoApi() {}
	
		public static ResponseEntity<String> realizaTransacaoCartao(BigDecimal valor, PagamentoStrategy estrategia) {
		try {
            logger.info("Processando pagamento...");
            logger.info(String.format(MENSAGEM_PAGAMENTO_CONCLUIDO, valor, defineTipoCartao(estrategia)));
        } catch (TipoPagamentoImproprioException tpie) {
        	logger.error("Tipo de pagamento inválido para essa integração: ");
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(tpie.getMessage());
        }
		return ResponseEntity.status(HttpStatus.OK).body(SUCESSO_PROCESSAMENTO);
	}
	
	private static String defineTipoCartao(PagamentoStrategy estrategia) throws TipoPagamentoImproprioException {
		if (estrategia instanceof CartaoDeCredito)
			return "Cartao De Crédito";
		else if (estrategia instanceof CartaoDeDebito)
			return "Cartão de Débito";
		throw new TipoPagamentoImproprioException(TIPO_PAGAMENTO_INVALIDO);
	}
}