package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class RamoFlores {
	double x;
	double y;
	Image imagenRamo;
	
	public RamoFlores(double x,double y){
		this.x = x;
		this.y = y;	
		imagenRamo = Herramientas.cargarImagen("flores.png");
	}
	
	public void dibujar(Entorno e) {
		e.dibujarImagen(imagenRamo, x, y, 0);
	}
}
