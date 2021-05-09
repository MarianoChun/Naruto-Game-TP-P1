package juego;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import entorno.Entorno;
import entorno.Herramientas;

public class Ninja {
	private double x;
	private double y;
	private double tamaño;
	private double angulo;
	private double velocidad;
	private Color color;
	
	public Ninja(double x, double y, double velocidad, double angulo, Color color) {
		this.x = x;
		this.y = y;
		this.tamaño = 50;
		this.velocidad = velocidad;
		this.angulo = angulo;
		this.color = color;
	}
	

	public void dibujar(Entorno e) {
//		Image ninja = Herramientas.cargarImagen("ninja.png");
//		e.dibujarImagen(ninja,200,400,50);
		e.dibujarCirculo(x, y, tamaño, color);
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
		return x < tamaño/2|| x > e.ancho() - tamaño/2 ||
				y < tamaño/2 || y > e.alto() -tamaño/2;
	}
	
	public boolean chocasteConUnRasengan(Rasengan rasengan) {
		double distancia = Math.sqrt(Math.pow(rasengan.getX() - x, 2 + Math.pow(rasengan.getY() - y, 2)));
		return tamaño + rasengan.getTamaño() > distancia;
	}
}
