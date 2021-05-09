package juego;


import java.awt.Color;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;

	
	private Sakura sakura;
	

//	private Ninja ninja;

	public Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this,  "Sakura Ikebana Delivery - Grupo 4 - v1", 800, 600);
		this.sakura = new Sakura (400,300,50,5,Color.BLUE);
		
				
		
		// Inicializar lo que haga falta para el juego
		// ...


		
		// Inicia el juego!
		this.entorno.iniciar();
//		this.sakura.dibujar(entorno);
		
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

		sakura.dibujar(entorno);
		
		
		if(sakura.chocasteConElEntorno(entorno)) {
			sakura.frenar(entorno);
		}
		if (entorno.estaPresionada('s')) {
			sakura.moverAbajo();
		}
		
		if (entorno.estaPresionada('a')) {
			sakura.moverIzquierda();
		}
		
		if (entorno.estaPresionada('d')) {
			sakura.moverDerecha();
		}
		
		if (entorno.estaPresionada('w')) {
			sakura.moverArriba();
		}
		
		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
