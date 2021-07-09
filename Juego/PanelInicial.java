package Juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import Juego.*;
import basicJuego.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class PanelInicial extends JFrame {

	private JPanel contentPane;
	private int cantidadDeJugadores;
	private int puntajeMaximo;

	/**
	 * Create the frame.
	 */
	public PanelInicial(PanelPrincipal pp) {

		this.cantidadDeJugadores = 0;
		this.puntajeMaximo = 0;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(250, 70, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 1, 0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255,230,0));
		contentPane.add(desktopPane);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(0, 120, 900, 350);
		desktopPane_1.setBackground(Color.YELLOW);
		desktopPane.add(desktopPane_1);
		
		//Label Tiutlo del juego
		JLabel tituloPrincipal = new JLabel("AMBICIOSO");
		tituloPrincipal.setFont(new Font("SansSerif", Font.BOLD, 50));
		tituloPrincipal.setBounds(308, 37, 339, 37);
		desktopPane.add(tituloPrincipal);
		
		//Label cantidad de jugadores
		JLabel labelCantidadJugadores = new JLabel("Cantidad de jugadores: ");
		labelCantidadJugadores.setFont(new Font("SansSerif", Font.PLAIN, 30));
		labelCantidadJugadores.setBounds(123, 54, 334, 97);
		desktopPane_1.add(labelCantidadJugadores);
		
		//Label valor cantidad de jugadores
		JLabel labelNumCantidadJugadores = new JLabel("0");
		labelNumCantidadJugadores.setFont(new Font("SansSerif", Font.PLAIN, 30));
		labelNumCantidadJugadores.setBounds(467, 90, 60, 24);
		desktopPane_1.add(labelNumCantidadJugadores);
		
		//Label Puntaje maximo del juego
		JLabel labelPunatjeInicial = new JLabel("Puntaje con el que comienza: ");
		labelPunatjeInicial.setFont(new Font("SansSerif", Font.PLAIN, 30));
		labelPunatjeInicial.setBounds(61, 172, 407, 39);
		desktopPane_1.add(labelPunatjeInicial);
		
		//Label valor del puntaje maximo
		JLabel labelNumPuntajeInicial = new JLabel("0");
		labelNumPuntajeInicial.setFont(new Font("SansSerif", Font.PLAIN, 30));
		labelNumPuntajeInicial.setBounds(467, 179, 129, 24);
		desktopPane_1.add(labelNumPuntajeInicial);
		
		//Boton mas jugadores
		JButton btnMasJugadores = new JButton("Mas jugadores");
		btnMasJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cantidadDeJugadores<6) {
					labelNumCantidadJugadores.setText(String.valueOf(cantidadDeJugadores+1));
					cantidadDeJugadores+=1;
				}
			}
		});
		btnMasJugadores.setBounds(606, 78, 118, 23);
		desktopPane_1.add(btnMasJugadores);
		
		//Boton menos jugadores
		JButton btnMenosJugadores = new JButton("Menos jugadores");
		btnMenosJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cantidadDeJugadores>0) {
					labelNumCantidadJugadores.setText(String.valueOf(cantidadDeJugadores-1));
					cantidadDeJugadores-=1;
				}
			}
		});
		btnMenosJugadores.setBounds(606, 112, 118, 23);
		desktopPane_1.add(btnMenosJugadores);
		
		//Boton mas puntaje
		JButton btnMasPuntos = new JButton("Mas puntos");
		btnMasPuntos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(puntajeMaximo<10000) {
					labelNumPuntajeInicial.setText(String.valueOf(puntajeMaximo+1000));
					puntajeMaximo+=1000;
				}
			}
		});
		btnMasPuntos.setBounds(606, 172, 118, 23);
		desktopPane_1.add(btnMasPuntos);
		
		//Boton menos puntaje
		JButton btnMenosPuntos = new JButton("Menos puntos");
		btnMenosPuntos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(puntajeMaximo>0) {
					labelNumPuntajeInicial.setText(String.valueOf(puntajeMaximo-1000));
					puntajeMaximo-=1000;
				}
			}
		});
		btnMenosPuntos.setBounds(606, 209, 118, 23);
		desktopPane_1.add(btnMenosPuntos);
		
		//Boton continuar
		JButton btnContinuar = new JButton("CONTINUAR");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cantidadDeJugadores==0 || puntajeMaximo==0) {
					JOptionPane.showMessageDialog(null, "Ambos parametros deben ser diferentes de cero");
				}else {
					for(int i=0; i<cantidadDeJugadores; i++) {
						Jugadores ju = new Jugadores(i+1);
						pp.getListaJugadores().insertarJugador(ju);
					}
					pp.mostrarPanelJuego();
					dispose();
				}
			}
		});
		btnContinuar.setBounds(388, 281, 121, 23);
		desktopPane_1.add(btnContinuar);
		
	}
	
	public int getNumeroJugadores() {
		return cantidadDeJugadores;
	}
	
	public int getPuntajeMaximo() {
		return puntajeMaximo;
	}
}
