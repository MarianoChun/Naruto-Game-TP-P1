package juego;


import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Rasengan rasengan;
	private Calle calle;
	private Calle calle1;
	private Calle calle2;
	private Calle calle3;
	private Calle calle4;
	private Calle calle5;
	private Calle calle6;
	private Ninja ninjas[];
	private Sakura sakura;
	private Casa casa;
	private Casa casa1;

//	private Sakura sakuraizquierda;

	private Image fondo;
	boolean rasenganActivado = false;
	

	public Juego() {
		// Inicializa el objeto entorno

		this.entorno = new Entorno(this,  "Sakura Ikebana Delivery - Grupo 4 - v1", 800, 600);

//		this.sakuraizquierda = new Sakura()
				

		
		
		                                       

		// Inicializar lo que haga falta para el juego
		// ...


		sakura = new Sakura (400,300,50,2,Color.BLUE);		
		fondo = Herramientas.cargarImagen("fondoJuego.png");

		// Horizontales
		calle = new Calle(400,90, 800,50,0, Color.gray);
		calle1 = new Calle(400,230, 800,50,0, Color.gray); 
		calle2 = new Calle(400,370, 800,50,0, Color.gray);
		calle3 = new Calle(400,510, 800,50,0, Color.gray);
		
		// Verticales
		calle4 = new Calle(200,100, 50,1000,0, Color.gray);
		calle5 = new Calle(400,100, 50,1000,0, Color.gray);
		calle6 = new Calle(600,100, 50,1000,0, Color.gray);

		// Ninjas
		ninjas = new Ninja[5];
		// Se toma como primera posicion a las coordenadas de la primer calle vertical.
		int ninjaX = 200;
		int ninjaY = 570;
		// ninja[0] de abajo hacia arrriba, calle vertical izquierda
		// ninja[1] de arriba hacia abajo, calle vertical derecha
		// ninja[2] de izq a der, calle horizontal superior primera
		// ninja[3] de der a izq, calle horizontal inferior segunda
		// ninja[4] de iz a der, calle horizontal inferior primera
		for (int i = 0; i < ninjas.length;i++) {
			if(i == 0) {
				ninjas[i] = new Ninja(ninjaX,ninjaY);
			}
			if(i == 1) {
				ninjaX = 600;
				ninjaY = 50;
				ninjas[i] = new Ninja(ninjaX,ninjaY);
			}
			if(i == 2) {
				ninjaX = 100;
				ninjaY = 90;
				ninjas[i] = new Ninja(ninjaX,ninjaY);
			}
			if(i == 3) {
				ninjaX = 700;
				ninjaY = 370;
				ninjas[i] = new Ninja(ninjaX,ninjaY);
			}
			if(i == 4) {
					ninjaX = 100;
					ninjaY = 510;
					ninjas[i] = new Ninja(ninjaX,ninjaY);
				}
		}
		casa = new Casa(50,20,50,40,0,Color.MAGENTA);
		casa1 = new Casa(130,20,50,60,0,Color.blue);
		
//		Calle[] calles = new Calle [4];
//		int x=400;
//		int y=100;
//		for (int i=0; i <4;i++) {
//			calles[i] = new Calle(x,y, 800,50,0, Color.gray);
//			x=x+100;
//			y=y+100;
//			
//		}

		
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

//		calle.dibujar(entorno);
//		calle1.dibujar(entorno);
		entorno.dibujarImagen(fondo,entorno.ancho()/2, entorno.alto()/2, Math.PI*2);
		calle.dibujar(entorno);
		calle1.dibujar(entorno);
		calle2.dibujar(entorno);
		calle3.dibujar(entorno);
		calle4.dibujar(entorno);
		calle5.dibujar(entorno);

		calle6.dibujar(entorno);	
		sakura.dibujar(entorno);

		calle6.dibujar(entorno);

		
		casa.dibujar(entorno);
		casa1.dibujar(entorno);
		
		sakura.dibujar(entorno);	
		//ninja1.dibujar(entorno);
		

		// Dibujo array ninja
		for(int i = 0; i < ninjas.length; i++) {
			ninjas[i].dibujar(entorno);
		}
		sakura.dibujar(entorno);


//		sakuraizquierda.dibujar(entorno);

		
//		if(sakura.chocasteConElEntorno(entorno)) {
//			sakura.frenar(entorno);
	
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
		if(entorno.sePresiono(entorno.TECLA_ESPACIO) && entorno.estaPresionada(entorno.TECLA_ABAJO) ) {
			rasengan = new Rasengan(sakura.getX(),sakura.getY(),Math.PI/2);
			rasenganActivado = true;
		}
		else if(entorno.sePresiono(entorno.TECLA_ESPACIO) && entorno.estaPresionada(entorno.TECLA_IZQUIERDA) ) {
			rasengan = new Rasengan(sakura.getX(),sakura.getY(),Math.PI);
			rasenganActivado = true;
		}
		else if(entorno.sePresiono(entorno.TECLA_ESPACIO) && entorno.estaPresionada(entorno.TECLA_DERECHA) ) {
			rasengan = new Rasengan(sakura.getX(),sakura.getY(),Math.PI*2);
			rasenganActivado = true;
		}
		else if(entorno.sePresiono(entorno.TECLA_ESPACIO) && entorno.estaPresionada(entorno.TECLA_ARRIBA) ) {
			rasengan = new Rasengan(sakura.getX(),sakura.getY(),-Math.PI/2);
			rasenganActivado = true;
		}
		
		if(rasenganActivado) {
			rasengan.dibujar(entorno);
			rasengan.mover();
		}
//		if (ninja1.chocasteConElEntorno(entorno)) {
//			ninja1.cambiarDeDireccion();
//		}
		
//		if (ninja1.chocasteConUnRasengan(rasengan)) {
//			//vivo = false;
//			System.out.println("Choca");
//		}
	
		
		


	//	sakura.dibujar(entorno);
	//	sakura.mover();




	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
