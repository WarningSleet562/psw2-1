package br.edu.udc.formas;

import br.edu.udc.formas.manipulador.ManipuladorForma;
import br.edu.udc.formas.manipulador.ManipuladorRetangulo;

public class Retangulo implements FormaGeometrica {
	private static final long serialVersionUID = 1L;
	private Ponto a;
	private Ponto b;
	
	private ManipuladorRetangulo manipulador = null;
	
	public Retangulo(Ponto a, Ponto b) {
		this.a = a.clone();
		this.b = b.clone();
	}
	
	public Retangulo(Retangulo r) {
		this.a = r.a.clone();
		this.b = r.b.clone();
	}
	
	public void setA(Ponto a) {
		this.a = a.clone();
	}
	
	public void setB(Ponto b) {
		this.b = b;
	}
	
	public Ponto getA() {
		return a;
	}

	public Ponto getB() {
		return b;
	}

	@Override
	public Ponto centro() {
		return new Ponto((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2);
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double base() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double altura() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double distancia(FormaGeometrica f) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		return String.format("A: [%d, %d] / B: [%d, %d]", a.getX(), a.getY(), b.getX(), b.getY());
	}
	
	@Override
	public String getNome() {
		return "Retangulo";
	}

	@Override
	public Ponto getEnd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ponto getStart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormaGeometrica clone() {
		return new Retangulo(this);
	}
	
	public ManipuladorForma getManipulador() {
		if (manipulador == null)
			manipulador = new ManipuladorRetangulo(this);
		return manipulador;
	}
}
