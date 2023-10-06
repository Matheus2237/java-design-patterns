package br.com.matheus.creational.factory.geometry;

import br.com.matheus.creational.factory.PoligonoInexistenteException;

public class RegularSquare implements RegularPolygon {

	private double size;

	public RegularSquare(double size) {
		if (size <= 0)
			throw new PoligonoInexistenteException("Não existe polígono com lado de tamanho negativo ou nulo.");
		this.size = size;
	}

	@Override
	public double calculateArea() {
		return Math.pow(size, 2);
	}
}
