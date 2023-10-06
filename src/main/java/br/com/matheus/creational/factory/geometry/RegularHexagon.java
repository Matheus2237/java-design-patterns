package br.com.matheus.creational.factory.geometry;

import br.com.matheus.creational.factory.PoligonoInexistenteException;

public class RegularHexagon implements RegularPolygon {

	private double size;

	public RegularHexagon(double size) {
		if (size <= 0)
			throw new PoligonoInexistenteException("Não existe polígono com lado de tamanho negativo ou nulo.");
		this.size = size;
	}

	@Override
	public double calculateArea() {
		return 3 * Math.sqrt(3) * Math.pow(size, 2) / 2.0;
	}
}
