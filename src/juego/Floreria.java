package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Floreria {
	private double x;
	private double y;
	private Image img1;
	
	public Floreria(double x, double y) {
		// Dado que la floreria es unica, se definen los valores dentro del constructor
		this.x = 340;
		this.y = 300;
		this.img1= Herramientas.cargarImagen("floreria.png");
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void dibujar (Entorno e) {
		e.dibujarImagen(img1, x, y, 0);
		
	}
}
