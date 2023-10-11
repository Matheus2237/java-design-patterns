package br.com.matheus.creational.factory.enumassimplefactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.matheus.creational.factory.PoligonoInexistenteException;
import br.com.matheus.creational.factory.enumfactory.RegularPolygonEnumAsFactory;
import br.com.matheus.creational.factory.geometry.RegularHexagon;
import br.com.matheus.creational.factory.geometry.RegularPentagon;
import br.com.matheus.creational.factory.geometry.RegularSquare;
import br.com.matheus.creational.factory.geometry.RegularTriangle;

class RegularPolygonEnumAsFactoryTest {

	@Test
	void deveInstanciarAEspecificacaoCorretaDoPoligonoAPartirDaSuaQuantidadeDeLados() {
		Assertions.assertAll("Criação de polígonos com lados e tamanhos válidos",
				() -> Assertions.assertInstanceOf(RegularTriangle.class, RegularPolygonEnumAsFactory.TRIANGLE.createWithSize(1)),
				() -> Assertions.assertInstanceOf(RegularSquare.class, RegularPolygonEnumAsFactory.SQUARE.createWithSize(1)),
				() -> Assertions.assertInstanceOf(RegularPentagon.class, RegularPolygonEnumAsFactory.PENTAGON.createWithSize(1)),
				() -> Assertions.assertInstanceOf(RegularHexagon.class, RegularPolygonEnumAsFactory.HEXAGON.createWithSize(1)));
	}
	
	@Test
	void deveLancarExcecaoSeForSolicitadaCriacaoDePoligonoComLadoNuloOuNegativo() {
		Assertions.assertAll("Tentativa de criar triângulo com lado de tamanho nulo ou negativo.",
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonEnumAsFactory.TRIANGLE.createWithSize(0)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonEnumAsFactory.TRIANGLE.createWithSize(-0.1)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonEnumAsFactory.TRIANGLE.createWithSize(-1)));
		Assertions.assertAll("Tentativa de criar quadrado com lado de tamanho nulo ou negativo.",
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonEnumAsFactory.SQUARE.createWithSize(0)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonEnumAsFactory.SQUARE.createWithSize(-0.1)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonEnumAsFactory.SQUARE.createWithSize(-1)));
		Assertions.assertAll("Tentativa de criar pentágono com lado de tamanho nulo ou negativo.",
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonEnumAsFactory.PENTAGON.createWithSize(0)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonEnumAsFactory.PENTAGON.createWithSize(-0.1)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonEnumAsFactory.PENTAGON.createWithSize(-1)));
		Assertions.assertAll("Tentativa de criar hexágono com lado de tamanho nulo ou negativo.",
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonEnumAsFactory.HEXAGON.createWithSize(0)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonEnumAsFactory.HEXAGON.createWithSize(-0.1)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonEnumAsFactory.HEXAGON.createWithSize(-1)));
	}
}