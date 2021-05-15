package juego;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import entorno.Entorno;
import entorno.Herramientas;

public class Ninja {
	private double x;
	private double y;
	private int ancho;
	private int alto;
	private double velocidad;
	private Image img1;
	
	public Ninja(double x, double y) {
		this.x = x;
		this.y = y;
		this.ancho = 50;
		this.alto = 20;
		this.velocidad = 2;
		this.img1 = Herramientas.cargarImagen("ninja.png");
	}
	

	public int getAncho() {
		return ancho;
	}


	public int getAlto() {
		return alto;
	}


	public double getX() {
		return x;
	}


	public double getY() {
		return y;
	}


	public void dibujar(Entorno e) {
		e.dibujarImagen(img1, x, y, Math.PI*2);
	
		
	}
		public void mover() {
		// TODO Auto-generated method stub
		y += velocidad;
	}
	
//	public void cambiarDeDireccion() {
//		angulo += Math.PI/2;
//	}
	
	public boolean chocasteConElEntorno(Entorno e) {
		return x <= alto / 2 || x >= e.ancho() - alto / 2 || 
				y <= ancho / 2 || y >= e.alto() - ancho / 2;
	}
	

}
