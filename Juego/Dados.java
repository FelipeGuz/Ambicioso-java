package Juego;

import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GCanvas;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import Juego.*;
import basicJuego.*;

public class Dados {
	
	GRect obj;
	GCanvas canvas;
	ArrayList<GOval>eliminarDado;
	
	public Dados(GRect obj,GCanvas canvas) {
		this.obj = obj;
		this.canvas = canvas;
		this.eliminarDado = new ArrayList<GOval>();
	}
	
	public int carasDado(){
		double X = obj.getX();
		double Y = obj.getY();
		double h = obj.getHeight();
		double w = obj.getWidth();
		RandomGenerator ranGen = RandomGenerator.getInstance();
		int cara = ranGen.nextInt(1,6);
		//int cara=6;
		switch(cara){
		case 1:
			GOval cara1 = new GOval(w/3,h/3);
			
			canvas.add(cara1,X+(w/3),Y+(w/3));
			
			cara1.sendToFront();
			cara1.setFilled(true);
			cara1.setColor(Color.BLACK);
			eliminarDado.add(cara1);
			break;
		case 2:
			GOval cara2 = new GOval(w/3,h/3);
			GOval cara2_1 = new GOval(w/3,h/3);
			
			canvas.add(cara2,X+((w/6)*3),Y+((h/6)*1));
			canvas.add(cara2_1,X+((w/6)*1),Y+((h/6)*3));
			
			cara2.setFilled(true);
			cara2.setColor(Color.BLACK);
			cara2_1.setFilled(true);
			cara2_1.setColor(Color.BLACK);
			eliminarDado.add(cara2);
			eliminarDado.add(cara2_1);
			break;
		case 3:
			GOval cara3 = new GOval(w/4,h/4);
			GOval cara3_1 = new GOval(w/4,h/4);
			GOval cara3_2 = new GOval(w/4,h/4);
			
			canvas.add(cara3,X+((w/5)*1),Y+((w/5)*3));
			canvas.add(cara3_1,X+((w/5)*2),Y+((w/5)*2));
			canvas.add(cara3_2,X+((w/5)*3),Y+((w/5)*1));
			
			cara3.setFilled(true);
			cara3.setColor(Color.BLACK);
			cara3_1.setFilled(true);
			cara3_1.setColor(Color.BLACK);
			cara3_2.setFilled(true);
			cara3_2.setColor(Color.BLACK);
			eliminarDado.add(cara3);
			eliminarDado.add(cara3_1);
			eliminarDado.add(cara3_2);
			break;
		case 4:
			GOval cara4 = new GOval(w/4,h/4);
			GOval cara4_1 = new GOval(w/4,h/4);
			GOval cara4_2 = new GOval(w/4,h/4);
			GOval cara4_3 = new GOval(w/4,h/4);
			
			canvas.add(cara4,X+(w/5)*1,Y+(h/5)*1);
			canvas.add(cara4_1,X+(w/5)*3,Y+(h/5)*1);
			canvas.add(cara4_2,X+(w/5)*1,Y+(h/5)*3);
			canvas.add(cara4_3,X+(w/5)*3,Y+(h/5)*3);
			
			cara4.setFilled(true);
			cara4.setColor(Color.BLACK);
			cara4_1.setFilled(true);
			cara4_1.setColor(Color.BLACK);
			cara4_2.setFilled(true);
			cara4_2.setColor(Color.BLACK);
			cara4_3.setFilled(true);
			cara4_3.setColor(Color.BLACK);
			eliminarDado.add(cara4);
			eliminarDado.add(cara4_1);
			eliminarDado.add(cara4_2);
			eliminarDado.add(cara4_3);
			break;
		case 5:
			GOval cara5 = new GOval(w/4,h/4);
			GOval cara5_1 = new GOval(w/4,h/4);
			GOval cara5_2 = new GOval(w/4,h/4);
			GOval cara5_3 = new GOval(w/4,h/4);
			GOval cara5_4 = new GOval(w/4,h/4);
			
			canvas.add(cara5,X+(w/5)*1,Y+(h/5)*1);
			canvas.add(cara5_1,X+(w/5)*3,Y+(h/5)*1);
			canvas.add(cara5_2,X+(w/5)*1,Y+(h/5)*3);
			canvas.add(cara5_3,X+(w/5)*3,Y+(h/5)*3);
			canvas.add(cara5_4,X+(w/5)*2,Y+(h/5)*2);
			
			cara5.setFilled(true);
			cara5.setColor(Color.BLACK);
			cara5_1.setFilled(true);
			cara5_1.setColor(Color.BLACK);
			cara5_2.setFilled(true);
			cara5_2.setColor(Color.BLACK);
			cara5_3.setFilled(true);
			cara5_3.setColor(Color.BLACK);
			cara5_4.setFilled(true);
			cara5_4.setColor(Color.BLACK);
			eliminarDado.add(cara5);
			eliminarDado.add(cara5_1);
			eliminarDado.add(cara5_2);
			eliminarDado.add(cara5_3);
			eliminarDado.add(cara5_4);
			break;
		case 6:
			GOval cara6 = new GOval(w/4,h/4);
			GOval cara6_1 = new GOval(w/4,h/4);
			GOval cara6_2 = new GOval(w/4,h/4);
			GOval cara6_3 = new GOval(w/4,h/4);
			GOval cara6_4 = new GOval(w/4,h/4);
			GOval cara6_5 = new GOval(w/4,h/4);
			
			canvas.add(cara6,X+(w/7)*1.5,Y+(h/7)*0.7);
			canvas.add(cara6_1,X+(w/7)*1.5,Y+(h/7)*2.7);
			canvas.add(cara6_2,X+(w/7)*1.5,Y+(h/7)*4.7);
			canvas.add(cara6_3,X+(w/7)*4,Y+(h/7)*0.7);
			canvas.add(cara6_4,X+(w/7)*4,Y+(h/7)*2.7);
			canvas.add(cara6_5,X+(w/7)*4,Y+(h/7)*4.7);
			
			cara6.setFilled(true);
			cara6.setColor(Color.BLACK);
			cara6_1.setFilled(true);
			cara6_1.setColor(Color.BLACK);
			cara6_2.setFilled(true);
			cara6_2.setColor(Color.BLACK);
			cara6_3.setFilled(true);
			cara6_3.setColor(Color.BLACK);
			cara6_4.setFilled(true);
			cara6_4.setColor(Color.BLACK);
			cara6_5.setFilled(true);
			cara6_5.setColor(Color.BLACK);
			eliminarDado.add(cara6);
			eliminarDado.add(cara6_1);
			eliminarDado.add(cara6_2);
			eliminarDado.add(cara6_3);
			eliminarDado.add(cara6_4);
			eliminarDado.add(cara6_5);
			break;
			
		}
		return cara;
	}
	
	public void eliminarDados(){
		for(int i=0; i<eliminarDado.size(); i++) {
			eliminarDado.get(i).setVisible(false);
		}
	}
}
