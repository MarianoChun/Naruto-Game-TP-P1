package juego;

import java.awt.Color;

import entorno.Entorno;

public class Casa {
	private double x;
	private double y;
	private double ancho;
	private double alto;
	private double angulo;
	private Color color;

	
	public Casa(double x, double y, double ancho, double alto,double angulo, Color color) {
		this.x = x;
		this.y = y;
		this.ancho = 50;
		this.alto = 40;
		this.angulo = angulo;
		this.color = color;
	}
	
	public void dibujar (Entorno e) {
		e.dibujarRectangulo(x, y, ancho, alto, angulo, color);
		
	}

}
