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
	private double angulo;
	private double velocidad;
	private Color color;
	
	public Ninja(double x, double y, double velocidad, double angulo, Color color) {
		this.x = x;
		this.y = y;
		this.ancho = 50;
		this.alto = 20;
		this.velocidad = velocidad;
		this.angulo = angulo;
		this.color = color;
	}
	

	public void dibujar(Entorno e) {
//		Image ninja = Herramientas.cargarImagen("ninja.png");
//		e.dibujarImagen(ninja,200,400,50);
		e.dibujarRectangulo(x, y, ancho, alto, angulo, color);
	}
	
	public void mover() {
		// TODO Auto-generated method stub
		x += velocidad * Math.cos(angulo);
		y += velocidad * Math.sin(angulo);
	}
	
	public void cambiarDeDireccion() {
		angulo += Math.PI/2;
	}
	
	public boolean chocasteConElEntorno(Entorno e) {
		return x <= alto / 2 || x >= e.ancho() - alto / 2 || 
				y <= ancho / 2 || y >= e.alto() - ancho / 2;
	}
	
	public boolean chocasteConUnRasengan(Rasengan rasengan) {
		int perimetro = (2 * ancho + 2 * alto);
		return rasengan.getX() <= perimetro || 
				perimetro <= rasengan.getX() + ancho; 
	}
}
