package br.com.matheus.creational.factory.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.matheus.creational.factory.RegularPolygonFactory;

class RegularTriangleTest {

	@Test
	void deveCalcularAAreaDoTrianguloERetornarSeuValorCorretamente() {
		double delta = 0.00001;
		Assertions.assertAll("Cálculos de área de um triângulo.",
				() -> Assertions.assertEquals(0.43301, RegularPolygonFactory.createPolygon(3, 1).calculateArea(), delta),
				() -> Assertions.assertEquals(0.97427, RegularPolygonFactory.createPolygon(3, 1.5).calculateArea(), delta),
				() -> Assertions.assertEquals(4.80163, RegularPolygonFactory.createPolygon(3, 3.33).calculateArea(), delta));
	}
}