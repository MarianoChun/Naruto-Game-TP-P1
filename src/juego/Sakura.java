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
	    private double angulo;

	    public Sakura (double x, double y, double tamaño, Color color, double velocidad) {
	        this.x=x;
	        this.y = y;
	        this.tamaño = tamaño;
	        this.color = color;
	        this.velocidad = velocidad;
	        this.angulo = - Math.PI / 4;
	    }

	    public void dibujar(Entorno e) {
	 //       e.dibujarCirculo(x,y,tamaño, color);
	    	Image Sakura = Herramientas.cargarImagen("Sakura.png");
	    	e.dibujarImagen(Sakura,200,400,50);
	    }
	    public void mover() {
	        x += velocidad * Math.cos(angulo);
	        y += velocidad * Math.sin(angulo);
	    }
	    public boolean chocasteConElEntorno(Entorno e) {
	        return x < tamaño/2|| x > e.ancho() - tamaño/2  ||
	                y < tamaño/2;
	    }
	    public void cambiarDeDireccion() {
	        angulo += Math.PI/2;
	    }
	    public void acelerar() {
	        velocidad += 0.2;
	        
	        
	     
	    }



	}
	
	
	

