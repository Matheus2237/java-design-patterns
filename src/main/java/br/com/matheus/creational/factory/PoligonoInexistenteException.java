package br.com.matheus.creational.factory;

public class PoligonoInexistenteException extends RuntimeException {

	private static final long serialVersionUID = -1167093786128340517L;

	public PoligonoInexistenteException(String mensagem) {
		super(mensagem);
	}
}
