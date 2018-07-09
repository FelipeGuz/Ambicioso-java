package Juego;

import Juego.*;
import basicJuego.*;

public class PanelPrincipal {
	
	private listaJugadores lj;
	
	public PanelPrincipal() {
		this.lj = new listaJugadores();
		mostrarPanelInicial();
	}
	
	public listaJugadores getListaJugadores() {
		return lj;
	}
	
	public void mostrarPanelInicial() {
		PanelInicial pi = new PanelInicial(this);
		pi.setVisible(true);
	}
	
	public void mostrarPanelJuego() {
		PanelJuego pj = new PanelJuego(this);
		pj.setVisible(true);
	}
	
	public static void main(String[] args) {
		PanelPrincipal pp = new PanelPrincipal();
	}
}
