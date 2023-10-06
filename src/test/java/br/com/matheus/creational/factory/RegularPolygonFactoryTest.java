package br.com.matheus.creational.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.matheus.creational.factory.geometry.RegularHexagon;
import br.com.matheus.creational.factory.geometry.RegularPentagon;
import br.com.matheus.creational.factory.geometry.RegularSquare;
import br.com.matheus.creational.factory.geometry.RegularTriangle;

class RegularPolygonFactoryTest {

	@Test
	void deveInstanciarAEspecificacaoCorretaDoPoligonoAPartirDaSuaQuantidadeDeLados() {
		Assertions.assertAll("Criação de polígonos com lados e tamanhos válidos",
				() -> Assertions.assertInstanceOf(RegularTriangle.class, RegularPolygonFactory.createPolygon(3, 1)),
				() -> Assertions.assertInstanceOf(RegularSquare.class, RegularPolygonFactory.createPolygon(4, 1)),
				() -> Assertions.assertInstanceOf(RegularPentagon.class, RegularPolygonFactory.createPolygon(5, 1)),
				() -> Assertions.assertInstanceOf(RegularHexagon.class, RegularPolygonFactory.createPolygon(6, 1)));
	}
	
	@Test
	void deveLancarExecaoSeForSolicitadaCriacaoDePoligonoComMenosDeTresLados() {
		Assertions.assertAll("Tentativa de criar polígonos com menos de três lados.",
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(2, 1)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(1, 1)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(0, 1)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(-1, 1)));
	}
	
	@Test
	void deveLancarExcecaoSeForSolicitadaCriacaoDePoligonoComLadoNuloOuNegativo() {
		Assertions.assertAll("Tentativa de criar triângulo com lado de tamanho nulo ou negativo.",
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(3, 0)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(3, -0.1)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(3, -1)));
		Assertions.assertAll("Tentativa de criar quadrado com lado de tamanho nulo ou negativo.",
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(4, 0)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(4, -0.1)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(4, -1)));
		Assertions.assertAll("Tentativa de criar pentágono com lado de tamanho nulo ou negativo.",
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(5, 0)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(5, -0.1)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(5, -1)));
		Assertions.assertAll("Tentativa de criar hexágono com lado de tamanho nulo ou negativo.",
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(6, 0)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(6, -0.1)),
				() -> Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(6, -1)));
	}
	
	@Test
	void deveLancarExcecaoSeForSolicitadaCriacaoDePoligonoAindaNaoImplementado() {
		Assertions.assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(7, 1));
	}
}