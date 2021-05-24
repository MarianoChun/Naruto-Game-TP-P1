package juego;


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
	

	public Sakura(double x, double y, double velocidad) {
		this.x = x;
		this.y = y;
		this.imagenSakura = Herramientas.cargarImagen("SakuraQuieta.png");
		this.imagenSakuraArriba = Herramientas.cargarImagen("SakuraArriba.png");
		this.imagenSakuraDerecha = Herramientas.cargarImagen("SakuraDer.png");
		this.imagenSakuraIzquierda = Herramientas.cargarImagen("SakuraIzq.png");
		this.imagenSakuraAbajo = Herramientas.cargarImagen("SakuraAbajo.png");
		this.velocidad = velocidad;
		this.alto = imagenSakura.getHeight(null);
		this.ancho = imagenSakura.getWidth(null);
		
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
		if (x > 0) {
			if (y > 57 && y < 97 ||y > 205 && y < 240 ||y > 335 && y < 380 || y > 482 && y < 518) {// Si esta en una interseccion
				x -= velocidad;
			} else { // Si no se esta en una interseccion, es decir, se esta en las entrecalles
				if (x > 186 && x < 228||x > 384 && x < 426||x > 587) {
					x -= velocidad;
				} 
			}
		}

	}
		
	
	

	public void moverDerecha() {
		if(x < 800) {
			if(y > 57 && y < 97 ||y > 205 && y < 240 ||y > 335 && y < 380 || y > 482 && y < 518) { // Si esta en una interseccion
				x += velocidad;
			} else { // Si no se esta en una interseccion, es decir, se esta en las entrecalles
				if(x < 224 ||x > 382 && x < 424||x > 584 && x < 620) { // Esta entrecalles
					x += velocidad;
				}
			}
		}
	}

	public void moverAbajo() {
		if(y < 600) {
			if(x > 184 && x < 227 ||x > 383 && x < 425|| x > 585 && x < 621) { // Si esta entrecalles
				y += velocidad;
			} else {
				if(y < 96 || y > 196 && y < 238|| y > 338 &&y < 378|| y > 482 && y < 516) { // Si se esta en una interseccion
					y += velocidad;
				}
			}

		}
	}

	public void moverArriba() {
		if(y > 0) {
			if(x > 184 && x < 227 ||x > 383 && x < 425|| x > 585 && x < 621) { // Si esta entrecalles
				y -= velocidad;
			} else {
				if(y > 58 && y < 98||y > 206 && y < 240|| y > 342 && y < 380|| y > 486) { // Si se esta en una interseccion
					y -= velocidad;
				}
			}
		}
	}
		
			

	

//	public boolean colisionCalles(Calle c) {
//		return x < 400 || x > 200;

	
	public boolean chocasteConNinja(Ninja n) {
		return Math.abs(y - n.getY()) < alto && Math.abs(x - n.getX()) < ancho;
	}
	
	public boolean enCasaMarcada(Flecha f) {
		return Math.abs(y - f.getY() - 45) < alto && Math.abs(x - f.getX() - 45) < ancho
				||Math.abs(y - f.getY() + 50) < alto && Math.abs(x - f.getX() + 50) < ancho;
	}
	
	public boolean enFloreria(Floreria f) {
		return Math.abs(y - f.getY() - 45) < alto && Math.abs(x - f.getX() - 45) < ancho
				||Math.abs(y - f.getY() + 50) < alto && Math.abs(x - f.getX() + 50) < ancho;
	}
	public boolean tocasteMoneda(Moneda m) {
		return Math.abs(y - m.getY()) < alto && Math.abs(x - m.getX()) < ancho;
	}
	
		
}
