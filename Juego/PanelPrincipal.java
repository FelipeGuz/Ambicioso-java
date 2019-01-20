package Juego;

import Juego.*;
import basicJuego.*;

public class PanelPrincipal {
	
	private listaJugadores lj;
	PanelInicial pi;
	
	public PanelPrincipal() {
		this.lj = new listaJugadores();
		this.pi = new PanelInicial(this);
		mostrarPanelInicial();
	}
	
	public listaJugadores getListaJugadores() {
		return lj;
	}
	
	public void mostrarPanelInicial() {
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
