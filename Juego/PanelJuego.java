package Juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import acm.graphics.*;
import java.awt.Canvas;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Juego.*;
import basicJuego.*;

public class PanelJuego extends JFrame {

	System.out.println("Inicio");

	private JPanel contentPane;
	private GCanvas gc1; //Panel dado1 
	private GCanvas gc2; //Panel dado2
	private GCanvas gc3; //Panel dado3
	private GCanvas gc4; //Panel dado4
	private GCanvas gc5; //Panel dado5
	
	private GRect sqr1; //GRect dado1
	private GRect sqr2; //GRect dado2
	private GRect sqr3; //GRect dado3
	private GRect sqr4; //GRect dado4
	private GRect sqr5; //GRect dado5
	
	Dados dado1; //Objecto dado1
	Dados dado2; //Objecto dado2
	Dados dado3; //Objecto dado3
	Dados dado4; //Objecto dado4
	Dados dado5; //Objecto dado5
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	
	private JLabel lblNewLabel; //Label del puntaje parcial por partida
	private JLabel label; //Puntaje parcial por partida 
	private JButton btnTirarDado; //Boton tirar dado
	private JTable table; //Tabla de jugadores
	
	private int puntajeJugador; //Puntaje parcial que se le suma al jugador por partida
	public int jugadorActual = 1; //Jugador que se encuentra en turno
	private JLabel jugadorEnTurno; //Label del jugador en turno

	/**
	 * Create the frame.
	 */
	public PanelJuego(PanelPrincipal pp) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(90, 70, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 1, 0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255,230,0));
		contentPane.add(desktopPane);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(0, 120, 1200, 350);
		desktopPane_1.setBackground(Color.YELLOW);
		desktopPane.add(desktopPane_1);
		
		//Dado numero 1
		panel1 = new JPanel();
		panel1.setBounds(70, 60, 80, 80);
		panel1.setLayout(new GridLayout(1, 1, 0, 0));
		desktopPane_1.add(panel1);
		
		gc1 = new GCanvas();
		gc1.setLayout(new GridLayout(1, 1, 0, 0));
		panel1.add(BorderLayout.CENTER,gc1);
		
		sqr1 = new GRect(0, 0,80,80);
		sqr1.setFilled(true);
		sqr1.setColor(Color.WHITE);
        gc1.add(sqr1);
        
        //Dado numero 2
		panel2 = new JPanel();
		panel2.setBounds(160, 60, 80, 80);
		panel2.setLayout(new GridLayout(1, 1, 0, 0));
		desktopPane_1.add(panel2);
		
		gc2 = new GCanvas();
		gc2.setLayout(new GridLayout(1, 1, 0, 0));
		panel2.add(BorderLayout.CENTER,gc2);
		
		sqr2 = new GRect(0, 0,80,80);
		sqr2.setFilled(true);
		sqr2.setColor(Color.WHITE);
        gc2.add(sqr2);
        
      //Dado numero 3
		panel3 = new JPanel();
		panel3.setBounds(250, 60, 80, 80);
		panel3.setLayout(new GridLayout(1, 1, 0, 0));
		desktopPane_1.add(panel3);
		
		gc3 = new GCanvas();
		gc3.setLayout(new GridLayout(1, 1, 0, 0));
		panel3.add(BorderLayout.CENTER,gc3);
		
		sqr3 = new GRect(0, 0,80,80);
		sqr3.setFilled(true);
		sqr3.setColor(Color.WHITE);
        gc3.add(sqr3);
        
      //Dado numero 4
		panel4 = new JPanel();
		panel4.setBounds(340, 60, 80, 80);
		panel4.setLayout(new GridLayout(1, 1, 0, 0));
		desktopPane_1.add(panel4);
		
		gc4 = new GCanvas();
		gc4.setLayout(new GridLayout(1, 1, 0, 0));
		panel4.add(BorderLayout.CENTER,gc4);
		
		sqr4 = new GRect(0, 0,80,80);
		sqr4.setFilled(true);
		sqr4.setColor(Color.WHITE);
        gc4.add(sqr4);
        
        //Dado numero 5
		panel5 = new JPanel();
		panel5.setBounds(430, 60, 80, 80);
		panel5.setLayout(new GridLayout(1, 1, 0, 0));
		desktopPane_1.add(panel5);
		
		gc5 = new GCanvas();
		gc5.setLayout(new GridLayout(1, 1, 0, 0));
		panel5.add(BorderLayout.CENTER,gc5);
		
		sqr5 = new GRect(0, 0,80,80);
		sqr5.setFilled(true);
		sqr5.setColor(Color.WHITE);
        gc5.add(sqr5);
		
        
        ////////////////////////////////////////////////////////////////////////////
		
		JLabel tituloPrincipal = new JLabel("AMBICIOSO");
		tituloPrincipal.setFont(new Font("SansSerif", Font.BOLD, 50));
		tituloPrincipal.setBounds(450, 35, 339, 37);
		desktopPane.add(tituloPrincipal);
		
		lblNewLabel = new JLabel("Puntaje: ");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblNewLabel.setBounds(222, 170, 117, 31);
		desktopPane_1.add(lblNewLabel);
		
		label = new JLabel("0");
		label.setFont(new Font("SansSerif", Font.PLAIN, 30));
		label.setBounds(349, 170, 161, 31);
		desktopPane_1.add(label);
		
		JLabel turnoDelJugador = new JLabel("Turno del jugador: ");
		turnoDelJugador.setFont(new Font("Tahoma", Font.PLAIN, 25));
		turnoDelJugador.setBounds(95, 295, 217, 23);
		desktopPane_1.add(turnoDelJugador);
		
		jugadorEnTurno = new JLabel("Jugador #1");
		jugadorEnTurno.setFont(new Font("Tahoma", Font.PLAIN, 25));
		jugadorEnTurno.setBounds(315, 291, 195, 31);
		desktopPane_1.add(jugadorEnTurno);
		
		//Boton terminar partida
		JButton btnTerminarPartida = new JButton("Terminar");
		btnTerminarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(pp.getListaJugadores().get(jugadorActual).getPuntaje()==pp.pi.getPuntajeMaximo()) {
					JOptionPane.showMessageDialog(null, "EL jugador "+pp.getListaJugadores().get(jugadorActual).toString()+" a ganado, FELICIDADES");
					pp.mostrarPanelInicial();
					dispose();
				}
				
				dado1.setGiro(true);
				sqr1.setColor(Color.WHITE);
				dado2.setGiro(true);
				sqr2.setColor(Color.WHITE);
				dado3.setGiro(true);
				sqr3.setColor(Color.WHITE);
				dado4.setGiro(true);
				sqr4.setColor(Color.WHITE);
				dado5.setGiro(true);
				sqr5.setColor(Color.WHITE);
				
				table.getModel().setValueAt(pp.getListaJugadores().get(jugadorActual).getPuntaje(), jugadorActual-1, 1);
				for(int i=0; i<pp.pi.getNumeroJugadores(); i++) {
					System.out.println(pp.getListaJugadores().get(i+1).toStringP());
				}
				if(jugadorActual<pp.pi.getNumeroJugadores()) {
					jugadorActual++;
				}else {
					jugadorActual = 1;
				}
				jugadorEnTurno.setText(pp.getListaJugadores().get(jugadorActual).toString());
				puntajeJugador = 0;
			}
		});
		btnTerminarPartida.setBounds(188, 234, 89, 23);
		desktopPane_1.add(btnTerminarPartida);
		
		//Boton tirar los dados
		btnTirarDado = new JButton("Tirar Dado");
		btnTirarDado.setBounds(287, 234, 102, 23);
		desktopPane_1.add(btnTirarDado);
		
		dado1 = new Dados(sqr1,gc1);
		dado2 = new Dados(sqr2,gc2);
		dado3 = new Dados(sqr3,gc3);
		dado4 = new Dados(sqr4,gc4);
		dado5 = new Dados(sqr5,gc5);
		
		btnTirarDado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dado1!=null && dado2!=null && dado3!=null && dado4!=null && dado5!=null) {
					System.out.println("BORRANDO");
					if(dado1.getGiro()==true) {
						dado1.eliminarDados();
					}
					if(dado2.getGiro()==true) {
						dado2.eliminarDados();
					}
					if(dado3.getGiro()==true) {
						dado3.eliminarDados();
					}
					if(dado4.getGiro()==true) {
						dado4.eliminarDados();
					}
					if(dado5.getGiro()==true) {
						dado5.eliminarDados();
					}
				}
				
				ArrayList<Dados>puntajes = new ArrayList<Dados>();
				if(dado1.getGiro()==true) {
					dado1.setCara(dado1.carasDado());
					puntajes.add(dado1);
				}
				if(dado2.getGiro()==true) {
					dado2.setCara(dado2.carasDado());
					puntajes.add(dado2);
				}
				if(dado3.getGiro()==true) {
					dado3.setCara(dado3.carasDado());
					puntajes.add(dado3);
				}
				if(dado4.getGiro()==true) {
					dado4.setCara(dado4.carasDado());
					puntajes.add(dado4);
				}
				if(dado5.getGiro()==true) {
					dado5.setCara(dado5.carasDado());
					puntajes.add(dado5);
				}
				int puntos = puntaje(puntajes);
				System.out.println(puntos);
				if(puntos==0) {
					pp.getListaJugadores().get(jugadorActual).setPuntaje(pp.getListaJugadores().get(jugadorActual).getPuntaje()-puntajeJugador);
					btnTerminarPartida.doClick();
				}else {
					if(pp.getListaJugadores().get(jugadorActual).getPuntaje()+puntos<=pp.pi.getPuntajeMaximo()) {
						puntajeJugador = puntajeJugador+puntos;
						pp.getListaJugadores().get(jugadorActual).setPuntaje(pp.getListaJugadores().get(jugadorActual).getPuntaje()+puntos);
					}else {
						JOptionPane.showMessageDialog(null,"El puntaje es mayor al maximo");
						btnTerminarPartida.doClick();
					}
				}
				label.setText(Integer.toString(puntajeJugador));
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(610, 60, 537, 234);
		desktopPane_1.add(scrollPane);
		
		//Tabla de jugadores
		table = new JTable(pp.getListaJugadores().size(),2);
		table.setRowHeight(scrollPane.getSize().height/pp.pi.getNumeroJugadores());
		for(int i=0; i<pp.pi.getNumeroJugadores();i++) {
			table.getModel().setValueAt(pp.getListaJugadores().get(i+1).toString(), i, 0);
		}
		scrollPane.setColumnHeaderView(table);
		
		
	}
	
	//Funcion para establecer puntaje del lanzamiento
	public int puntaje(ArrayList<Dados>lista) {
		
		int puntaje = 0;
		
		int cont = 0;
		for(int i=0; i<lista.size();i++) {
			int primero = lista.get(0).getCara();
			if(lista.get(i).getCara()!=primero) {
				break;
			}
		}
		if(cont==5) {
			return -1;
		}else {
			for(int i=0; i<lista.size();i++) {
				if(lista.get(i).getCara()==1) {
					puntaje = puntaje+100;
					lista.get(i).setGiro(false);
					lista.get(i).getRect().setColor(Color.RED);
					lista.remove(i);
					i--;
				}else if(lista.get(i).getCara()==5) {
					puntaje = puntaje+50;
					lista.get(i).setGiro(false);
					lista.get(i).getRect().setColor(Color.RED);
					lista.remove(i);
					i--;
				}
			}
			for(int i=0; i<lista.size(); i++) {
				int primero = lista.get(i).getCara();
				ArrayList<Dados>grupos = new ArrayList<Dados>();
				for(int j=0; j<lista.size(); j++) {
					if(primero==lista.get(j).getCara()) {
						grupos.add(lista.get(j));
					}
				}
				if(grupos.size()==3) {
					puntaje = puntaje+ lista.get(i).getCara()*100;
					for(int k=0; k<grupos.size(); k++) {
						grupos.get(k).setGiro(false);
						grupos.get(k).getRect().setColor(Color.RED);
					}
					break;
				}else if(grupos.size()==4) {
					puntaje = puntaje+ lista.get(i).getCara()*lista.get(i).getCara()*100;
					for(int k=0; k<grupos.size(); k++) {
						grupos.get(k).setGiro(false);
						grupos.get(k).getRect().setColor(Color.RED);
					}
					break;
				}
			}
			
			if(dado1.getGiro()==false && dado2.getGiro()==false && dado3.getGiro()==false && dado4.getGiro()==false && dado5.getGiro()==false) {
				System.out.println("Los cinco cuentan");
				dado1.setGiro(true);
				dado1.getRect().setColor(Color.WHITE);
				dado2.setGiro(true);
				dado2.getRect().setColor(Color.WHITE);
				dado3.setGiro(true);
				dado3.getRect().setColor(Color.WHITE);
				dado4.setGiro(true);
				dado4.getRect().setColor(Color.WHITE);
				dado5.setGiro(true);
				dado5.getRect().setColor(Color.WHITE);
				JOptionPane.showMessageDialog(null,"Felicidades, vuelve a lanzar");
			}
			
			System.out.println("############################");
			System.out.println(dado1.getGiro());
			System.out.println(dado2.getGiro());
			System.out.println(dado3.getGiro());
			System.out.println(dado4.getGiro());
			System.out.println(dado5.getGiro());
			
			return puntaje;
		}
	}
}
