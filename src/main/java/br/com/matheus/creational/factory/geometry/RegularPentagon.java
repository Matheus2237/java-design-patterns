package br.com.matheus.creational.factory.geometry;

import br.com.matheus.creational.factory.PoligonoInexistenteException;

public class RegularPentagon implements RegularPolygon {

	private double size;

	public RegularPentagon(double size) {
		if (size <= 0)
			throw new PoligonoInexistenteException("Não existe polígono com lado de tamanho negativo ou nulo.");
		this.size = size;
	}

	@Override
	public double calculateArea() {
		return 5 / 4.0 * Math.pow(size, 2) * 1 / Math.tan(Math.PI/5);
	}
}
