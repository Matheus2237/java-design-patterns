package br.com.matheus.creational.factory.enumfactory;

import br.com.matheus.creational.factory.geometry.RegularHexagon;
import br.com.matheus.creational.factory.geometry.RegularPentagon;
import br.com.matheus.creational.factory.geometry.RegularPolygon;
import br.com.matheus.creational.factory.geometry.RegularSquare;
import br.com.matheus.creational.factory.geometry.RegularTriangle;

public enum RegularPolygonEnumAsFactory {

	TRIANGLE {

		@Override
		public RegularPolygon createWithSize(double size) {
			return new RegularTriangle(size);
		}
	},
	
	SQUARE {

		@Override
		public RegularPolygon createWithSize(double size) {
			return new RegularSquare(size);
		}
	},
	
	PENTAGON {

		@Override
		public RegularPolygon createWithSize(double size) {
			return new RegularPentagon(size);
		}
	},
	
	HEXAGON {

		@Override
		public RegularPolygon createWithSize(double size) {
			return new RegularHexagon(size);
		}
	};
	
	public abstract RegularPolygon createWithSize(double size);
}
