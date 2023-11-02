package br.com.matheus.creational.factory.geometry;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.matheus.creational.factory.RegularPolygonFactory;

class RegularTriangleTest {

	@Test
	void deveCalcularAAreaDoTrianguloERetornarSeuValorCorretamente() {
		double delta = 0.00001;
		assertAll("Cálculos de área de um triângulo.",
				() -> assertEquals(0.43301, RegularPolygonFactory.createPolygon(3, 1).calculateArea(), delta),
				() -> assertEquals(0.97427, RegularPolygonFactory.createPolygon(3, 1.5).calculateArea(), delta),
				() -> assertEquals(4.80163, RegularPolygonFactory.createPolygon(3, 3.33).calculateArea(), delta));
	}
}