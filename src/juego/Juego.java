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
	private Casa casas[];
	private int posicionescasas [][];
	private int posicionesNinjas[][];
//	private Sakura sakuraizquierda;
	double clockCasero = 1;
	private Image fondo;
	private int puntaje;
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
		}
		
		
//		casas = new Casa [8];
//		int posXPrimercasa = 0;
//		int posYPrimercasa = 20;
//		
//
////		int [][] posiciones = {{50,130},{250,320},{450,530},{680,760}};
//		posicionescasas = new int [5][4];
//
//		//int [][] posicionescasas = {{50,130},{250,320},{450,530},{680,760}};
//		for(int i = 0; i < posicionescasas.length;i++) {
//			for(int j = 0; j< posicionescasas[i].length; j++) {
//				if(casas[i] = new Casa(posXPrimercasa,posYPrimercasa,50,40,0,Color.blue)) {
//				}else{posXPrimercasa = posXPrimercasa + 20;
//				casas[i] = new Casa(posXPrimercasa,posYPrimercasa,50,60,0,Color.magenta);}
//			}
//			int posXPrimercasa1 = posXPrimercasa;
//			int posYPrimercasa1 = posYPrimercasa + 150;
//			casas[i] = new Casa(posXPrimercasa1,posYPrimercasa,50,40,0,Color.gray);
//		}
//		
		

		
		//int nfilas,ncolumnas;
//		int filas = 5, columnas = 4;
//		int i,j;
//		for (i = 0; i < filas; i++) {
//      for (j = 0; j < columnas; j++) {
//      	posicionescasas[i][j]= posiciones.length;
//      }
//	}		
		
//		int casaX=50;
//		int casaY=20;
//		for (int i = 0; i < casas.length;i++) {
//			if(i==0) {
//				casas[i]= new Casa(casaX,casaY,50,40,0,Color.MAGENTA);
//			}
//			if(i==1) {
//				casaX = 130;
//				casaY=20;
//				casas[i] = new Casa(casaX,casaY,50,60,0,Color.blue);
//			}
//			if(i==2) {
//				casaX = 250;
//				casaY = 20;
//				casas[i] = new Casa(casaX,casaY,50,40,0,Color.magenta);
//			}
//			if(i==3) {
//				casaX = 320;
//				casaY = 20;
//				casas[i] = new Casa(casaX,casaY,50,60,0,Color.blue);
//			}
//			if(i==4) {
//				casaX = 450;
//				casaY = 20;
//				casas[i] = new Casa(casaX,casaY,50,40,0,Color.magenta);
//			}
//			if(i==5) {
//				casaX = 530;
//				casaY = 20;
//				casas[i] = new Casa(casaX,casaY,50,60,0,Color.blue);
//			}
//			if(i==6) {
//				casaX = 680;
//				casaY = 20;
//				casas[i] = new Casa(casaX,casaY,50,60,0,Color.magenta);
//			}
//			if(i==7) {
//				casaX = 760;
//				casaY = 20;
//				casas[i] = new Casa(casaX,casaY,50,60,0,Color.blue);
//			}
		
		


		
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
		
		for(int i = 0; i < posicionescasas.length;i++) {
			casas[i].dibujar(entorno);
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

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
