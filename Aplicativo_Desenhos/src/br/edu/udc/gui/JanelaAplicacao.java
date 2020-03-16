package br.edu.udc.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.edu.udc.formas.Linha;
import br.edu.udc.formas.Ponto;
import br.edu.udc.formas.Retangulo;
import br.edu.udc.formas.Triangulo;

public class JanelaAplicacao extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public JanelaAplicacao() {
		super("Desenhos com o mouse");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 700);
		this.setLayout(new BorderLayout());
	
		JLabel status = new JLabel("Mensagens de evento do mouse");
		this.add(status, BorderLayout.SOUTH);
		
		PainelDesenho painel = new PainelDesenho(status);
		this.add(painel, BorderLayout.CENTER);
		
		
		/* Comandos do Menu */
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		menuBar.add(mnArquivo);
		
		JMenu mnFiguras = new JMenu("Figuras");
		mnFiguras.setMnemonic('F');
		menuBar.add(mnFiguras);
		
		JMenuItem mntmPonto = new JMenuItem("Ponto");
		mntmPonto.setMnemonic('P');
		mntmPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel.formaAtual(new Ponto(-1, -1));
			}
		});
		mnFiguras.add(mntmPonto);
		
		JMenuItem mntmLinha = new JMenuItem("Linha");
		mntmLinha.setMnemonic('L');
		mntmLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel.formaAtual(new Linha(new Ponto(-1, -1), new Ponto(-1, -1)));
			}
		});
		mnFiguras.add(mntmLinha);
		
		JMenuItem mntmTriangulo = new JMenuItem("Triangulo");
		mntmTriangulo.setMnemonic('T');
		mntmTriangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel.formaAtual(new Triangulo(new Ponto(-1, -1), new Ponto(-1, -1), new Ponto(-1, -1)));
			}
		});
		mnFiguras.add(mntmTriangulo);
		
		JMenuItem mntmRetangulo = new JMenuItem("Retangulo");
		mntmRetangulo.setMnemonic('R');
		mntmRetangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel.formaAtual(new Retangulo(new Ponto(-1, -1), new Ponto(-1, -1)));
			}
		});
		mnFiguras.add(mntmRetangulo);
	}

}
