package juego;


import java.awt.Color;
import java.awt.Image;
import java.util.Random;

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
	private int pedidoXSakura;
	private int pedidoYSakura;
	private int posXCasas[] = {50,130,270,340,470,540,680,760};
	private int posYCasas[] = {30,160,300,440,570};
	private boolean entregaHecha = true;
	private boolean ikebanaBuscado = false;
	private int posXFlecha;
	private int posYFlecha;
//	private Sakura sakuraizquierda;
	private boolean perdido = false;
	private int clockNinjasNormales[];
	private int clockNinjasFuertes[];
	private int clockShuriken[];
	private Flecha flechaSakura;
	private Image fondo;
	private Image fondoMenu;
	private RamoFlores floresSakura;
	private int puntajeSakura;
	private int tiempo;
	private int ninjasEnJuego;
	private int ninjasEliminados;
	private boolean ganarSakura = false;
	private String dificultad = "Principiante";
	private Image gameover;
	private Shuriken shuriken[];
	private Image fotoGanoSakura;
	private boolean unJugador = false;
	private NinjaFuerte ninjasFuertes[];
	private int rasenganANinjaFuerte[]; // Almacena cuantos rasengan recibio el ninja fuerte, si llega a 2 lo eliminamos
	private int ninjasNuevos = 0; // Sirve para que al llegar a nivel intermedio y experto se sumen a ninjasEnJuego los ninjas mas fuertes.
	// Variables para segundo jugador
	private Naruto naruto;
	private boolean ganarNaruto = false;
	private boolean empate = false;
	private boolean dosJugadores = false;
	private int puntajeNaruto;
	private RamoFlores floresNaruto;
	private Flecha flechaNaruto;
	private boolean entregaHechaNaruto = true;
	private boolean ikebanaBuscadoNaruto = false;
	private int posXFlechaNaruto;
	private int posYFlechaNaruto;
	private int pedidoXNaruto;
	private int pedidoYNaruto;
	private Image fotoGanoNaruto;
	private Image fotoEmpate;
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
		
		rasengan = new Rasengan[2];
		sakura = new Sakura (400,300,2);
		naruto = new Naruto(400,440,2);
		fondo = Herramientas.cargarImagen("fondoJuego.png");
		gameover = Herramientas.cargarImagen("gameover.jpg");
		fotoGanoSakura = Herramientas.cargarImagen("sakuraGana.jpg");
		fotoGanoNaruto = Herramientas.cargarImagen("narutoGana.jpg");
		fotoEmpate = Herramientas.cargarImagen("empate.png");
		// Horizontales
		calle = new Calle(400,90, 800,50,0,true);
		calle1 = new Calle(400,230, 800,50,0, true); 
		calle2 = new Calle(400,370, 800,50,0, true);
		calle3 = new Calle(400,510, 800,50,0, true);
		
		// Verticales

		calle4 = new Calle(200,100, 50,1000,0, false);
		calle5 = new Calle(400,100, 50,1000,0, false);
		calle6 = new Calle(600,100, 50,1000,0, false);


		// Inicializamos a los ninjas normales

        shuriken = new Shuriken [6]; 
		ninjas = new Ninja[6];
		clockNinjasNormales = new int[6];
		posicionesNinjas = new int[6][2];
		clockShuriken = new int [6];
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

			clockNinjasNormales[i] = 0;
			ninjasEnJuego ++;

		}
		
		// Inicializamos los ninjasFuertes 
		ninjasFuertes = new NinjaFuerte[2];
		rasenganANinjaFuerte = new int[2];
		clockNinjasFuertes = new int[2];
		

		
		
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

	
		
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */

	public void tick() {
		if(!unJugador && !dosJugadores) {
			entorno.dibujarImagen(fondoMenu, entorno.ancho() / 2, entorno.alto() / 2, Math.PI * 2);
			entorno.cambiarFont("Rockwell", 25, Color.BLACK);
			entorno.escribirTexto("Presione '1' para jugar con un jugador", 200, 300);
			entorno.escribirTexto("Presione '2' para jugar con dos jugadores", 200, 300 + 30);
		}
		if(entorno.sePresiono('1')) {
			unJugador = true;
		} else if(entorno.sePresiono('2')) {
			dosJugadores = true;
		}
		
		if (!perdido && (!ganarSakura && !ganarNaruto && !empate) && (unJugador || dosJugadores)) {
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
			if(dosJugadores) {
				naruto.dibujar(entorno);
			}
			
			// Dibujamos los ramos para sakura y naruto(si hay dos jugadores)
			if(!ikebanaBuscado && !entregaHecha) {
				floresSakura = new RamoFlores(sakura.getX(),sakura.getY());
				floresSakura.dibujar(entorno);
	
			}
			
			if(dosJugadores) {
				if(!ikebanaBuscadoNaruto && !entregaHechaNaruto) {
					floresNaruto = new RamoFlores(naruto.getX(),naruto.getY());
					floresNaruto.dibujar(entorno);

				}
			}


			if (puntajeSakura >= 50 && puntajeSakura < 100 && dificultad != "Experto"|| tiempo >= 500 && tiempo < 1000) {
				dificultad = "Intermedio";
			} else if (puntajeSakura >= 100 || tiempo >= 1000) {
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
		

		
		//	Flecha sakura
		if(entregaHecha && ikebanaBuscado) {
			Random randomSakuraX = new Random(); // Se inicializa random con un numero diferente para que los numeros random no coincidan
			Random randomSakuraY = new Random();
			pedidoXSakura = randomSakuraX.nextInt(8);  // Nos arroja una posicion aleatoria para x e y correspondiente a una casa
			pedidoYSakura = randomSakuraY.nextInt(5);
			

			
			posXFlecha = posXCasas[pedidoXSakura]; // Asignamos a una variable la posicion aleatoria
			posYFlecha = posYCasas[pedidoYSakura];
			
			flechaSakura = new Flecha(posXFlecha,posYFlecha); // Creamos la flecha sobre la casa aleatoria
			entregaHecha = false;
			ikebanaBuscado = false;
		}
		
		// Flecha naruto (para dos jugadores)
		
		if(entregaHechaNaruto && ikebanaBuscadoNaruto) {
			Random randomNarutoX = new Random();
			Random randomNarutoY = new Random();
			pedidoXNaruto = randomNarutoX.nextInt(8);  // Nos arroja una posicion aleatoria para x e y correspondiente a una casa
			pedidoYNaruto = randomNarutoY.nextInt(5);	
			
			
			posXFlechaNaruto = posXCasas[pedidoXNaruto]; // Asignamos a una variable la posicion aleatoria
			posYFlechaNaruto = posYCasas[pedidoYNaruto];
			
			flechaNaruto = new Flecha(posXFlechaNaruto,posYFlechaNaruto); // Creamos la flecha sobre la casa aleatoria
			entregaHechaNaruto = false;
			ikebanaBuscadoNaruto = false;
		}
		
		
		// Determina si el Ikebana fue buscado
		if(entregaHecha && !ikebanaBuscado) {
			flechaSakura = new Flecha(floreria.getX(),floreria.getY());
			if(sakura.enFloreria(floreria)) {
				ikebanaBuscado = true;
	
			}
		}
		
		if (dosJugadores) {
			if(entregaHechaNaruto && !ikebanaBuscadoNaruto) {
				flechaNaruto = new Flecha(floreria.getX(),floreria.getY());
				if(naruto.enFloreria(floreria)) {
					ikebanaBuscadoNaruto = true;
		
				}
			}
		}
			
		
		// Verificamos si sakura y/o naruto estan en la casa marcada.
		if(sakura.enCasaMarcada(flechaSakura) && !ikebanaBuscado) { // Sakura realizó la entrega y verifica que no sea la floreria
			entregaHecha = true;
			puntajeSakura = puntajeSakura + 5;
		}
		if(dosJugadores) {
			if(naruto.enCasaMarcada(flechaNaruto) && !ikebanaBuscadoNaruto) { // Naruto realizó la entrega y verifica que no sea la floreria
				entregaHechaNaruto = true;
				puntajeNaruto = puntajeNaruto + 5;
			}
		}
		
		// Dibujamos a sakura y a naruto (si hay dos jugadores)
		flechaSakura.dibujar(entorno,true); // Flecha sakura

		if(dosJugadores) {
			flechaNaruto.dibujar(entorno, false); // flecha para naruto
		}

		// Dibujo array ninjas
		for(int i = 0; i < ninjas.length; i++) {
			if(ninjas[i] != null) {
				ninjas[i].dibujar(entorno);		    
			} else {
				clockNinjasNormales[i]++;
			}
		}

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
					if(i == 3 && dificultad != "Experto") {
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

			if (ninjas[i] == null && clockNinjasNormales[i] > 600 ||ninjas[i] == null && ninjasEnJuego < 4) { 
				
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
					if (i == 3 && dificultad != "Experto") {
						ninjas[i] = new Ninja(posicionesNinjas[3][0], posicionesNinjas[3][1]);
					}
					if (i == 4) {
						ninjas[i] = new Ninja(posicionesNinjas[4][0], posicionesNinjas[4][1]);
					}
					if(i == 5) {
						ninjas[i] = new Ninja(posicionesNinjas[5][0],posicionesNinjas[5][1]);
						}

						clockNinjasNormales[i] = 0;
						if(dificultad == "Experto" && i != 3 && ninjasEnJuego < 8) {
							ninjasEnJuego++;
						} else if(dificultad != "Experto" && ninjasEnJuego < 8){
							ninjasEnJuego++;
						}
						

					}

				}
			}
		
		// Dibujamos los ninjas mas fuertes (Requieren de dos rasengan para morir).
		// Dibujamos uno para la intermedia y dos para la experta

		
		if(dificultad == "Intermedio") {
			if(ninjasNuevos < 1) { // El if se asegura que se itere una vez sola al alcanzar la dificultad nueva, 
				ninjasNuevos++;	   //aqui se agregan los ninjas mas fuertes a ninjasEnJuego
				ninjasEnJuego++;
				ninjasFuertes[0] = new NinjaFuerte(25,226); // Inicializa al primer ninja fuerte de intermedio
				clockNinjasFuertes[0] = 0;
			}
			if(ninjasFuertes[0] != null) {
				ninjasFuertes[0].dibujar(entorno);
				ninjasFuertes[0].mover(0);
			} else {
				clockNinjasFuertes[0]++;
				System.out.println(clockNinjasFuertes[0]);
			}
		}
		
		if(dificultad == "Experto") {
			if(ninjasNuevos < 2) { 
				ninjasNuevos++;
				ninjasEnJuego++;
				ninjasFuertes[1] = new NinjaFuerte(770,370); // Inicializa al primer ninja fuerte de experto
				
				ninjas[3] = null;
				ninjasEnJuego--;
				clockNinjasFuertes[1] = 0;
			}
			
			if(ninjasFuertes[0] != null) {
				ninjasFuertes[0].dibujar(entorno);
				ninjasFuertes[0].mover(0);
			} else {
				clockNinjasFuertes[0]++;
				System.out.println(clockNinjasFuertes[0]);
			}
		
			if(ninjasFuertes[1] != null) {
				ninjasFuertes[1].dibujar(entorno);
				ninjasFuertes[1].mover(Math.PI);
			} else {
				clockNinjasFuertes[1]++;
				System.out.println(clockNinjasFuertes[1]);
			}
			
		}
		
		// Dibuja al ninja fuerte de nuevo si choca con el entorno
		for(int i = 0;i < ninjasFuertes.length;i++) {
			if(ninjasFuertes[i] != null) {
				if(ninjasFuertes[i].chocasteConElEntorno(entorno)) {
					if(i == 0) {
						ninjasFuertes[0] = new NinjaFuerte(25,226);
					}
					if(i == 1) {
						ninjasFuertes[1] = new NinjaFuerte(770,370);
					}
				}
			}
			// Si el ninja fuerte esta eliminado y paso cierto tiempo, lo inicializamos de nuevo
			if (ninjasFuertes[i] == null && clockNinjasFuertes[i] > 800) {
				if (i == 0) {
					ninjasFuertes[0] = new NinjaFuerte(25, 226);
					ninjasEnJuego++;
				}
				if (i == 1) {
					ninjasFuertes[1] = new NinjaFuerte(770, 370);
					ninjasEnJuego++;
				}
				clockNinjasFuertes[i] = 0;
				}
			}
			
		
		// Movimiento Sakura
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
		
		// Movimiento Naruto (si hay dos jugadores)
		if(dosJugadores) {
			if (entorno.estaPresionada('s')) {
				naruto.moverAbajo();
			}
			
			else if (entorno.estaPresionada('a')) {
				naruto.moverIzquierda();
			}
			
			else if (entorno.estaPresionada('d')) {
				naruto.moverDerecha();
			}
			
			else if (entorno.estaPresionada('w')) {
				naruto.moverArriba();
			
			}
		}

		
		// Lanzamiento Rasengan naruto (si hay dos jugadores)
		if(dosJugadores) {
			if(entorno.sePresiono('k') && entorno.estaPresionada('s')) { // Dispara el rasengan en la direccion a la que mira el jugador
				if(rasengan[1] == null) { // Si hay rasengan, no dibuja otro
				rasengan[1] = new Rasengan(naruto.getX(),naruto.getY(),Math.PI/2); // Obtenemos la posicion de sakura y disparamos al angulo al que esta mirando
				}
			}
			else if(entorno.sePresiono('k') && entorno.estaPresionada('a')) {
				if(rasengan[1] == null) {
				rasengan[1] = new Rasengan(naruto.getX(),naruto.getY(),Math.PI);
				}
			}
			else if(entorno.sePresiono('k') && entorno.estaPresionada('d')) {
				if(rasengan[1] == null) {
				rasengan[1] = new Rasengan(naruto.getX(),naruto.getY(),Math.PI*2);
				}
			}
			else if(entorno.sePresiono('k') && entorno.estaPresionada('w')) {
				if(rasengan[1] == null) {
				rasengan[1] = new Rasengan(naruto.getX(),naruto.getY(),-Math.PI/2);
				}
			}
			else if(entorno.sePresiono('k')) {
				if(rasengan[1] == null) {
				rasengan[1] = new Rasengan(naruto.getX(),naruto.getY(),Math.PI/2);
				}
			}
		}
		// Lanzamiento Rasengan sakura
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
		

//		//Lanzamiento Shuriken
//		int ninjas = (int ) (Math.random()*6+1);
//		
//		for (int i = 0; i < ninjas.length;i++) {
//			if(i == 0) {
//				shuriken[0] = new Shuriken(posicionesNinjas[0][0],posicionesNinjas[0][1],0 );
//			}
//			if(i == 1) {
//				shuriken[1] = new Shuriken(posicionesNinjas[1][0],posicionesNinjas[1][1],0);
//			}
//			if(i == 2) {
//				shuriken[2] = new Shuriken(posicionesNinjas[2][0],posicionesNinjas[2][1], 0);
//			}
//			if(i == 3) {
//				shuriken[3] = new Shuriken(posicionesNinjas[3][0],posicionesNinjas[3][1],0);
//			}
//			if(i == 4) {
//					shuriken[4] = new Shuriken(posicionesNinjas[4][0],posicionesNinjas[4][1],0);
//				}
//			if(i == 5) {
//				shuriken[5] = new Shuriken(posicionesNinjas[5][0],posicionesNinjas[5][1],0);
//			}
//
//			clockShuriken[6] = 0;
//			
//		}
//		
//	
//		for(int i = 0; i < ninjas.length; i++) {
//			if(ninjas[i] != null) {
//				shuriken[i].dibujar(entorno);
//			} else {
//				clockShuriken[i]++;
//			}
//		}
//		
//		if (ninjas[i] == null && clockShuriken[i] > 500){
//				shuriken[i++];
//		}
//			
//			
//				
//					
//		
//		
//		
//		for(int i = 0; i < shuriken.length;i++) { // Si hay shuriken y choca con algun ninja, eliminamos el shuriken.
//			if(shuriken[0] != null) {
//				if(shuriken[0].chocasteConSakura(sakura)) {
//					perdido=true;
//				}
//					
//			}	
//		}	
//				
//			
//		
//		
//		if(shuriken[0] != null && shuriken[0].chocasteConElEntorno(entorno)) { // Si hay rasengan y choca con el entorno, eliminamos el rasengan.
//			shuriken[0] = null;
//		}
//		if (shuriken[0] != null && !shuriken[0].chocasteConElEntorno(entorno)){ // Si hay rasengan y no choca con el entorno, lo dibujamos y movemos.
//			shuriken[0].dibujar(entorno);
//			shuriken[0].mover();

		//Lanzamiento Shuriken
		int ninja = (int ) (Math.random()*6+1);
		
		for (int i = 0; i < ninjas.length;i++) {
			if(i == 0) {
				shuriken[i] = new Shuriken(posicionesNinjas[0][0],posicionesNinjas[0][1],0 );
			}
			if(i == 1) {
				shuriken[i] = new Shuriken(posicionesNinjas[1][0],posicionesNinjas[1][1],0);
			}
			if(i == 2) {
				shuriken[i] = new Shuriken(posicionesNinjas[2][0],posicionesNinjas[2][1], 0);
			}
			if(i == 3) {
				shuriken[i] = new Shuriken(posicionesNinjas[3][0],posicionesNinjas[3][1],0);
			}
			if(i == 4) {
					shuriken[i] = new Shuriken(posicionesNinjas[4][0],posicionesNinjas[4][1],0);
				}
			if(i == 5) {
				shuriken[i] = new Shuriken(posicionesNinjas[5][0],posicionesNinjas[5][1],0);
			}		
		}
		
		for (int i = 0; i < ninjas.length; i++) {
			if (rasengan[0] != null) { // Verifica si el rasengan de sakura choca con algun
										// ninja
				if (ninjas[i] != null && rasengan[0].chocasteConNinja(ninjas[i])) {
					rasengan[0] = null;
					ninjas[i] = null;
					clockNinjasNormales[i] = 0;
					ninjasEnJuego--;
					ninjasEliminados++;
				}
				// Verifica si choco con algun ninja fuerte
				if(i >= 0 && i <= 1 && rasengan[0] != null) { // Se restringen las i dado que el length del array de ninjasFuertes es de 2. Este for itera para el length de ninjasNormales que es 6
					// Rasengan Sakura
					if(ninjasFuertes[i] != null && rasengan[0].chocasteConNinjaFuerte(ninjasFuertes[i])) {
						rasenganANinjaFuerte[i]++; // Cada rasengan que reciba suma al elemento
						rasengan[0] = null;
						if(rasenganANinjaFuerte[i] == 2) { // Si los rasengan recibidos llega a 2, eliminamos al ninja fuerte
							ninjasFuertes[i] = null;
							ninjasEnJuego--;
							ninjasEliminados++;
							rasenganANinjaFuerte[i] = 0;
						}
					}
				}
			}
			if (rasengan[1] != null) { // Verifica si el rasengan de naruto (cuando hay dos jugadores) choca con algun
										// ninja
				if (ninjas[i] != null && rasengan[1].chocasteConNinja(ninjas[i])) {
					rasengan[1] = null;
					ninjas[i] = null;
					clockNinjasNormales[i] = 0;
					ninjasEnJuego--;
					ninjasEliminados++;
				}
				// Verifica si el rasengan choco con algun ninja fuerte
				if(i >= 0 && i <= 1 && rasengan[0] != null) {
					// Rasengan Naruto
					if(ninjasFuertes[i] != null && rasengan[1].chocasteConNinjaFuerte(ninjasFuertes[i])) {
						rasenganANinjaFuerte[i]++; // Cada rasengan que reciba suma al elemento
						rasengan[1] = null;
						if(rasenganANinjaFuerte[i] == 2) { // Si los rasengan recibidos llega a 2, eliminamos al ninja fuerte
							ninjasFuertes[i] = null;
							ninjasEnJuego--;
							ninjasEliminados++;
							rasenganANinjaFuerte[i] = 0;
						}
					}
				}
			}
		}
		
		for(int i = 0;i<rasengan.length;i++) {
			if(rasengan[i] != null && rasengan[i].chocasteConElEntorno(entorno)) { // Si hay rasengan y choca con el entorno, eliminamos el rasengan.
				rasengan[i] = null;
			} else if(rasengan[i] != null && !rasengan[i].chocasteConElEntorno(entorno)){ // Si hay rasengan y no choca con el entorno, lo dibujamos y movemos.
				rasengan[i].dibujar(entorno);
				rasengan[i].mover();
			}
		}


		
	
		for(int i = 0; i < ninjas.length; i++) {
			if(ninjas[i] != null) {
				shuriken[i].dibujar(entorno);
			} else {
				clockShuriken[i]++;
			}
	
//			if (ninjas[i] == null && clockShuriken[i] > 500){
//					shuriken[i]++;
//			}
		}
			
				
					
		
		
		
		for(int i = 0; i < shuriken.length;i++) { // Si hay shuriken y choca con algun ninja, eliminamos el shuriken.
			if(shuriken[0] != null) {
				if(shuriken[0].chocasteConSakura(sakura)) {
					perdido=true;
				}
					
			}	
		}	
				
			
		
		
		if(shuriken[0] != null && shuriken[0].chocasteConElEntorno(entorno)) { // Si hay rasengan y choca con el entorno, eliminamos el rasengan.
			shuriken[0] = null;
		}
		if (shuriken[0] != null && !shuriken[0].chocasteConElEntorno(entorno)){ // Si hay rasengan y no choca con el entorno, lo dibujamos y movemos.
			shuriken[0].dibujar(entorno);
			shuriken[0].mover();
		}
//		if (rasengan[0] != null && !rasengan[0].chocasteConElEntorno(entorno)){ // Si hay rasengan y no choca con el entorno, lo dibujamos y movemos.
//			rasengan[0].dibujar(entorno);
//			rasengan[0].mover();
//		}
		
		
		//Monedas del juego
		for(int i = 0; i < monedas.length;i++) {
			for(int j = 0; j < monedas[0].length;j++) {
				// Verifica si sakura toca alguna moneda y le suma puntaje
				if(monedas[i][j] != null && sakura.tocasteMoneda(monedas[i][j])) {
					monedas[i][j] = null;
					puntajeSakura += 10;
				}
				// Verifica si naruto toca alguna moneda y le suma puntaje
				if(dosJugadores) {
					if(monedas[i][j] != null && naruto.tocasteMoneda(monedas[i][j])) {
						monedas[i][j] = null;
						puntajeNaruto += 10;
					}
				}	
			}
		}
	
		// Verifica la colision de sakura con algun ninja para un jugador
		if(unJugador) {
			for(int i = 0; i < ninjas.length;i++) { 
				if(ninjas[i] != null) {
					if( sakura.chocasteConNinja(ninjas[i])) {
						perdido = true;
					}
				}
			}
			// Verifica la colision para ninjas fuertes.
			for(int i = 0; i < ninjasFuertes.length;i++) { 
				if(ninjasFuertes[i] != null) {
					if( sakura.chocasteConNinjaFuerte(ninjasFuertes[i])) {
						perdido = true;
					}
				}
			}
		}
		
		// Verifica la colision de naruto y sakura para dos jugadores
		if(dosJugadores) {
			for(int i = 0; i < ninjas.length;i++) { 
				if(ninjas[i] != null) {
					if( sakura.chocasteConNinja(ninjas[i])) {
						ganarNaruto = true;
					}
					if(naruto.chocasteConNinja(ninjas[i])) {
						ganarSakura = true;
					}
				}
			}

			// Verifica la colision para ninjas fuertes.
			for (int i = 0; i < ninjasFuertes.length; i++) {
				if (ninjasFuertes[i] != null) {
					if (sakura.chocasteConNinjaFuerte(ninjasFuertes[i])) {
						ganarNaruto = true;
					}
					if(naruto.chocasteConNinjaFuerte(ninjasFuertes[i])) {
						ganarSakura = true;
					}
				}
			}
		}
		// Ganar el juego para un jugador
		if(unJugador) {
			if(puntajeSakura >= 100 || tiempo == 3000) {
				ganarSakura = true;
			}
		}
		
		// Ganar el juego para alguno de los dos jugadores o empate
		if(dosJugadores) {
			if(puntajeNaruto >= 100) {
				ganarNaruto = true;
			} else if(puntajeSakura >= 100) {
				ganarSakura = true;
			} else if(tiempo >= 3000) {
				empate = true;
			}
		}
		
				
		// Datos en pantalla: Puntaje y ninjas eliminados
		entorno.cambiarFont("Rockwell", 17, Color.GREEN);
		entorno.escribirTexto("Puntaje Sakura: " + puntajeSakura, 650, 15);
		if(dosJugadores) {
			entorno.escribirTexto("Puntaje Naruto: " + puntajeNaruto, 650, 30);
		}
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
				
				System.out.println(ninjasEnJuego);
		} else if(ganarSakura) {
			entorno.dibujarImagen(fotoGanoSakura, entorno.ancho()/2,entorno.alto()/2,0);
			entorno.cambiarFont("Arial", 30, Color.YELLOW);
			entorno.escribirTexto("Ganó Sakura!", 300, 300);
		} else if(ganarNaruto) {
			entorno.dibujarImagen(fotoGanoNaruto, entorno.ancho()/2,entorno.alto()/2,0);
			entorno.cambiarFont("Arial", 30, Color.YELLOW);
			entorno.escribirTexto("Ganó Naruto!", 300, 300);
		} else if(empate) {
			entorno.dibujarImagen(fotoEmpate, entorno.ancho()/2,entorno.alto()/2,0);
			entorno.cambiarFont("Arial", 30, Color.YELLOW);
			entorno.escribirTexto("Hubo empate!", 300, 300);
		}else if (perdido) {
			entorno.dibujarImagen(gameover, entorno.ancho()/2, entorno.alto()/2, 0);;
		}

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
