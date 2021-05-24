package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Rasengan {
	private double x;
	private double y;
	private double tamaño;
	private double angulo;
	private double velocidad;
	private Image rasengan;

	public Rasengan(double x, double y, double angulo) {
		this.x = x;
		this.y = y;
		this.tamaño = 20;
		this.angulo = angulo;
		this.velocidad = 4;
		this.rasengan = Herramientas.cargarImagen("rasengan.png");
	}
	

	public double getTamaño() {
		return tamaño;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void dibujar(Entorno e) {
		e.dibujarImagen(rasengan, x, y, angulo);
	}

	public void mover() {
		// TODO Auto-generated method stub
		x += velocidad * Math.cos(angulo);
		y += velocidad * Math.sin(angulo);
	}

	public boolean chocasteConElEntorno(Entorno e) {
		return x < tamaño / 2 || x > e.ancho() - tamaño / 2 || y < tamaño / 2 || y > e.alto() - tamaño / 2;
	}
	
	public boolean chocasteConNinja(Ninja n) {
		return Math.sqrt(Math.pow(x - n.getX(), 2) + Math.pow(y - n.getY(), 2)) < tamaño;
	}
}
