package br.edu.udc.gui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.udc.formas.FormaGeometrica;

public class PainelDesenho extends JPanel implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	private JLabel status;
	
	private FormaGeometrica formaAtual;
	
	private List<FormaGeometrica> listaFormas = new LinkedList<FormaGeometrica>();
	
	public PainelDesenho(JLabel status) {
		this.status = status;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		formaAtual = null;
	}
	
	public void formaAtual(FormaGeometrica forma) {
		formaAtual = forma;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		if (formaAtual != null)
			formaAtual.getManipulador().desenhar(g);
		
		for(FormaGeometrica f : listaFormas) {
			f.getManipulador().desenhar(g);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		String message = String.format("Mouse arrastado em [%d; %d]", e.getX(), e.getY());
		if (formaAtual != null)
			message = message + ": desenhando " + formaAtual.getNome() + " em " + formaAtual; 
		status.setText(message);		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (formaAtual != null) {
			formaAtual.getManipulador().mover(e.getX(), e.getY());
			repaint();
		}
		
		String message = String.format("Mouse movimentado em [%d; %d]", e.getX(), e.getY());
		if (formaAtual != null)
			message = message + ": desenhando " + formaAtual.getNome() + " em " + formaAtual; 
		status.setText(message);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (formaAtual != null) {
			if(formaAtual.getManipulador().click(e.getX(), e.getY())) {
				listaFormas.add(formaAtual);
				formaAtual = formaAtual.clone();
			}
			
			repaint();
		}
		
		String message = String.format("Bot�o apertado em [%d; %d]", e.getX(), e.getY());
		if (formaAtual != null)
			message = message + ": desenhando " + formaAtual.getNome() + " em " + formaAtual; 
		status.setText(message);		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		String message = String.format("Mouse entrou no painel em [%d; %d]", e.getX(), e.getY());
		if (formaAtual != null)
			message = message + ": desenhando " + formaAtual.getNome() + " em " + formaAtual; 
		status.setText(message);		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		String message = String.format("Mouse saiu do painel em [%d; %d]", e.getX(), e.getY());
		if (formaAtual != null)
			message = message + ": desenhando " + formaAtual.getNome() + " em " + formaAtual; 
		status.setText(message);		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		String message = String.format("Bot�o pressionado em [%d; %d]", e.getX(), e.getY());
		if (formaAtual != null)
			message = message + ": desenhando " + formaAtual.getNome() + " em " + formaAtual; 
		status.setText(message);		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		String message = String.format("Bot�o solto em [%d; %d]", e.getX(), e.getY());
		if (formaAtual != null)
			message = message + ": desenhando " + formaAtual.getNome() + " em " + formaAtual; 
		status.setText(message);		
	}

	
}
