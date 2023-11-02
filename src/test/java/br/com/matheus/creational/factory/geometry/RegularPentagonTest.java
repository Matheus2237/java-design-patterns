package br.com.matheus.creational.factory.geometry;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.matheus.creational.factory.RegularPolygonFactory;

class RegularPentagonTest {

	@Test
	void deveCalcularAAreaDoPentagonoERetornarSeuValorCorretamente() {
		double delta = 0.00001;
		assertAll("Cálculos de área de um pentágono.",
				() -> assertEquals(1.72047, RegularPolygonFactory.createPolygon(5, 1).calculateArea(), delta),
				() -> assertEquals(3.87107, RegularPolygonFactory.createPolygon(5, 1.5).calculateArea(), delta),
				() -> assertEquals(19.07820, RegularPolygonFactory.createPolygon(5, 3.33).calculateArea(), delta));
	}
}