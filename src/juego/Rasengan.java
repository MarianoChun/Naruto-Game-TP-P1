package juego;

import java.awt.Color;
import entorno.Entorno;

public class Rasengan {
	private double x;
	private double y;
	private double tamaño;
	private double angulo;
	private double velocidad;
	private Color color;

	public Rasengan(double x, double y, double angulo) {
		this.x = x;
		this.y = y;
		this.tamaño = 20;
		this.angulo = angulo;
		this.velocidad = 3;
		this.color = Color.BLUE;
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
		e.dibujarCirculo(x, y, tamaño, color);
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
		return n.getX() - n.getAncho() / 2 < x && 
				x < n.getX() + n.getAncho()/2 &&
				y + tamaño/2 > n.getY() - n.getAlto()/2;
	}
}
