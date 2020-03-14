package br.edu.udc.formas;

import java.awt.Graphics;

public class Triangulo implements FormaGeometrica {
	private static final long serialVersionUID = 1L;
	private Ponto a;
	private Ponto b;
	private Ponto c;
	
	public Triangulo(Ponto a, Ponto b, Ponto c) {
		this.a = a.clone();
		this.b = b.clone();
		this.c = c.clone();
	}
	
	public Triangulo(Triangulo t) {
		this.a = t.a.clone();
		this.b = t.b.clone();
		this.c = t.c.clone();
	}
	
	public void setA(Ponto a) {
		this.a = a.clone();
	}
	
	public void setB(Ponto b) {
		this.b = b.clone();
	}
	
	public void setC(Ponto c) {
		this.c = c.clone();
	}
	
	@Override
	public Ponto centro() {
		return new Ponto((a.getX() + b.getX() + c.getX()) / 3, (a.getY() + b.getY() + c.getY()) / 3);
	}

	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimetro() {
		return a.distancia(b) + b.distancia(c) + c.distancia(a);
	}

	@Override
	public double base() {
		return 0;
	}

	@Override
	public double altura() {
		return 0;
	}

	@Override
	public double distancia(FormaGeometrica f) {
		Ponto cf = f.centro();
		Ponto ct = centro();
		
		int dx = ct.getX() - cf.getX();
		int dy = ct.getY() - cf.getY();
		
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	@Override
	public String toString() {
		return String.format("A: [%d, %d] / B: [%d, %d] / C: [%d, %d]", a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY());
	}
	
	@Override
	public String getNome() {
		return "Tri�ngulo";
	}

	@Override
	public Ponto getEnd() {
		/* Verificar / Corrigir */
		return new Ponto(a.getX() > b.getX() ? (a.getX() > c.getX() ? a.getX() : c.getX()) : b.getX() > c.getX() ? b.getX() : c.getX(), 
						 a.getY() > b.getY() ? (a.getY() > c.getY() ? a.getY() : c.getX()) : b.getY() > c.getY() ? b.getY() : c.getY());
	}

	@Override
	public Ponto getStart() {
		/* Verificar / Corrigir */
		return new Ponto(a.getX() < b.getX() ? (a.getX() < c.getX() ? a.getX() : (b.getX() < c.getX() ? b.getX() : c.getX())) : b.getX() < c.getX() ? b.getX() : c.getX(), 
				 		 a.getY() < b.getY() ? (a.getY() < c.getY() ? a.getY() : (b.getY() < c.getY() ? b.getY() : c.getY())) : b.getY() < c.getY() ? b.getY() : c.getY());
	}

	@Override
	public FormaGeometrica clone() {
		return new Triangulo(this);
	}
	
	@Override
	public void desenhar(Graphics g) {
		g.drawLine(a.getX(), a.getY(), b.getX(), b.getY());
		g.drawLine(b.getX(), b.getY(), c.getX(), c.getY());
		g.drawLine(c.getX(), c.getY(), a.getX(), a.getY());
	}

}
