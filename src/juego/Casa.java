package juego;


import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Casa {
	private double x;
	private double y;
	private Image img1;

	

	public Casa(double x, double y) {
		this.x = x;
		this.y = y;
		this.img1= Herramientas.cargarImagen("casas.png");
	}
	
	public void dibujar (Entorno e) {
		e.dibujarImagen(this.img1,this.x,this.y,0);		
	}

}
