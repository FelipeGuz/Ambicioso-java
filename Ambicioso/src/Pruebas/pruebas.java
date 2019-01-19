package Pruebas;

import java.util.ArrayList;

import acm.graphics.GRect;
import acm.program.*;
import acm.util.RandomGenerator;

public class pruebas extends ConsoleProgram{
	
	ArrayList<Integer>lista = new ArrayList<Integer>();
	ArrayList<Integer>listaF = new ArrayList<Integer>();
	RandomGenerator ranGen = RandomGenerator.getInstance();
	int valor1 = ranGen.nextInt(1,6);
	int valor2 = ranGen.nextInt(1,6);
	int valor3 = ranGen.nextInt(1,6);
	int valor4 = ranGen.nextInt(1,6);
	int valor5 = ranGen.nextInt(1,6);
//	int valor1 = 1;
//	int valor2 = 3;
//	int valor3 = 3;
//	int valor4 = 3;
//	int valor5 = 3;
	
	public void run(){
		lista.add(valor1);
		lista.add(valor2);
		lista.add(valor3);
		lista.add(valor4);
		lista.add(valor5);
		busqueda();
	}
	
	public void busqueda(){
		int numero;
		int cantidad;
		int puntaje = 0;
		
		int repeticion = 1;
		int contador = 0;
		println(lista);
		int tamano = lista.size();
		while(contador<tamano){
			int valor = lista.get(0);
			for(int i=1; i<lista.size(); i++){
				if(valor==lista.get(i)){
					repeticion++;
					lista.remove(i);
					tamano--;
					i--;
				}
			}
			listaF.add(lista.get(0));
			listaF.add(repeticion);
			repeticion  = 1;
			lista.remove(0);
			contador++;
		}
		for(int i=0; i<listaF.size();i+=2){
			numero = listaF.get(i);
			cantidad = listaF.get(i+1);
			if(cantidad==3){
				puntaje += numero*100;
			}else if(cantidad == 4){
				puntaje += (numero*100)*numero;
			}else if(numero == 1 || numero == 5){
				if(numero==1){
					puntaje += 100*cantidad; 
				}else{
					puntaje += 50*cantidad; 
				}
			}else if(cantidad==5){
				println("5 valores iguales, se termino el juego");
			}
		}
		println("Lista final: "+listaF);
		println("El puntaje es: "+puntaje);
		lista.clear();
		println(lista);
	}
	
	public void puntaje(){
		for(int i=0; i<lista.size();i++){
			busqueda();
		}
	}
	
	public int funcion(int a){
		int u = a;
		for(int i=0; i<10; i++){
			u = u*i;
		}
		return u;
	}
}
