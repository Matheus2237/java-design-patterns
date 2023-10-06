package br.com.matheus.creational.factory;

import br.com.matheus.creational.factory.geometry.RegularPolygon;
import br.com.matheus.util.ExcludeFromCodeCoverageAnalysisGenerated;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExcludeFromCodeCoverageAnalysisGenerated
public class Main {

	public static void main(String[] args) {
		RegularPolygon triangulo = RegularPolygonFactory.createPolygon(3, 5);
		RegularPolygon quadrado = RegularPolygonFactory.createPolygon(4, 3.7);
		RegularPolygon pentagono = RegularPolygonFactory.createPolygon(5, 4.8);
		RegularPolygon hexagono = RegularPolygonFactory.createPolygon(6, 8.4);
		logger.info(String.format("Área do triângulo regular de lado 5 = %.2f u.A.", triangulo.calculateArea()));
		logger.info(String.format("Área do quadrado regular de lado 3,7 = %.2f u.A.", quadrado.calculateArea()));
		logger.info(String.format("Área do pentágono regular de lado 4,8 = %.2f u.A.", pentagono.calculateArea()));
		logger.info(String.format("Área do hexágono regular de lado 8,4 = %.2f u.A.", hexagono.calculateArea()));
	}
}