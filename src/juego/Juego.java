package juego;


import java.awt.Color;
import java.awt.Image;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
//	private Rasengan rasengan;
	private Rasengan rasengan[];
	private Calle calle;
	private Calle calle1;
	private Calle calle2;
	private Calle calle3;
	private Calle calle4;
	private Calle calle5;
	private Calle calle6;
	private Ninja ninjas[];
	private Sakura sakura;
	private Casa casas[][];
	private int posicionescasas [][];
	private int posicionesNinjas[][];
//	private Sakura sakuraizquierda;
	private boolean perdido = false;
	private int clockCasero[];

	private Image fondo;
	private int puntaje;
	private int ninjasEnJuego;
	private int ninjasEliminados;
	public Juego() {
		// Inicializa el objeto entorno

		this.entorno = new Entorno(this,  "Sakura Ikebana Delivery - Grupo 4 - v1", 800, 600);
		
//		this.sakuraizquierda = new Sakura()
				
		

	
		
		   
		
		                                       

		// Inicializar lo que haga falta para el juego
		// ...
		
		rasengan = new Rasengan[1];
		sakura = new Sakura (400,300,2,Color.BLUE);		
		fondo = Herramientas.cargarImagen("fondoJuego.png");

		// Horizontales
		calle = new Calle(400,90, 800,50,0,true);
		calle1 = new Calle(400,230, 800,50,0, true); 
		calle2 = new Calle(400,370, 800,50,0, true);
		calle3 = new Calle(400,510, 800,50,0, true);
		
		// Verticales

		calle4 = new Calle(200,100, 50,1000,0, false);
		calle5 = new Calle(400,100, 50,1000,0, false);
		calle6 = new Calle(600,100, 50,1000,0, false);


		// Ninjas

           
		ninjas = new Ninja[5];
		clockCasero = new int[5];
		posicionesNinjas = new int[5][2];
		// Ninja[0]
		posicionesNinjas[0][0] = 200;
		posicionesNinjas[0][1] = 570;
		// Ninja[1]
		posicionesNinjas[1][0] = 600;
		posicionesNinjas[1][1] = 25;
		// Ninja[2]
		posicionesNinjas[2][0] = 30;
		posicionesNinjas[2][1] = 90;
		// Ninja[3]
		posicionesNinjas[3][0] = 770;
		posicionesNinjas[3][1] = 370;
		// Ninja[4]
		posicionesNinjas[4][0] = 30;
		posicionesNinjas[4][1] = 510;
		// Se toma como primera posicion a las coordenadas de la primer calle vertical.
		// ninja[0] de abajo hacia arrriba, calle vertical izquierda
		// ninja[1] de arriba hacia abajo, calle vertical derecha
		// ninja[2] de izq a der, calle horizontal superior primera
		// ninja[3] de der a izq, calle horizontal inferior segunda
		// ninja[4] de iz a der, calle horizontal inferior primera		
		for (int i = 0; i < ninjas.length;i++) {
			if(i == 0) {
				ninjas[i] = new Ninja(posicionesNinjas[0][0],posicionesNinjas[0][1]);
			}
			if(i == 1) {
				ninjas[i] = new Ninja(posicionesNinjas[1][0],posicionesNinjas[1][1]);
			}
			if(i == 2) {
				ninjas[i] = new Ninja(posicionesNinjas[2][0],posicionesNinjas[2][1]);
			}
			if(i == 3) {
				ninjas[i] = new Ninja(posicionesNinjas[3][0],posicionesNinjas[3][1]);
			}
			if(i == 4) {
					ninjas[i] = new Ninja(posicionesNinjas[4][0],posicionesNinjas[4][1]);
				}

			clockCasero[i] = 0;
			ninjasEnJuego ++;

		}
		
		casas = new Casa[8][5];
		int[] posXCasas = {50,130,270,340,470,540,680,760};
		int[] posYCasas = {20,160,300,440,580};
		// Llenar array pos casas, for doble
		for(int i = 0;i< posXCasas.length ;i++) {
			for(int j = 0;j<posYCasas.length;j++) {
				casas[i][j] = new Casa(posXCasas[i],posYCasas[j],50,50,0.0,Color.BLUE);
			}
		}

		


		
		// Inicia el juego!

		this.entorno.iniciar();

//		this.sakura.dibujar(entorno);
		

		// ninja1.dibujar(entorno);
	
		
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */

	public void tick() {
		if(!perdido) {
		//System.out.println(ninjasEnJuego);
		

		// Procesamiento de un instante de tiempo
		// ...

		entorno.dibujarImagen(fondo,entorno.ancho()/2, entorno.alto()/2, Math.PI*2);
		//dibujo las calles
		calle.dibujar(entorno);
		calle1.dibujar(entorno);
		calle2.dibujar(entorno);
		calle3.dibujar(entorno);
		calle4.dibujar(entorno);
		calle5.dibujar(entorno);
		calle6.dibujar(entorno);	
		
		sakura.dibujar(entorno);
		
		
	//	System.out.println(ninjas[0].getAlto() +" "+ ninjas[0].getAncho());
		
		for(int i = 0; i < casas.length;i++) {
			for(int j = 0; j < casas[0].length;j++) {
				casas[i][j].dibujar(entorno);
			}
		}

		
		
		//casa.dibujar(entorno);
		//casa1.dibujar(entorno);
		
		sakura.dibujar(entorno);	
		//ninja1.dibujar(entorno);
		

		// Dibujo array ninja
		for(int i = 0; i < ninjas.length; i++) {
			if(ninjas[i] != null) {
				ninjas[i].dibujar(entorno);
			}
		}
		sakura.dibujar(entorno);


//		sakuraizquierda.dibujar(entorno);

		// Movimiento Ninjas
		
		// ninja[0] de abajo hacia arrriba, calle vertical izquierda
		// ninja[1] de arriba hacia abajo, calle vertical derecha
		// ninja[2] de izq a der, calle horizontal superior primera
		// ninja[3] de der a izq, calle horizontal inferior segunda
		// ninja[4] de iz a der, calle horizontal inferior primera
		
		for(int i = 0;i < ninjas.length;i++) {
			if(i == 0) {
				if(ninjas[i] != null) {
					ninjas[i].mover(Math.PI/2);
				}
			}
			if(i == 1) {
				if(ninjas[i] != null) {
				ninjas[i].mover(-Math.PI/2);
				}
			}
			if(i == 2) {
				if(ninjas[i] != null) {
					ninjas[i].mover(0.0);
				}
			}
			if(i == 3) {
				if(ninjas[i] != null) {
					ninjas[i].mover(Math.PI);
				}
			}
			if(i == 4) {
				if(ninjas[i] != null) {
					ninjas[i].mover(0.0);
				}
			}
		}

		// Aparicion ninja luego de chocar con el entorno
		for(int i = 0;i < ninjas.length;i++) {
			if(ninjas[i] != null) {
				if(ninjas[i].chocasteConElEntorno(entorno)) {
					ninjas[i] = null; // Eliminamos al ninja anterior y luego inicializamos otro nuevo en la posicion inicial
					if(i == 0) {
						ninjas[i] = new Ninja(posicionesNinjas[0][0],posicionesNinjas[0][1]);
					}
					if(i == 1) {
						ninjas[i] = new Ninja(posicionesNinjas[1][0],posicionesNinjas[1][1]);
					}
					if(i == 2) {
						ninjas[i] = new Ninja(posicionesNinjas[2][0],posicionesNinjas[2][1]);
					}
					if(i == 3) {
						ninjas[i] = new Ninja(posicionesNinjas[3][0],posicionesNinjas[3][1]);
					}
					if(i == 4) {
						ninjas[i] = new Ninja(posicionesNinjas[4][0],posicionesNinjas[4][1]);
						}
				}
			}
				

			if (ninjas[i] == null && clockCasero[i] > 500 ||ninjas[i] == null && ninjasEnJuego < 4) { // Comprueba si hay algun ninja eliminado y cada cierto tiempo hace que //
				if (ninjas[i] == null) { // Comprueba si hay algun ninja eliminado y cada cierto tiempo hace que //
					// reaparezcan
					if (i == 0) {
						ninjas[i] = new Ninja(posicionesNinjas[0][0], posicionesNinjas[0][1]);
					}
					if (i == 1) {
						ninjas[i] = new Ninja(posicionesNinjas[1][0], posicionesNinjas[1][1]);
					}
					if (i == 2) {
						ninjas[i] = new Ninja(posicionesNinjas[2][0], posicionesNinjas[2][1]);
					}
					if (i == 3) {
						ninjas[i] = new Ninja(posicionesNinjas[3][0], posicionesNinjas[3][1]);
					}
					if (i == 4) {
						ninjas[i] = new Ninja(posicionesNinjas[4][0], posicionesNinjas[4][1]);
					}

					clockCasero[i] = 0;
					ninjasEnJuego++;
				}
			

		}
		}
	
		if (entorno.estaPresionada(entorno.TECLA_ABAJO)) {
			sakura.moverAbajo();
		}
		
		else if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			sakura.moverIzquierda();
		}
		
		else if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			sakura.moverDerecha();
		}
		
		else if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
			sakura.moverArriba();
		
		}
		// Lanzamiento Rasengan
		if(entorno.sePresiono(entorno.TECLA_ESPACIO) && entorno.estaPresionada(entorno.TECLA_ABAJO)) { // Dispara el rasengan en la direccion a la que mira el jugador
			if(rasengan[0] == null) { // Si hay rasengan, no dibuja otro
			rasengan[0] = new Rasengan(sakura.getX(),sakura.getY(),Math.PI/2); // Obtenemos la posicion de sakura y disparamos al angulo al que esta mirando
			}
		}
		else if(entorno.sePresiono(entorno.TECLA_ESPACIO) && entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			if(rasengan[0] == null) {
			rasengan[0] = new Rasengan(sakura.getX(),sakura.getY(),Math.PI);
			}
		}
		else if(entorno.sePresiono(entorno.TECLA_ESPACIO) && entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			if(rasengan[0] == null) {
			rasengan[0] = new Rasengan(sakura.getX(),sakura.getY(),Math.PI*2);
			}
		}
		else if(entorno.sePresiono(entorno.TECLA_ESPACIO) && entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
			if(rasengan[0] == null) {
			rasengan[0] = new Rasengan(sakura.getX(),sakura.getY(),-Math.PI/2);
			}
		}
		else if(entorno.sePresiono(entorno.TECLA_ESPACIO)) {
			if(rasengan[0] == null) {
			rasengan[0] = new Rasengan(sakura.getX(),sakura.getY(),Math.PI/2);
			}
		}
		
		for(int i = 0; i < ninjas.length;i++) { // Si hay rasengan y choca con algun ninja, eliminamos el rasengan.
			if(rasengan[0] != null) {
				if(ninjas[i] != null && rasengan[0].chocasteConNinja(ninjas[i])) {
					rasengan[0] = null;
					ninjas[i] = null;

					clockCasero[i] = 0;
					ninjasEnJuego--;
					puntaje = puntaje + 5;
					ninjasEliminados++;
				}
			}
		}
		
		if(rasengan[0] != null && rasengan[0].chocasteConElEntorno(entorno)) { // Si hay rasengan y choca con el entorno, eliminamos el rasengan.
			rasengan[0] = null;
		}
		if (rasengan[0] != null && !rasengan[0].chocasteConElEntorno(entorno)){ // Si hay rasengan y no choca con el entorno, lo dibujamos y movemos.
			rasengan[0].dibujar(entorno);
			rasengan[0].mover();
		}
		
		for(int i = 0; i < ninjas.length;i++) { // Si choca con algun ninja, perdemos.
			if(ninjas[i] != null) {
				if( sakura.chocasteConNinja(ninjas[i])) {
					System.out.println("Perdiste");
					//perdido = true;
				}
			}
		}
		

//		if(rasenganActivado) {
//			rasengan.dibujar(entorno);
//			rasengan.mover();
//		}
//		if (ninja1.chocasteConElEntorno(entorno)) {
//			ninja1.cambiarDeDireccion();
//		}
		
//		if (ninja1.chocasteConUnRasengan(rasengan)) {
//			//vivo = false;
//			System.out.println("Choca");
//		}
	
		
		


	//	sakura.dibujar(entorno);
	//	sakura.mover();

		entorno.cambiarFont("Verdana", 17, Color.GREEN);
		entorno.escribirTexto("Puntaje: " + puntaje, 690, 15);
		entorno.escribirTexto("Ninjas eliminados: " + ninjasEliminados, 10, 15);
		entorno.escribirTexto("X= " + sakura.getX(), 690, 30);
		entorno.escribirTexto("Y= " + sakura.getY(), 690, 50);
		} else {
		entorno.cambiarFont("Arial", 30, Color.RED);
		entorno.escribirTexto("Perdiste", 300, 300);
		}

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
