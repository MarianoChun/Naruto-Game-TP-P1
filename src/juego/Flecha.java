package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Flecha {
	private double x;
	private double y;
	private Image flechaSakura;
	private Image flechaNaruto;
	public Flecha(double x, double y) {	
		this.x = x;
		this.y = y;
		this.flechaSakura = Herramientas.cargarImagen("FlechaSakura.png");
		this.flechaNaruto = Herramientas.cargarImagen("FlechaNaruto.png");
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void dibujar(Entorno e, boolean tipo) { // Si tipo es true, flechaSakura. Si tipo es false, flechaNaruto
		if(tipo == true) {
		e.dibujarImagen(this.flechaSakura, this.x, this.y, 0.0);
		} else if(tipo == false) {
			e.dibujarImagen(this.flechaNaruto, this.x, this.y, 0.0);
		}
	}
}
