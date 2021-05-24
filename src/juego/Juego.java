package juego;


import java.awt.Color;
import java.awt.Image;
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
	private Moneda monedas[][];
	private Floreria floreria;
	private int posXMonedas[] = {202,402,602};
	private int posYMonedas[] = {84,226,362,498};
	private int posicionesNinjas[][];
	private int pedidoX;
	private int pedidoY;
	private int posXCasas[] = {50,130,270,340,470,540,680,760};
	private int posYCasas[] = {30,160,300,440,570};
	private boolean entregaHecha = true;
	private boolean ikebanaBuscado = false;
	private int posXFlecha;
	private int posYFlecha;
//	private Sakura sakuraizquierda;
	private boolean perdido = false;
	private int clockCasero[];
	private Flecha flecha;
	private Image fondo;
	private Image fondoMenu;
	private int puntaje;
	private int tiempo;
	private int ninjasEnJuego;
	private int ninjasEliminados;
	private boolean ganar = false;
	private String dificultad = "Principiante";
	private Image gameover;
	private Image ganaste;
	private boolean unJugador = false;
	private boolean dosJugadores = false;
	//private int dificultad; //0=facil, 1=normal, 2=dificil, 4=experto
	//private Jugadores[] jugadores;
	
	
	public Juego() {
		// Inicializa el objeto entorno

		this.entorno = new Entorno(this,  "Sakura Ikebana Delivery - Grupo 4 - v1", 800, 600);
		
//		this.sakuraizquierda = new Sakura()
				
		// Menu
		fondoMenu = Herramientas.cargarImagen("fondoMenu.png");
		

	
		
		   
		
		                                       

		// Inicializar lo que haga falta para el juego
		// ...
		
		rasengan = new Rasengan[1];
		sakura = new Sakura (400,300,2,Color.BLUE);		
		fondo = Herramientas.cargarImagen("fondoJuego.png");
		gameover = Herramientas.cargarImagen("gameover.jpg");
		ganaste = Herramientas.cargarImagen("ganaste.png");
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

           
		ninjas = new Ninja[6];
		clockCasero = new int[6];
		posicionesNinjas = new int[6][2];
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
		// Ninja[5]
		posicionesNinjas[5][0] = 404;
		posicionesNinjas[5][1] = 25;
		// Se toma como primera posicion a las coordenadas de la primer calle vertical.
		// ninja[0] de abajo hacia arrriba, calle vertical izquierda
		// ninja[1] de arriba hacia abajo, calle vertical derecha
		// ninja[2] de izq a der, calle horizontal superior primera
		// ninja[3] de der a izq, calle horizontal inferior segunda
		// ninja[4] de iz a der, calle horizontal inferior primera
		// ninja[5] de arriba hacia abajo, calle vertical central
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
			if(i == 5) {
				ninjas[i] = new Ninja(posicionesNinjas[5][0],posicionesNinjas[5][1]);
			}

			clockCasero[i] = 0;
			ninjasEnJuego ++;

		}
		// Inicializamos el array de casas
		casas = new Casa[8][5];
		for(int i = 0;i< posXCasas.length ;i++) {
			for(int j = 0;j<posYCasas.length;j++) {
				casas[i][j] = new Casa(posXCasas[i],posYCasas[j]);
				//System.out.println("Casa " +posXCasas[i] +" "+ posYCasas[j]);
			}
		}
		
		// Inicializamos la floreria
		floreria = new Floreria(470,440);
		
		// Inicializamos el array de monedas
		monedas = new Moneda[3][4];
		for(int i = 0;i< posXMonedas.length ;i++) {
			for(int j = 0; j<posYMonedas.length;j++) {
				monedas[i][j] = new Moneda(posXMonedas[i],posYMonedas[j]);
				
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
		entorno.dibujarImagen(fondoMenu, entorno.ancho() / 2, entorno.alto() / 2, Math.PI * 2);
		entorno.cambiarFont("Rockwell", 25, Color.GRAY);
		entorno.escribirTexto("Presione '1' para jugar con un jugador", 200, 300);
		entorno.escribirTexto("Presione '2' para jugar con dos jugadores", 200, 300 + 30);
		if(entorno.sePresiono('1')) {
			unJugador = true;
		} else if(entorno.sePresiono('2')) {
			dosJugadores = true;
		}
		
		// Juego de un jugador
		if (!perdido && !ganar && unJugador) {
			// System.out.println(ninjasEnJuego);
			tiempo++;

			// Procesamiento de un instante de tiempo
			// ...

			entorno.dibujarImagen(fondo, entorno.ancho() / 2, entorno.alto() / 2, Math.PI * 2);

			// dibujo las calles
			calle.dibujar(entorno);
			calle1.dibujar(entorno);
			calle2.dibujar(entorno);
			calle3.dibujar(entorno);
			calle4.dibujar(entorno);
			calle5.dibujar(entorno);
			calle6.dibujar(entorno);

			sakura.dibujar(entorno);

			// System.out.println(ninjas[0].getAlto() +" "+ ninjas[0].getAncho());
			// Determinamos la dificultad
			
			// Se agrega el AND dificultad != Experto para que la dificultad no cambie si estamos en experto.
			// Esto se debe a que si tenemos un tiempo mayor a 1000 y no llegamos a los 50 puntos, al llegar, la dificultad
			// No vuelva a intermedia.
			if (puntaje >= 50 && puntaje < 100 && dificultad != "Experto"|| tiempo >= 500 && tiempo < 1000) {
				dificultad = "Intermedio";
			} else if (puntaje >= 100 || tiempo >= 1000) {
				dificultad = "Experto";
			}

		// Dibujamos las casas
		for(int i = 0; i < casas.length;i++) {
			for(int j = 0; j < casas[0].length;j++) {
				if(i != 3 || j != 2) { // No dibuja en la posicion que iria la floreria (x = 470,y = 440)
					casas[i][j].dibujar(entorno);
				}
			}
		}
		
		// Dibujamos la floreria
		
		floreria.dibujar(entorno);
		
		// Dibujamos las monedas
		for(int i = 0; i < monedas.length;i++) {
			for(int j = 0; j < monedas[0].length;j++) {
				if(monedas[i][j] != null) {
					monedas[i][j].dibujar(entorno);
				}
			}
		}
		

		
		//	Flecha
		if(entregaHecha && ikebanaBuscado) {
			pedidoX = (int)Math.floor(Math.random()*casas.length);  // Nos arroja una posicion aleatoria para x e y correspondiente a una casa
			pedidoY = (int)Math.floor(Math.random()*casas[0].length);
			
			System.out.println(pedidoX +" "+pedidoY);
			
			posXFlecha = posXCasas[pedidoX]; // Asignamos a una variable la posicion aleatoria
			posYFlecha = posYCasas[pedidoY];
			System.out.println(posXFlecha + " " + posYFlecha);
			flecha = new Flecha(posXFlecha,posYFlecha); // Creamos la flecha sobre la casa aleatoria
			entregaHecha = false;
			ikebanaBuscado = false;
		}
		
		// Determina si el Ikebana fue buscado
		
		if(entregaHecha && !ikebanaBuscado) {
			flecha = new Flecha(floreria.getX(),floreria.getY());
			if(sakura.enFloreria(floreria)) {
				ikebanaBuscado = true;
			}
			
		}
		
		if(sakura.enCasaMarcada(flecha) && !ikebanaBuscado) { // Realizó la entrega y verifica que no sea la floreria
			entregaHecha = true;
			puntaje = puntaje + 5;
		}
		flecha.dibujar(entorno);
		

		// Dibujo array ninja
		for(int i = 0; i < ninjas.length; i++) {
			if(ninjas[i] != null) {
				ninjas[i].dibujar(entorno);
			} else {
				clockCasero[i]++;
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
		// ninja[5] de arriba hacia abajo, calle vertical central
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
			if(i == 5) {
				if(ninjas[i] != null) {
					ninjas[i].mover(-Math.PI/2);
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
					if(i == 5) {
						ninjas[i] = new Ninja(posicionesNinjas[5][0],posicionesNinjas[5][1]);
						}
					
				}
			}
//			System.out.println(ninjasEnJuego);
//			System.out.println(clockCasero[i]);
			if (ninjas[i] == null && clockCasero[i] > 600 ||ninjas[i] == null && ninjasEnJuego < 4) { 
				
				if (ninjas[i] == null) { // Comprueba si hay algun ninja eliminado y cada cierto tiempo hace que
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
					if(i == 5) {
						ninjas[i] = new Ninja(posicionesNinjas[5][0],posicionesNinjas[5][1]);
						}

						clockCasero[i] = 0;
						if (ninjasEnJuego < ninjas.length) {
							ninjasEnJuego++;
						}

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
		
		for(int i = 0; i < monedas.length;i++) {
			for(int j = 0; j < monedas[0].length;j++) {
				if(monedas[i][j] != null && sakura.tocasteMoneda(monedas[i][j])) {
					monedas[i][j] = null;
					puntaje += 10;
				}
			}
		}
	
		for(int i = 0; i < ninjas.length;i++) { // Si choca con algun ninja, perdemos.
			if(ninjas[i] != null) {
				if( sakura.chocasteConNinja(ninjas[i])) {
					//perdido = true;
				}
			}
		}
		
		// Ganar el juego
		if(puntaje >= 1000 || tiempo == 3000) {
			ganar = true;
		}

		// Datos en pantalla: Puntaje y ninjas eliminados
		entorno.cambiarFont("Rockwell", 17, Color.GREEN);
		entorno.escribirTexto("Puntaje: " + puntaje, 690, 15);
		entorno.escribirTexto("Ninjas eliminados: " + ninjasEliminados, 10, 15);
		entorno.escribirTexto("X= " + sakura.getX(), 690, 30);
		entorno.escribirTexto("Y= " + sakura.getY(), 690, 50);
		
		// Dibuja en pantalla en que dificultad se encuentra el jugador
		
				if (dificultad == "Principiante") {
					entorno.cambiarFont("Rockwell", 18, Color.BLACK);
					entorno.escribirTexto("Dificultad:", 10, 35);

					entorno.cambiarFont("Rockwell", 18, Color.GREEN);
					entorno.escribirTexto("Principiante", 100, 35);
				} else if (dificultad == "Intermedio") {
					entorno.cambiarFont("Rockwell", 18, Color.BLACK);
					entorno.escribirTexto("Dificultad:", 5, 35);

					entorno.cambiarFont("Rockwell", 18, Color.ORANGE);
					entorno.escribirTexto("Intermedio", 100, 35);

					for (int i = 0; i < ninjas.length; i++) {
						// Si hay ninja y la velocidad de este es 2 (velocidad base) aumentamos la
						// velocidad a un nivel intermedio
						if (ninjas[i] != null && ninjas[i].getVelocidad() == 2) {
							ninjas[i].cambiarVelocidad(ninjas[i].getVelocidad() + 0.5);
						}

					}
				} else if (dificultad == "Experto") {
					entorno.cambiarFont("Rockwell", 18, Color.BLACK);
					entorno.escribirTexto("Dificultad:", 5, 35);

					entorno.cambiarFont("Rockwell", 18, Color.RED);
					entorno.escribirTexto("Experto", 100, 35);

					for (int i = 0; i < ninjas.length; i++) {
						// Si hay ninja y la velocidad de este es 2.5 (velocidad intermedia) aumentamos la
						// velocidad a un nivel experto
						if (ninjas[i] != null && ninjas[i].getVelocidad() == 2.5) {
							ninjas[i].cambiarVelocidad(ninjas[i].getVelocidad() + 0.5);
						} else if(ninjas[i] != null && ninjas[i].getVelocidad() == 2) { // Si hay ninja y la velocidad de este es 2 (velocidad base al reiniciarse el ninja) aumentamos la
																						// velocidad a un nivel experto
							ninjas[i].cambiarVelocidad(ninjas[i].getVelocidad() + 1);
						}
					}
						
					
					
				}
				for (int i = 0; i < ninjas.length; i++) {
					if (ninjas[i] != null) {
						System.out.println(ninjas[i].getVelocidad());
					}
				}
		} else if(ganar) {
			entorno.dibujarImagen(ganaste, entorno.ancho()/2,entorno.alto()/2,0);
//		entorno.cambiarFont("Arial", 30, Color.YELLOW);
//		entorno.escribirTexto("Ganaste", 300, 300);
		} else if (perdido) {
			entorno.dibujarImagen(gameover, entorno.ancho()/2, entorno.alto()/2, 0);;
		}

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
