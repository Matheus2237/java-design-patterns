package br.com.matheus.behavioral.strategy.pagamento.estrategias;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;

import br.com.matheus.behavioral.strategy.pagamento.integracao.IntegracaoBancoApi;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CartaoDeDebito implements PagamentoStrategy {

    @Override
    public void processar(BigDecimal valor) {
		ResponseEntity<String> transacao = IntegracaoBancoApi.simulaTransacao(valor, this);
		logger.info(transacao.getBody());
    }
}