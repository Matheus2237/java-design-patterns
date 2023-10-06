package br.com.matheus.creational.factory.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.matheus.creational.factory.RegularPolygonFactory;

class RegularPentagonTest {

	@Test
	void deveCalcularAAreaDoPentagonoERetornarSeuValorCorretamente() {
		double delta = 0.00001;
		Assertions.assertAll("Cálculos de área de um pentágono.",
				() -> Assertions.assertEquals(1.72047, RegularPolygonFactory.createPolygon(5, 1).calculateArea(), delta),
				() -> Assertions.assertEquals(3.87107, RegularPolygonFactory.createPolygon(5, 1.5).calculateArea(), delta),
				() -> Assertions.assertEquals(19.07820, RegularPolygonFactory.createPolygon(5, 3.33).calculateArea(), delta));
	}
}