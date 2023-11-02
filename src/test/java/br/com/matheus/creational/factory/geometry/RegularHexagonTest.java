package br.com.matheus.creational.factory.geometry;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.matheus.creational.factory.RegularPolygonFactory;

class RegularHexagonTest {

	@Test
	void deveCalcularAAreaDoHexagonoERetornarSeuValorCorretamente() {
		double delta = 0.00001;
		assertAll("Cálculos de área de um hexágono.",
				() -> assertEquals(2.59807, RegularPolygonFactory.createPolygon(6, 1).calculateArea(), delta),
				() -> assertEquals(5.84567, RegularPolygonFactory.createPolygon(6, 1.5).calculateArea(), delta),
				() -> assertEquals(28.80980, RegularPolygonFactory.createPolygon(6, 3.33).calculateArea(), delta));
	}
}