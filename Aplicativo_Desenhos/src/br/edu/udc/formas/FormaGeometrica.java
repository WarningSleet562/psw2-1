package br.edu.udc.formas;

import java.awt.Graphics;
import java.io.Serializable;

public interface FormaGeometrica extends Serializable {

	Ponto centro();
	double area();
	double perimetro();
	double base();
	double altura();
	double distancia(FormaGeometrica f);
	
	String toString();
	String getNome();
	
	Ponto getEnd();
	Ponto getStart();
	 
	FormaGeometrica clone();
	
	void desenhar(Graphics g);
}
