package juego;
import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;


public class Sakura {

	    private double x;
	    private double y;
	    private double tamaño;
	    private double velocidad;
	    private Image imagenSakura;
	    private Image imagenSakuraArriba;
	    private Image imagenSakuraDerecha;
	    private Image imagenSakuraIzquierda;
	    private Image imagenSakuraAbajo;
	    
	    public Sakura (double x, double y, double tamaño, double velocidad, Color color) {
	        this.x=x;
	        this.y = y;
	        this.tamaño = tamaño;
	        this.velocidad = velocidad;
	        this.imagenSakura = Herramientas.cargarImagen("SakuraQuieta.png");
	        this.imagenSakuraArriba=Herramientas.cargarImagen("SakuraArriba.png");
	        this.imagenSakuraDerecha=Herramientas.cargarImagen("SakuraDer.png");
	        this.imagenSakuraIzquierda=Herramientas.cargarImagen("SakuraIzq.png");
	        this.imagenSakuraAbajo=Herramientas.cargarImagen("SakuraAbajo.png");
	    }
	    
	 


	    public void dibujar(Entorno e) {
//	       e.dibujarCirculo(x,y,tamaño, color);
    	

    		
    	if (e.estaPresionada(e.TECLA_ARRIBA)) 
			e.dibujarImagen(this.imagenSakuraArriba, this.x, this.y, 0.3);
    	
    	else if (e.estaPresionada(e.TECLA_DERECHA))	
			e.dibujarImagen(this.imagenSakuraDerecha, this.x, this.y, 0.3);
    	
    	else if (e.estaPresionada(e.TECLA_IZQUIERDA))
    		e.dibujarImagen(this.imagenSakuraIzquierda, this.x, this.y, 0.3);
    		
    	else if (e.estaPresionada(e.TECLA_ABAJO))
    		e.dibujarImagen(this.imagenSakuraAbajo, this.x, this.y, 0.3);
    	
    	else
    		e.dibujarImagen(imagenSakura,x,y,Math.PI*2);}
    	
	    
	     
    	
	    

	   
	   

	    
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


	public boolean colisionCalles(Calle c) {	
		  return  x < 400|| x >  200 ; 
	                
	    }
		
	}


	
	
	
	

