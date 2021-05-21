package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Flecha {
	private double x;
	private double y;
	private Image flecha;
	
	public Flecha(double x, double y) {	
		this.x = x;
		this.y = y;
		this.flecha = Herramientas.cargarImagen("Flecha.png");
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void dibujar(Entorno e) {
		e.dibujarImagen(this.flecha, this.x, this.y, 0.0);
	}
}
