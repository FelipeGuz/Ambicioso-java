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
	
	private JLabel lblNewLabel;
	private JLabel label;
	private JButton btnTirarDado;
	private JTable table;
	
	private int puntajeJugador;
	public int jugadorActual = 1;
	private JLabel jugadorEnTurno;

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
		turnoDelJugador.setFont(new Font("Tahoma", Font.PLAIN, 17));
		turnoDelJugador.setBounds(70, 298, 151, 23);
		desktopPane_1.add(turnoDelJugador);
		
		jugadorEnTurno = new JLabel("Jugador #1");
		jugadorEnTurno.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jugadorEnTurno.setBounds(222, 302, 128, 14);
		desktopPane_1.add(jugadorEnTurno);
		
		JButton btnTerminarPartida = new JButton("Terminar");
		btnTerminarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		
		btnTirarDado = new JButton("Tirar Dado");
		btnTirarDado.setBounds(287, 234, 102, 23);
		desktopPane_1.add(btnTirarDado);
		
		btnTirarDado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dado1!=null && dado2!=null && dado3!=null && dado4!=null && dado5!=null) {
					dado1.eliminarDados();
					dado2.eliminarDados();
					dado3.eliminarDados();
					dado4.eliminarDados();
					dado5.eliminarDados();
				}
				dado1 = new Dados(sqr1,gc1);
				int valorD1 = dado1.carasDado();
				dado2 = new Dados(sqr1,gc2);
				int valorD2 = dado2.carasDado();
				dado3 = new Dados(sqr1,gc3);
				int valorD3 = dado3.carasDado();
				dado4 = new Dados(sqr1,gc4);
				int valorD4 = dado4.carasDado();
				dado5 = new Dados(sqr1,gc5);
				int valorD5 = dado5.carasDado();
				System.out.println(valorD1+" "+valorD2+" "+valorD3+" "+valorD4+" "+valorD5);
				ArrayList<Integer>puntajes = new ArrayList<Integer>();
				puntajes.add(valorD1);
				puntajes.add(valorD2);
				puntajes.add(valorD3);
				puntajes.add(valorD4);
				puntajes.add(valorD5);
				int puntos = puntaje(puntajes);
				System.out.println(puntos);
				if(puntos==0) {
					pp.getListaJugadores().get(jugadorActual).setPuntaje(pp.getListaJugadores().get(jugadorActual).getPuntaje()-puntajeJugador);
					btnTerminarPartida.doClick();
				}else {
					puntajeJugador = puntajeJugador+puntos;
					pp.getListaJugadores().get(jugadorActual).setPuntaje(pp.getListaJugadores().get(jugadorActual).getPuntaje()+puntos);
				}
				label.setText(Integer.toString(puntajeJugador));
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(610, 60, 537, 234);
		desktopPane_1.add(scrollPane);
		
		table = new JTable(pp.getListaJugadores().size(),2);
		table.setRowHeight(scrollPane.getSize().height/pp.pi.getNumeroJugadores());
		for(int i=0; i<pp.pi.getNumeroJugadores();i++) {
			table.getModel().setValueAt(pp.getListaJugadores().get(i+1).toString(), i, 0);
		}
		scrollPane.setColumnHeaderView(table);
		
		
	}
	//Funcion para establecer puntaje del lanzamiento
	public int puntaje(ArrayList<Integer>puntajes) {
		ArrayList<Integer>P = new ArrayList<Integer>();
		for(int i=1; i<=6; i++) {
			P.add(i);
			int cont = 0;
			for(int j=0; j<puntajes.size(); j++) {
				if(puntajes.get(j)==i) {
					cont++;
				}
			}
			P.add(cont);
		}
		System.out.println(P.toString());
		
		int puntos = 0;
		puntos = puntos+P.get(1)*100+P.get(9)*50;
		if(P.get(1)==5 || P.get(3)==5 || P.get(5)==5 || P.get(7)==5 || P.get(9)==5 || P.get(11)==5) {
			System.out.println("SE TERMINO EL JUEGO");
		}else if(P.get(3)==3 || P.get(5)==3 || P.get(7)==3 || P.get(11)==3) {
			if(P.get(3)==3) {
				puntos = puntos+P.get(2)*100;
			}else if(P.get(5)==3) {
				puntos = puntos+P.get(4)*100;
			}else if(P.get(7)==3) {
				puntos = puntos+P.get(6)*100;
			}else if(P.get(11)==3) {
				puntos = puntos+P.get(10)*100;
			}else {
				System.out.println("ERROR");
			}
		}else if(P.get(3)==4 || P.get(5)==4 || P.get(7)==4 || P.get(11)==4) {
			if(P.get(3)==4) {
				puntos = puntos+(P.get(2)*100*P.get(2));
			}else if(P.get(5)==4) {
				puntos = puntos+(P.get(4)*100*P.get(4));
			}else if(P.get(7)==4) {
				puntos = puntos+(P.get(6)*100*P.get(6));
			}else if(P.get(11)==4) {
				puntos = puntos+(P.get(10)*100*P.get(10));
			}else {
				System.out.println("ERROR");
			}
		}
		return puntos;
	}
}