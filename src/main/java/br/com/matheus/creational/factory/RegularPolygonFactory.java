package br.com.matheus.creational.factory;

import br.com.matheus.creational.factory.geometry.RegularHexagon;
import br.com.matheus.creational.factory.geometry.RegularPentagon;
import br.com.matheus.creational.factory.geometry.RegularPolygon;
import br.com.matheus.creational.factory.geometry.RegularSquare;
import br.com.matheus.creational.factory.geometry.RegularTriangle;

public class RegularPolygonFactory {

	private RegularPolygonFactory() {}
	
	public static RegularPolygon createPolygon(int sides, double size) {
		if (sides == 3)
			return new RegularTriangle(size);
		else if (sides == 4)
			return new RegularSquare(size);
		else if (sides == 5)
			return new RegularPentagon(size);
		else if (sides == 6)
			return new RegularHexagon(size);
		else if (sides > 6)
			throw new PoligonoInexistenteException("Polígono não implementado pela aplicação.");
		else
			throw new PoligonoInexistenteException("Não existe polígono com menos de três lados.");
	}
}