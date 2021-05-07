package juego;

import java.awt.Color;
//import java.awt.Image;
//
//import javax.swing.ImageIcon;

import entorno.Entorno;

public class Ninja {
	private double x;
	private double y;
	private double size;
	private double angulo;
	private Color color;
	private double velocidad;
	
	public Ninja(double x, double y, Color color, double velocidad) {
		this.x = x;
		this.y = y;
		this.size = 50;
		this.color = color;
		this.velocidad = velocidad;
		this.angulo = -Math.PI/2;
	}
	
	public void dibujar(Entorno e) {
		//Image ninja = new Image("ninja.png");
		e.dibujarCirculo(x,y,size,color);
		//e.dibujarImagen(ninja,100,50,50);
		
	}
	
	public void mover() {
		// TODO Auto-generated method stub
		x += velocidad * Math.cos(angulo);
		y += velocidad * Math.sin(angulo);
	}
}
