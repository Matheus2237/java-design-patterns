package br.com.matheus.behavioral.strategy.pagamento.estrategias;

public class TipoPagamentoImproprioException extends Exception {

	private static final long serialVersionUID = -3758599968080261332L;

	public TipoPagamentoImproprioException(String mensagem) {
		super(mensagem);
	}
}
