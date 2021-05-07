package juego;

import java.awt.Color;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Ninja ninja1;
	private Rasengan rasengan;
	boolean vivo = true;
	public Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo 4 - v1", 800, 600);
		this.ninja1 = new Ninja(100, 400, 2, Math.PI / 2, Color.RED);
		this.rasengan = new Rasengan(100,0,Math.PI/2);
		
		
		// Inicializar lo que haga falta para el juego
		// ...

		// Inicia el juego!
		this.entorno.iniciar();
		// ninja1.dibujar(entorno);
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */
	public void tick() {
		// Procesamiento de un instante de tiempo
		// ...
		
		if(vivo) {
		ninja1.dibujar(entorno);
		ninja1.mover();
		}
		rasengan.dibujar(entorno);
		rasengan.mover();
		
		if (ninja1.chocasteConElEntorno(entorno)) {
			ninja1.cambiarDeDireccion();
		}
		
		if (ninja1.chocasteConUnRasengan(rasengan)) {
			//vivo = false;
			System.out.println("Choca");
		}
		
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
