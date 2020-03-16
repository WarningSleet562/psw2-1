package br.edu.udc.formas.manipulador;

import java.awt.Graphics;

public interface ManipuladorForma {
	void desenhar(Graphics g);
	
	void arrastar(int x, int y);
	void mover(int x, int y);
	boolean click(int x, int y);
}
