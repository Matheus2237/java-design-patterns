package br.com.matheus.creational.factory.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.matheus.creational.factory.RegularPolygonFactory;

class RegularHexagonTest {

	@Test
	void deveCalcularAAreaDoHexagonoERetornarSeuValorCorretamente() {
		double delta = 0.00001;
		Assertions.assertAll("Cálculos de área de um hexágono.",
				() -> Assertions.assertEquals(2.59807, RegularPolygonFactory.createPolygon(6, 1).calculateArea(), delta),
				() -> Assertions.assertEquals(5.84567, RegularPolygonFactory.createPolygon(6, 1.5).calculateArea(), delta),
				() -> Assertions.assertEquals(28.80980, RegularPolygonFactory.createPolygon(6, 3.33).calculateArea(), delta));
	}
}