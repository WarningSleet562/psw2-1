package br.edu.udc.formas.manipulador;

import java.awt.Graphics;

import br.edu.udc.formas.Ponto;

public class ManipuladorPonto implements ManipuladorForma {

	private Ponto ponto;
	
	public ManipuladorPonto(Ponto p) {
		ponto = p;
	}
	
	@Override
	public void desenhar(Graphics g) {
		g.drawOval(ponto.getX()-1, ponto.getY()-1, 2, 2);
	}

	@Override
	public void arrastar(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean click(int x, int y) {
		ponto.setX(x);
		ponto.setY(y);
		
		return true;
	}

}
