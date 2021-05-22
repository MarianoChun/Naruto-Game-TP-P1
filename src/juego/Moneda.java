package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Moneda {
	private double x;
	private double y;
	private Image moneda;
	public Moneda(double x, double y) {
		
		this.x = x;
		this.y = y;
		this.moneda = Herramientas.cargarImagen("moneda.png");
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void dibujar(Entorno e) {
		e.dibujarImagen(moneda, x, y, 0);
	}
	
}
