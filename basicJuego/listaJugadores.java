package basicJuego;

import java.util.*;

public class listaJugadores {
	
	HashMap<Integer,Jugadores>listaJugadores;
	
	public listaJugadores() {
		this.listaJugadores = new HashMap<Integer,Jugadores>();
	}
	
	public void insertarJugador(Jugadores jugador) {
		listaJugadores.put(jugador.getNumJugador(), jugador);
	}
	
	public Jugadores buscarJugador(int numJugador) {
		return listaJugadores.get(numJugador);
	}
	
	public int size() {
		return listaJugadores.size();
	}
	
	public Jugadores get(int index) {
		return listaJugadores.get(index);
	}
	
}
