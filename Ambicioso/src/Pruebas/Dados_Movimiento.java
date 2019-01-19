package Pruebas;

import acm.program.*;

public class Dados_Movimiento extends ConsoleProgram{
	
	pruebas nuveo = new pruebas();
	
	public void run(){
		for(int i=0; i<180; i+=5){
			pause(50+i);
			println(i);
		}
		println("-------------------------");
		int u = nuveo.funcion(8);
		println(u);
//		for(int i=0; i<=180; i+=5){
//			println(i);
//		}
	}
}
