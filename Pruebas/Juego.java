package Pruebas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import acm.program.*;
import acm.util.RandomGenerator;
import acm.graphics.*;

public class Juego extends GraphicsProgram{
	
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
	/*
	 * VARIABLES:
	 */
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
	
	//Cuadrados de decoracion (fondo)
	GRect sup= new GRect(1366,206); 
	GRect inf = new GRect(1366,206);
	GRect med = new GRect(1366,356);
	
	int cantidadJugadores; //Variable que guarda la cantidad de jugadores
	int puntajeInicio; //Variable que guarda el puntaje a alcanzar
	int puntajeDados; //Variable que almacena el puntaje logrado por los dados
	int valor_dado;
	
	//Listas donde se agregan los GOval de cada cara de los dados para poder borrarlos por jugada
	ArrayList<GOval> primero = new ArrayList<GOval>();
	ArrayList<GOval> segundo = new ArrayList<GOval>();
	ArrayList<GOval> tercero = new ArrayList<GOval>();
	ArrayList<GOval> cuarto = new ArrayList<GOval>();
	ArrayList<GOval> quinto = new ArrayList<GOval>();
	
	//Listas de puntajes:
	ArrayList<Integer>listaPuntaje = new ArrayList<Integer>();
	ArrayList<Integer>listaFPuntaje = new ArrayList<Integer>();
	
	//Valores de los dados que salieron
	int dado_1;
	int dado_2;
	int dado_3;
	int dado_4;
	int dado_5;
	
	//Variables de los GOval que salen
	GOval cara1;
	GOval cara2;
	GOval cara3;
	GOval cara4;
	GOval cara5;
	GOval cara6;
	
	GLabel titulo = new GLabel("AMBICIOSO"); //Titulo del juego
	GLabel jugadores = new GLabel("Cantidad de jugadores: "+cantidadJugadores); 
	
	GLabel puntajeInicial = new GLabel("Puntaje con el que se comienza: "+puntajeInicio);
	JButton mas_puntos = new JButton("Mas puntos"); //Boton mas puntos inicio
	JButton menos_puntos = new JButton("Menos puntos"); //Boton menos puntos inicio
	
	JButton mas_jugadores = new JButton("Mas Jugadores"); //Boton mas jugadores
	JButton menos_jugadores = new JButton("Menos Jugadores"); //Boton menos jugadores
	JButton continuar = new JButton("CONTINUAR"); //Boton continuar
	
	JButton tirar = new JButton("Tirar Dados"); //Boton para tirar los dados
	GLabel puntajeTotalDados = new GLabel("Puntaje: "+puntajeDados);
	//Dados
	GRect dado1 = new GRect(80,80);
	GRect dado2 = new GRect(80,80);
	GRect dado3 = new GRect(80,80);
	GRect dado4 = new GRect(80,80);
	GRect dado5 = new GRect(80,80);
	
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
	/*
	 * FUNCIONES:
	 */
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
	
	public void run(){
		setSize(1366,768); //Tamaño de la pagina
		fondoBase();
		inicio();
		addActionListeners();
		//Prubas para github
	}
	
	public void fondoBase(){
		//Cuadro superior (Fondo)
		sup.setFilled(true);
		sup.setColor(new Color(255,230,0));
		sup.sendToBack();
		add(sup,0,0);
				
		//Cuadro inferior (Fondo)
		inf.setFilled(true);
		inf.setColor(new Color(255,230,0));
		inf.sendToBack();
		add(inf,0,562);
				
		//Cuadro medio (Fondo)
		med.setFilled(true);
		med.setColor(Color.YELLOW);
		med.sendToBack();
		add(med,0,206);
				
		//Titulo del juego (Letrero)
		titulo.sendToFront();
		titulo.setFont("SansSerif-bold-80");
		add(titulo,460,103);
	}
	
	//Funci�n inicio del juego: Bienvenida, Cantidad de jugadores, Cantidad de puntos a jugar.
	public void inicio(){
		
		//Puntaje Inicial del juego (Letrero)
		puntajeInicial.setFont("SansSerif-bold-40");
		add(puntajeInicial,100,430);
		
		//Numero de jugadores (Letrero)
		jugadores.setFont("SansSerif-bold-40");
		add(jugadores,267,300);
		
		add(mas_jugadores,840,254); //Boton que aumenta la cantidad de jugadores
		add(menos_jugadores,840,294); //Boton que reduce la cantidad de jugadores
		
		add(mas_puntos,840,380);  //Boton que aumenta el puntaje inicial para jugar
		add(menos_puntos,840,420); //Boton que reduce el puntaje inicial para jugar
		add(continuar,640,500); //Boton que elimina todo y muestra los dados
		add(tirar,280,400);
		tirar.setVisible(false);
	}
	
	//Funci�n que agrega los dados al oprimir "Continuar"
	public void dados(double X, double Y){
		puntajeTotalDados.setFont("SansSerif-bold-40");
		add(puntajeTotalDados,600,270);
		
		add(dado1,X,Y); //Dado #1
		dado1.setFilled(true);
		dado1.setColor(Color.white);
		
		add(dado2,X+90, Y); //Dado #2
		dado2.setFilled(true);
		dado2.setColor(Color.white);
		
		add(dado3,X+180, Y); //Dado #3
		dado3.setFilled(true);
		dado3.setColor(Color.white);
		
		add(dado4,X+270, Y); //Dado #4
		dado4.setFilled(true);
		dado4.setColor(Color.white);
		
		add(dado5,X+360, Y); //Dado #5
		dado5.setFilled(true);
		dado5.setColor(Color.white);
	}
	
	//Metodo que da la funcion del boton "Mas", "Menos", "Continuar"
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Mas Jugadores")){ //Si se oprime "Mas Jugadores aumenta la cantidad (Inicio del juego)"
			if(cantidadJugadores>=0 && cantidadJugadores<5){
				cantidadJugadores = cantidadJugadores+1;
				jugadores.setLabel("Cantidad de jugadores: "+cantidadJugadores);
			}
		}else if(e.getActionCommand().equals("Menos Jugadores")){ //Si se oprime reduce la cantidad de jugadores (Inicio del juego)
			if(cantidadJugadores>0 && cantidadJugadores<=5){
				cantidadJugadores = cantidadJugadores-1;
				jugadores.setLabel("Cantidad de jugadores: "+cantidadJugadores);
			}
		}else if(e.getActionCommand().equals("Mas puntos")){ //Aumenta la cantidad de puntos iniciales (Inicio del juego)
			if(puntajeInicio>=0 && puntajeInicio<10000){
				puntajeInicio = puntajeInicio+1000;
				puntajeInicial.setLabel("Puntaje con el que se comienza: "+puntajeInicio);
			}
		}else if(e.getActionCommand().equals("Menos puntos")){//Reduce la cantidad de puntos iniciales (Inicio del juego)
			if(puntajeInicio>0 && puntajeInicio<=10000){
				puntajeInicio = puntajeInicio-1000;
				puntajeInicial.setLabel("Puntaje con el que se comienza: "+puntajeInicio);
			}
		}else if(e.getActionCommand().equals("CONTINUAR")){ //Boton continuar 
			remove(jugadores);
			remove(puntajeInicial);
			mas_puntos.setVisible(false);
			menos_puntos.setVisible(false);
			mas_jugadores.setVisible(false);
			menos_jugadores.setVisible(false);
			continuar.setVisible(false);
			dados(100,270);
			tirar.setVisible(true);
		}else if(e.getActionCommand().equals("Tirar Dados")){ //Tira los dados 
			//removeAll();
			//fondoBase();
			borrarElementosLista(primero);
			borrarElementosLista(segundo);
			borrarElementosLista(tercero);
			borrarElementosLista(cuarto);
			borrarElementosLista(quinto);
			
			carasDado(dado1,primero); //Asigna un valor al dado
			dado_1 = valor_dado; //Guarda el valor del dado que le salio
			carasDado(dado2,segundo);
			dado_2 = valor_dado;
			carasDado(dado3,tercero);
			dado_3 = valor_dado;
			carasDado(dado4,cuarto);
			dado_4 = valor_dado;
			carasDado(dado5,quinto);
			dado_5 = valor_dado;
			puntaje();
		}
	}

//Metodo que asigna los puntos segun la cara del dado
	public void puntaje(){
		int numero;
		int cantidad;
		
		listaPuntaje.add(dado_1);
		listaPuntaje.add(dado_2);
		listaPuntaje.add(dado_3);
		listaPuntaje.add(dado_4);
		listaPuntaje.add(dado_5);
		
//Busca las repeticiones de los valores que salieron en los dados
		int repeticion = 1;
		int contador = 0;
		int tamano = listaPuntaje.size();
		while(contador<tamano){
			int valor = listaPuntaje.get(0);
			for(int i=1; i<listaPuntaje.size(); i++){
				if(valor==listaPuntaje.get(i)){
					repeticion++;
					listaPuntaje.remove(i);
					tamano--;
					i--;
				}
			}
			listaFPuntaje.add(listaPuntaje.get(0));
			listaFPuntaje.add(repeticion);
			repeticion  = 1;
			listaPuntaje.remove(0);
			contador++;
		}
//Asigna los puntajes segun la lista listaFPuntaje 
//(valores impares el valor, valores pares la cantidad de valores del valor)
		for(int i=0; i<listaFPuntaje.size();i+=2){
			numero = listaFPuntaje.get(i);
			cantidad = listaFPuntaje.get(i+1);
			if(cantidad==3){
				puntajeDados += numero*100;
				puntajeTotalDados.setLabel("Puntaje: "+puntajeDados);
			}else if(cantidad == 4){
				puntajeDados += (numero*100)*numero;
				puntajeTotalDados.setLabel("Puntaje: "+puntajeDados);
			}else if(numero == 1 || numero == 5){
				if(numero==1){
					puntajeDados += 100*cantidad; 
					puntajeTotalDados.setLabel("Puntaje: "+puntajeDados);
				}else{
					puntajeDados += 50*cantidad; 
					puntajeTotalDados.setLabel("Puntaje: "+puntajeDados);
				}
			}else if(cantidad==5){
				puntajeDados = 1000000000; 
			}
		}
		listaPuntaje.clear();
		listaFPuntaje.clear();
	}
	

	
//Metodo que le da la forma a los dados
	public void carasDado(GRect obj, ArrayList<GOval> asignacion){
		double X = obj.getX();
		double Y = obj.getY();
		double h = obj.getHeight();
		double w = obj.getWidth();
		
		cara1 = new GOval(0,0);
		cara2 = new GOval(0,0);
		cara3 = new GOval(0,0);
		cara4 = new GOval(0,0);
		cara5 = new GOval(0,0);
		cara6 = new GOval(0,0);
		
		RandomGenerator ranGen = RandomGenerator.getInstance();
		int cara = ranGen.nextInt(1,6);
		valor_dado = cara;
		//int cara=2;
		switch(cara){
		case 1:
			
			asignacion.add(cara1);
			
			cara1.setSize(w/3,w/3);
			
			add(cara1,X+(w/3),Y+(w/3));
			
			cara1.sendToFront();
			cara1.setFilled(true);
			cara1.setColor(Color.BLACK);
			break;
		case 2:
			
			asignacion.add(cara1);
			asignacion.add(cara2);
			
			cara1.setSize(w/3,w/3);
			cara2.setSize(w/3,w/3);
			
			add(cara1,X+((w/6)*3),Y+((h/6)*1));
			add(cara2,X+((w/6)*1),Y+((h/6)*3));
			
			cara1.setFilled(true);
			cara1.setColor(Color.BLACK);
			cara2.setFilled(true);
			cara2.setColor(Color.BLACK);
			break;
		case 3:
			
			asignacion.add(cara1);
			asignacion.add(cara2);
			asignacion.add(cara3);
			
			cara1.setSize(w/4,w/4);
			cara2.setSize(w/4,w/4);
			cara3.setSize(w/4,w/4);
			
			add(cara1,X+((w/5)*1),Y+((w/5)*3));
			add(cara2,X+((w/5)*2),Y+((w/5)*2));
			add(cara3,X+((w/5)*3),Y+((w/5)*1));
			
			cara1.setFilled(true);
			cara1.setColor(Color.BLACK);
			cara2.setFilled(true);
			cara2.setColor(Color.BLACK);
			cara3.setFilled(true);
			cara3.setColor(Color.BLACK);
			break;
		case 4:
			
			asignacion.add(cara1);
			asignacion.add(cara2);
			asignacion.add(cara3);
			asignacion.add(cara4);
			
			cara1.setSize(w/4,w/4);
			cara2.setSize(w/4,w/4);
			cara3.setSize(w/4,w/4);
			cara4.setSize(w/4,w/4);
			
			add(cara1,X+(w/5)*1,Y+(h/5)*1);
			add(cara2,X+(w/5)*3,Y+(h/5)*1);
			add(cara3,X+(w/5)*1,Y+(h/5)*3);
			add(cara4,X+(w/5)*3,Y+(h/5)*3);
			
			cara1.setFilled(true);
			cara1.setColor(Color.BLACK);
			cara2.setFilled(true);
			cara2.setColor(Color.BLACK);
			cara3.setFilled(true);
			cara3.setColor(Color.BLACK);
			cara4.setFilled(true);
			cara4.setColor(Color.BLACK);
			break;
		case 5:
			
			asignacion.add(cara1);
			asignacion.add(cara2);
			asignacion.add(cara3);
			asignacion.add(cara4);
			asignacion.add(cara5);
			
			cara1.setSize(w/4,w/4);
			cara2.setSize(w/4,w/4);
			cara3.setSize(w/4,w/4);
			cara4.setSize(w/4,w/4);
			cara5.setSize(w/4,w/4);
			
			add(cara1,X+(w/5)*1,Y+(h/5)*1);
			add(cara2,X+(w/5)*3,Y+(h/5)*1);
			add(cara3,X+(w/5)*1,Y+(h/5)*3);
			add(cara4,X+(w/5)*3,Y+(h/5)*3);
			add(cara5,X+(w/5)*2,Y+(h/5)*2);
			
			cara1.setFilled(true);
			cara1.setColor(Color.BLACK);
			cara2.setFilled(true);
			cara2.setColor(Color.BLACK);
			cara3.setFilled(true);
			cara3.setColor(Color.BLACK);
			cara4.setFilled(true);
			cara4.setColor(Color.BLACK);
			cara5.setFilled(true);
			cara5.setColor(Color.BLACK);
			break;
		case 6:
			
			asignacion.add(cara1);
			asignacion.add(cara2);
			asignacion.add(cara3);
			asignacion.add(cara4);
			asignacion.add(cara5);
			asignacion.add(cara6);
			
			cara1.setSize(w/4,w/4);
			cara2.setSize(w/4,w/4);
			cara3.setSize(w/4,w/4);
			cara4.setSize(w/4,w/4);
			cara5.setSize(w/4,w/4);
			cara6.setSize(w/4,w/4);
			
			add(cara1,X+(w/7)*1.5,Y+(h/7)*0.7);
			add(cara2,X+(w/7)*1.5,Y+(h/7)*2.7);
			add(cara3,X+(w/7)*1.5,Y+(h/7)*4.7);
			add(cara4,X+(w/7)*4,Y+(h/7)*0.7);
			add(cara5,X+(w/7)*4,Y+(h/7)*2.7);
			add(cara6,X+(w/7)*4,Y+(h/7)*4.7);
			
			cara1.setFilled(true);
			cara1.setColor(Color.BLACK);
			cara2.setFilled(true);
			cara2.setColor(Color.BLACK);
			cara3.setFilled(true);
			cara3.setColor(Color.BLACK);
			cara4.setFilled(true);
			cara4.setColor(Color.BLACK);
			cara5.setFilled(true);
			cara5.setColor(Color.BLACK);
			cara6.setFilled(true);
			cara6.setColor(Color.BLACK);
			break;
		}
	}
	
	
	public void borrarElementosLista(ArrayList<GOval> lista){
		for(int i=0; i<lista.size(); i++){
			remove(lista.get(i));
		}
	}
}


/*
 * COSAS PENDIENTES:
 * -> mantencion de valores de los dados que dan puntos
 * -> Botones para el cambio de jugador
 * -> Crear un Excel o Bloc de notas para almasenar a los jugadores y el puntaje
 */
