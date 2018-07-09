package Juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private GCanvas gc1;
	private GCanvas gc2;
	private GCanvas gc3;
	private GCanvas gc4;
	private GCanvas gc5;
	
	private GRect sqr1;
	private GRect sqr2;
	private GRect sqr3;
	private GRect sqr4;
	private GRect sqr5;
	
	Dados dado1;
	Dados dado2;
	Dados dado3;
	Dados dado4;
	Dados dado5;
	
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
		label.setBounds(349, 170, 17, 31);
		desktopPane_1.add(label);
		
		btnTirarDado = new JButton("Tirar Dado");
		btnTirarDado.setBounds(237, 234, 102, 23);
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
				dado1.carasDado();
				dado2 = new Dados(sqr1,gc2);
				dado2.carasDado();
				dado3 = new Dados(sqr1,gc3);
				dado3.carasDado();
				dado4 = new Dados(sqr1,gc4);
				dado4.carasDado();
				dado5 = new Dados(sqr1,gc5);
				dado5.carasDado();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(610, 60, 537, 234);
		desktopPane_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
	}
}
