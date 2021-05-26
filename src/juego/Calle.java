package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Calle {

	private double x;
	private double y;
	private boolean tipo;
	private Image img1;
	private Image img2;
	
	public Calle(double x, double y,boolean tipo) {
		this.x = x;
		this.y = y;
		this.tipo = tipo;
		this.img1= Herramientas.cargarImagen("CALLE.png");
		this.img2= Herramientas.cargarImagen("CALLE2.png");
		
	}
	
	public void dibujar (Entorno e) {
		//vemos si la calle es horizontal o vertical
		if(tipo) { 
			e.dibujarImagen(this.img1,this.x ,this.y,0.0, 1.2);
		} else {
			e.dibujarImagen(this.img2,this.x,this.y, 0.0,1.3);
		}
	}
	
	
		
	
	
	
		
	
		
}

		


