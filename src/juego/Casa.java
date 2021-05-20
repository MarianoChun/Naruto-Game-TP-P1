package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Casa {
	private double x;
	private double y;
	private double ancho;
	private double alto;
	private double angulo;
	private Color color;
	private Image img1;
	

	// Al usar imagenes, sacar (angulo?) y color
	public Casa(double x, double y, double ancho, double alto,double angulo, Color color) {
		this.x = x;
		this.y = y;
		this.ancho = 50;
		this.alto = 40;
		this.angulo = angulo;
		this.color = color;
		this.img1= Herramientas.cargarImagen("casas.png");
	}
	
	public void dibujar (Entorno e) {
		//e.dibujarRectangulo(x, y, ancho, alto, angulo, color);
		e.dibujarImagen(this.img1,this.x,this.y,0);
		
	}

}
