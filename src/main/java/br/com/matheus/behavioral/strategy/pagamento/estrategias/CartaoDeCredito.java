package br.com.matheus.behavioral.strategy.pagamento.estrategias;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;

import br.com.matheus.behavioral.strategy.pagamento.integracao.IntegracaoBancoApi;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CartaoDeCredito implements PagamentoStrategy {
    
    @Override
    public void processar(BigDecimal valor) {
		ResponseEntity<String> transacao = IntegracaoBancoApi.realizaTransacaoCartao(valor, this);
		logger.info(transacao.getBody());
    }
}