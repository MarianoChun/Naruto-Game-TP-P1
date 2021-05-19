package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Sakura {

	private double x;
	private double y;
	private double ancho;
	private double alto;
	private double velocidad;
	private Image imagenSakura;
	private Image imagenSakuraArriba;
	private Image imagenSakuraDerecha;
	private Image imagenSakuraIzquierda;
	private Image imagenSakuraAbajo;

	public Sakura(double x, double y, double velocidad, Color color) {
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.alto = 41;
		this.ancho = 28;
		this.imagenSakura = Herramientas.cargarImagen("SakuraQuieta.png");
		this.imagenSakuraArriba = Herramientas.cargarImagen("SakuraArriba.png");
		this.imagenSakuraDerecha = Herramientas.cargarImagen("SakuraDer.png");
		this.imagenSakuraIzquierda = Herramientas.cargarImagen("SakuraIzq.png");
		this.imagenSakuraAbajo = Herramientas.cargarImagen("SakuraAbajo.png");
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void dibujar(Entorno e) {
		if (e.estaPresionada(e.TECLA_ARRIBA))
			e.dibujarImagen(this.imagenSakuraArriba, this.x, this.y, -0.0);

		else if (e.estaPresionada(e.TECLA_DERECHA))
			e.dibujarImagen(this.imagenSakuraDerecha, this.x, this.y, 0.0);


		

		else if (e.estaPresionada(e.TECLA_IZQUIERDA))
			e.dibujarImagen(this.imagenSakuraIzquierda, this.x, this.y, 0.0);

		else if (e.estaPresionada(e.TECLA_ABAJO))
			e.dibujarImagen(this.imagenSakuraAbajo, this.x, this.y, 0.0);


		else
			e.dibujarImagen(imagenSakura, x, y, Math.PI * 2);
	}

//	public boolean chocasteConElEntorno(Entorno e) {
//		return x <= 0 || x + ancho >= e.ancho() || 
//				y <= 0 || y + alto >= e.alto();
//	}

	public void moverIzquierda() {
		if(x > 0) {
			if(y >= 212  && y <= 240|| y >= 62 && y <= 96 || y >= 335 && y <= 378|| y >= 482 && y <= 518 || 
					x >= 386 && x <= 420|| x >= 186 && x <= 220 || x >= 587 && x <= 620) {
			x -= velocidad;
			}
			
		}
		
	}
	

	public void moverDerecha() {
		if(x < 800) {
			if(y >= 212  && y <= 240|| y >= 62 && y <= 96 || y >= 335 && y <= 378|| y >= 482 && y <= 518 || 
					x >= 386 && x <= 420|| x >= 186 && x <= 220 || x >= 587 && x <= 620) {
				x += velocidad;
			}	
		
		}
	}
	


	public void moverAbajo() {
		if(y < 600) {
			if(x > 387 && x < 418|| x > 186 && x < 220 || x > 587 && x < 620) {
				y += velocidad;
			}
		}
	}

	public void moverArriba() {
		if(y > 0) {
			if(x > 387 && x < 418|| x > 186 && x < 220 || x > 587 && x < 620) {
				y -= velocidad;
			}
		}
	}

	

//	public boolean colisionCalles(Calle c) {
//		return x < 400 || x > 200;

	
	public boolean chocasteConNinja(Ninja n) {
		return Math.abs(y - n.getY()) < alto && Math.abs(x - n.getX()) < ancho;
	}
	
	
	
	
		
}
