package juego;

public class Jugadores<Player> {
	private String nombre;
	private String password;
	private int puntos;
	
	public Jugadores(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
		puntos = 0;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	/**
	 * Aumenta los puntos del player.
	 * La puntuacion aumenta en 5 cuando se gana una partida.
	 */
	public void aumentarPuntos() {
		puntos += 5;
	}
	
	
	
	public boolean equals(Object objeto) {
		if (objeto instanceof Jugadores) { //comparamos los objetos jugadores
			Jugadores otroJugador = (Jugadores)objeto;
			//Dos jugadores son iguales si tienen el mismo nombre
			return nombre.equals(otroJugador);
		}
		else
			return false; //Ni siquiera es un objeto 
	}
	
}


