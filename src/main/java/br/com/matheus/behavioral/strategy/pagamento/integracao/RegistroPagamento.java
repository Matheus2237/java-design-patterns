package br.com.matheus.behavioral.strategy.pagamento.integracao;

import java.math.BigDecimal;

import br.com.matheus.util.ExcludeFromCodeCoverageAnalysisGenerated;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExcludeFromCodeCoverageAnalysisGenerated
public class RegistroPagamento {
	
	private RegistroPagamento() {}
	
	public static void registraPagamento(BigDecimal valor) {
		logger.info(String.format("Pagamento em dinheiro do valor %.2f registrado na base...", valor.toString()));
	}
}