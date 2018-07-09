package Pruebas;

import java.util.ArrayList;

import acm.program.*;
import acm.util.RandomGenerator;

public class CambioDados extends ConsoleProgram{
	
	ArrayList<Integer>lista = new ArrayList<Integer>();
	RandomGenerator ranGen = RandomGenerator.getInstance();
	
	int valor1 = ranGen.nextInt(1,6);
	int valor2 = ranGen.nextInt(1,6);
	int valor3 = ranGen.nextInt(1,6);
	int valor4 = ranGen.nextInt(1,6);
	int valor5 = ranGen.nextInt(1,6);
	
	public void run(){
		lista.add(valor1);
		lista.add(valor2);
		lista.add(valor3);
		lista.add(valor4);
		lista.add(valor5);
	}
	
	public void puntaje(int a){
		
	}
	
	public void dados(){
		for(int i=0; i<lista.size(); i++){
			
		}
	}
}
