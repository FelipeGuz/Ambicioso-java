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
	private GCanvas gc1;//Canvas del dado 1
	private GCanvas gc2;//Canvas del dado 2
	private GCanvas gc3;//Canvas del dado 3
	private GCanvas gc4;//Canvas del dado 4
	private GCanvas gc5;//Canvas del dado 5
	
	//Paneles para insertar los GRect
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	
	private GRect sqr1; //GRect del dado 1
	private GRect sqr2; //GRect del dado 2
	private GRect sqr3; //GRect del dado 3
	private GRect sqr4; //GRect del dado 4
	private GRect sqr5; //GRect del dado 5
	
	Dados dado1 = new Dados(sqr1,gc1);//Dado 1
	Dados dado2 = new Dados(sqr2,gc2);//Dado 2
	Dados dado3 = new Dados(sqr3,gc3);;//Dado 3
	Dados dado4 = new Dados(sqr4,gc4);;//Dado 4
	Dados dado5 = new Dados(sqr5,gc5);;//Dado 5
	
	private JLabel labelPuntaje; //Label "Punatje"
	private JLabel labelPuntajeNum; //Label que representa el puntaje del jugador por partida
	private JButton btnTirarDado;
	private JTable table;
	
	ArrayList<Integer>listaPuntaje = new ArrayList<Integer>(); //Lista de tamaño 5 con cada valor de los dados
	ArrayList<Integer>listaFPuntaje = new ArrayList<Integer>(); //Lista de tamao 12, valores impares numeros 1 al 6 y valores impares repeticiones de los numeros
	ArrayList<Integer>dadosRepeticion = new ArrayList<Integer>(); //index de las repeticiones en la listaPuntaje
	ArrayList<Dados>DADOS = new ArrayList<Dados>(); //Lista de tamaño 5 con los objetos de tipo Dados
	
	private int puntajeJugador;

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
		
		labelPuntaje = new JLabel("Puntaje: ");
		labelPuntaje.setFont(new Font("SansSerif", Font.PLAIN, 30));
		labelPuntaje.setBounds(222, 170, 117, 31);
		desktopPane_1.add(labelPuntaje);
		
		labelPuntajeNum = new JLabel("0");
		labelPuntajeNum.setFont(new Font("SansSerif", Font.PLAIN, 30));
		labelPuntajeNum.setBounds(349, 170, 71, 31);
		desktopPane_1.add(labelPuntajeNum);
		
		btnTirarDado = new JButton("Tirar Dado");
		btnTirarDado.setBounds(237, 234, 102, 23);
		desktopPane_1.add(btnTirarDado);
		
		btnTirarDado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("------------------------------------");
				if(dado1!=null && dado2!=null && dado3!=null && dado4!=null && dado5!=null) {
					dado1.eliminarDados();
					dado2.eliminarDados();
					dado3.eliminarDados();
					dado4.eliminarDados();
					dado5.eliminarDados();
				}
				if(dado1.getCambio()==true) {
					int n1 = dado1.carasDado();
					System.out.println(n1);
					listaPuntaje.add(n1);
				}
				DADOS.add(dado1);
				
				if(dado2.getCambio()==true) {
					int n2 = dado2.carasDado();
					listaPuntaje.add(n2);
				}
				DADOS.add(dado2);
				
				if(dado3.getCambio()==true) {
					int n3 = dado3.carasDado();
					listaPuntaje.add(n3);
				}
				DADOS.add(dado3);
				
				if(dado4.getCambio()==true) {
					int n4 = dado4.carasDado();
					listaPuntaje.add(n4);
				}
				DADOS.add(dado4);
				
				if(dado5.getCambio()==true) {
					int n5 = dado5.carasDado();
					listaPuntaje.add(n5);
				}
				DADOS.add(dado5);
				
				puntaje();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(610, 60, 537, 234);
		desktopPane_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
	}
	
	//Metodo que asigna los puntos segun la cara del dado
		public void puntaje(){
			System.out.println("Puntajes de los dados: "+listaPuntaje);
			
			int numero;
			int cantidad;
						
	//Busca las repeticiones de los valores que salieron en los dados
			int repeticion = 1;
			int contador = 0;
			int tamano = listaPuntaje.size();
			while(listaPuntaje.size()!=0){
				int valor = listaPuntaje.get(0);
				dadosRepeticion.add(0);
				for(int i=1; i<listaPuntaje.size(); i++){
					if(valor==listaPuntaje.get(i)){
						dadosRepeticion.add(i);
						repeticion++;
						
						//i--;
					}
				}
				System.out.println(dadosRepeticion);
				System.out.println("----->Puntajes de los dados: "+listaPuntaje);
				listaFPuntaje.add(listaPuntaje.get(0));
				listaFPuntaje.add(repeticion);
				for(int i=dadosRepeticion.size()-1; i>=0; i--) {
					System.out.println("----->Puntajes de los dados: "+listaPuntaje);
					System.out.println("Index a eliminar: "+dadosRepeticion.get(i));
					int eli = dadosRepeticion.get(i);
					listaPuntaje.remove(eli);
					//tamano--;
				}
				repeticion  = 1;
				//listaPuntaje.remove(0);
				contador++;
				if(DADOS.get(0).getCara()==1 || DADOS.get(0).getCara()==5 || dadosRepeticion.size()>=3) {
					for(int i=0; i<dadosRepeticion.size(); i++) {
						DADOS.get(dadosRepeticion.get(i)).setCambio(false);
						
					}
				}
				for(int i=dadosRepeticion.size()-1; i>=0; i--) {
					int temp = dadosRepeticion.get(i);
					DADOS.remove(temp);
				}
				System.out.println("----->LISTA DADOS: "+DADOS);
				dadosRepeticion.clear();
			}
			System.out.println("Lista DADOS: "+DADOS);
			System.out.println("Lista Puntaje: "+listaPuntaje);
			System.out.println("Cambio dado1: "+dado1.getCambio());
			System.out.println("Cambio dado2: "+dado2.getCambio());
			System.out.println("Cambio dado3: "+dado3.getCambio());
			System.out.println("Cambio dado4: "+dado4.getCambio());
			System.out.println("Cambio dado5: "+dado5.getCambio());
	//Asigna los puntajes segun la lista listaFPuntaje 
	//(valores impares el valor, valores pares la cantidad de valores del valor)
			for(int i=0; i<listaFPuntaje.size();i+=2){
				numero = listaFPuntaje.get(i);
				cantidad = listaFPuntaje.get(i+1);
				if(cantidad==3){
					puntajeJugador += numero*100;
				}else if(cantidad == 4){
					puntajeJugador += (numero*100)*numero;
				}else if(numero == 1 || numero == 5){
					if(numero==1){
						puntajeJugador += 100*cantidad; 
					}else{
						puntajeJugador += 50*cantidad; 
					}
				}else if(cantidad==5){
					puntajeJugador = 1000000000; 
				}
			}
			listaPuntaje.clear();
			listaFPuntaje.clear();
			labelPuntajeNum.setText(String.valueOf(puntajeJugador));
		}
}
