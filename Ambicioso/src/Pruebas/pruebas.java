package Pruebas;

import acm.program.*;

public class pruebas extends ConsoleProgram{
	public pruebas(){
		
	}
	
	public int funcion(int a){
		int u = a;
		for(int i=0; i<10; i++){
			u = u*i;
		}
		return u;
	}
}
