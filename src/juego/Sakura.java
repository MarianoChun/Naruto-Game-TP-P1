package juego;
import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;


public class Sakura {

	    private double x;
	    private double y;
	    private double tamaño;
	    private Color color;
	    private double velocidad;
	    private Image imagenSakura;
	    

	    public Sakura (double x, double y, double tamaño, double velocidad, Color color) {
	        this.x=x;
	        this.y = y;
	        this.tamaño = tamaño;
	        this.color = color;
	        this.velocidad = velocidad;
	        this.imagenSakura = Herramientas.cargarImagen("Sakura.png");
	    }
	    
	 

	    public void dibujar(Entorno e) {
//	       e.dibujarCirculo(x,y,tamaño, color);
    	
    	e.dibujarImagen(imagenSakura,400,300,Math.PI*2);
	    }
	   
	    
	    public boolean chocasteConElEntorno(Entorno e) {
	        return x < tamaño/2|| x > e.ancho() - tamaño/2  ||
	                y < tamaño/2 || y>e.alto() - tamaño/2;
	    }
	   
	       
	    
//	    public void acelerar() {
//	        velocidad += 0.2;
//	    }
	    
	 public void moverIzquierda() {
		 x -= velocidad;
	 
	   }
	   
		public void moverDerecha() {
			x+=velocidad;
			
			
		}

		public void setVelocidad(int v) {
		velocidad= v;
			
		}

		public void moverAbajo() {
			y +=velocidad;
			
		}

		public void moverArriba() {
			y -=velocidad;
			
		}


//	public boolean volverAPantalla(Entorno e) {	
//		if (x > 800 || x> e.ancho()){
//			return false;
//		}
//			return false;   
//			 
//		}

}

	
	
	
	

