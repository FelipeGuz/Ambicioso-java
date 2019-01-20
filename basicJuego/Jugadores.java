package basicJuego;

public class Jugadores {
	
	int puntaje;
	int numJugador;
	
	
	public Jugadores(int numJugador){
		this.numJugador = numJugador;
		this.puntaje = 0;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(int newPuntaje) {
		puntaje = newPuntaje;
	}
	
	public int getNumJugador() {
		return numJugador;
	}
	
	public void setNumJugador(int newNumJugador) {
		numJugador = newNumJugador;
	}
	
	public String toString() {
		return "Jugador #"+numJugador;
	}
	
	public String toStringP() {
		return "Jugador #"+numJugador+" /Puntaje: "+puntaje;
	}
}
