package br.com.matheus.behavioral.strategy;

import java.math.BigDecimal;

import br.com.matheus.behavioral.strategy.pagamento.ModalidadesDePagamento;
import br.com.matheus.behavioral.strategy.pagamento.ProcessadorDePagamento;

public class Main{
    public static void main(String[] args) {
        ProcessadorDePagamento.processar(BigDecimal.valueOf(500), ModalidadesDePagamento.cartaoDeCredito());
        ProcessadorDePagamento.processar(BigDecimal.valueOf(1_000), ModalidadesDePagamento.cartaoDeDebito());
        ProcessadorDePagamento.processar(BigDecimal.valueOf(38.7), ModalidadesDePagamento.dinheiro());
        ProcessadorDePagamento.processar(BigDecimal.valueOf(390.54), ModalidadesDePagamento.pix());
    }
}