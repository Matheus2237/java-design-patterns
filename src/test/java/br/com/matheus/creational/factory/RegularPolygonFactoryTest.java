package br.com.matheus.creational.factory;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.matheus.creational.factory.geometry.RegularHexagon;
import br.com.matheus.creational.factory.geometry.RegularPentagon;
import br.com.matheus.creational.factory.geometry.RegularSquare;
import br.com.matheus.creational.factory.geometry.RegularTriangle;

class RegularPolygonFactoryTest {

	@Test
	void deveInstanciarAEspecificacaoCorretaDoPoligonoAPartirDaSuaQuantidadeDeLados() {
		assertAll("Criação de polígonos com lados e tamanhos válidos",
				() -> assertInstanceOf(RegularTriangle.class, RegularPolygonFactory.createPolygon(3, 1)),
				() -> assertInstanceOf(RegularSquare.class, RegularPolygonFactory.createPolygon(4, 1)),
				() -> assertInstanceOf(RegularPentagon.class, RegularPolygonFactory.createPolygon(5, 1)),
				() -> assertInstanceOf(RegularHexagon.class, RegularPolygonFactory.createPolygon(6, 1)));
	}
	
	@Test
	void deveLancarExecaoSeForSolicitadaCriacaoDePoligonoComMenosDeTresLados() {
		assertAll("Tentativa de criar polígonos com menos de três lados.",
				() -> assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(2, 1)),
				() -> assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(1, 1)),
				() -> assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(0, 1)),
				() -> assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(-1, 1)));
	}
	
	@Test
	void deveLancarExcecaoSeForSolicitadaCriacaoDePoligonoComLadoNuloOuNegativo() {
		assertAll("Tentativa de criar triângulo com lado de tamanho nulo ou negativo.",
				() -> assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(3, 0)),
				() -> assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(3, -0.1)),
				() -> assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(3, -1)));
		assertAll("Tentativa de criar quadrado com lado de tamanho nulo ou negativo.",
				() -> assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(4, 0)),
				() -> assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(4, -0.1)),
				() -> assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(4, -1)));
		assertAll("Tentativa de criar pentágono com lado de tamanho nulo ou negativo.",
				() -> assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(5, 0)),
				() -> assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(5, -0.1)),
				() -> assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(5, -1)));
		assertAll("Tentativa de criar hexágono com lado de tamanho nulo ou negativo.",
				() -> assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(6, 0)),
				() -> assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(6, -0.1)),
				() -> assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(6, -1)));
	}
	
	@Test
	void deveLancarExcecaoSeForSolicitadaCriacaoDePoligonoAindaNaoImplementado() {
		assertThrows(PoligonoInexistenteException.class, () -> RegularPolygonFactory.createPolygon(7, 1));
	}
}