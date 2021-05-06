package juego;
import java.awt.Color;

import java.awt.Color;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;

	
	private Sakura sakura;
	

	private Ninja ninja;

	public Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this,  "Sakura Ikebana Delivery - Grupo 4 - v1", 800, 600);
		this.ninja = new Ninja(100,200,Color.CYAN,2);
		// Inicializar lo que haga falta para el juego
		// ...

		sakura= new Sakura (entorno.ancho()/2,entorno.alto()/2,50,Color.BLUE,1);
		// Inicia el juego!
		this.entorno.iniciar();
		sakura.dibujar(entorno);
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick() {
		// Procesamiento de un instante de tiempo
		// ...

//		sakura.dibujar(entorno);
	//	sakura.mover();
		ninja.dibujar(entorno);
		ninja.mover();

	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
