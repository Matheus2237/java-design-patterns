package br.com.matheus.creational.factory.geometry;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.matheus.creational.factory.RegularPolygonFactory;

class RegularSquareTest {

	@Test
	void deveCalcularAAreaDoQuadradoERetornarSeuValorCorretamente() {
		double delta = 0.00001;
		assertAll("Cálculos de área de um quadrado.",
				() -> assertEquals(1, RegularPolygonFactory.createPolygon(4, 1).calculateArea(), delta),
				() -> assertEquals(2.25, RegularPolygonFactory.createPolygon(4, 1.5).calculateArea(), delta),
				() -> assertEquals(11.0889, RegularPolygonFactory.createPolygon(4, 3.33).calculateArea(), delta));
	}
}