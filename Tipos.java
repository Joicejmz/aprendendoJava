package MeuProjeto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.event.*;

public class Tipos extends JPanel{
	
	private ButtonGroup grupo;
	private JRadioButton tipo1;
	private JRadioButton tipo2;
	private JRadioButton tipo3;
	private JRadioButton tipo4;
	private JRadioButton tipo5;
	private JRadioButton tipo6;
	private JRadioButton tipo7;
	private JRadioButton tipo8;
	private JRadioButton tipo9;
	private JRadioButton tipo10;
	private JRadioButton tipo11;
	private JButton informacoes;
	private JButton limpar;
	private ImageIcon informacao;
	private JLabel janela;
	private JLabel tipoCapes;
	//private ImageIcon tipo01, tipo02, tipo03, tipo04, tipo05, tipo06, tipo07, tipo08, tipo09, tipo010, tipo011;

	
	
	
	public Tipos() {
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes() {
		setLayout(null);
		setBackground(new Color(0,100,0));
		
		
		
		
		informacao = new ImageIcon(getClass().getResource("/imagem/informacoes.png"));
		grupo = new ButtonGroup();
		
		janela = new JLabel();
		janela.setBackground(Color.white);
		
		tipoCapes = new JLabel("Conheça os tipos cadastrados - clique numa opção e aperte o botão "+"INFORMAÇÕES");
		tipoCapes.setForeground(Color.white);
		tipoCapes.setFont(new Font("Corbel", Font.BOLD, 24));
				
		tipo1 = new JRadioButton("Alimentícias/comestíveis");
		tipo1.setForeground(Color.white);
		tipo1.setBackground(new Color(0, 100,0));
		tipo1.setFont(new Font("Abadi", Font.ITALIC, 10));
		
		tipo2 = new JRadioButton("Alucinógenas");
		tipo2.setForeground(Color.white);
		tipo2.setBackground(new Color(0, 100,0));
		tipo2.setFont(new Font("Abadi", Font.ITALIC, 10));
		
		tipo3 = new JRadioButton("Aquáticas");
		tipo3.setForeground(Color.white);
		tipo3.setBackground(new Color(0, 100,0));
		tipo3.setFont(new Font("Abadi", Font.ITALIC, 10));
		
		tipo4 = new JRadioButton("Aromáticas");
		tipo4.setForeground(Color.white);
		tipo4.setBackground(new Color(0, 100,0));
		tipo4.setFont(new Font("Abadi", Font.ITALIC, 10));
		
		tipo5 = new JRadioButton("Carnívoras");
		tipo5.setForeground(Color.white);
		tipo5.setBackground(new Color(0, 100,0));
		tipo5.setFont(new Font("Abadi", Font.ITALIC, 10));
		
		tipo6 = new JRadioButton("Desconhecidas");
		tipo6.setForeground(Color.white);
		tipo6.setBackground(new Color(0, 100,0));
		tipo6.setFont(new Font("Abadi", Font.ITALIC, 10));
		
		tipo7 = new JRadioButton("Fitocosméticas");
		tipo7.setForeground(Color.white);
		tipo7.setBackground(new Color(0, 100,0));
		tipo7.setFont(new Font("Abadi", Font.ITALIC, 10));
		
		tipo8 = new JRadioButton("Medicinais");
		tipo8.setForeground(Color.white);
		tipo8.setBackground(new Color(0, 100,0));
		tipo8.setFont(new Font("Abadi", Font.ITALIC, 10));
		
		tipo9 = new JRadioButton("Ornamentais/paisagísticas");
		tipo9.setForeground(Color.white);
		tipo9.setBackground(new Color(0, 100,0));
		tipo9.setFont(new Font("Abadi", Font.ITALIC, 10));
		
		tipo10 = new JRadioButton("PANC - Plantas Alimentícias Não Convencionais");
		tipo10.setForeground(Color.white);
		tipo10.setBackground(new Color(0, 100,0));
		tipo10.setFont(new Font("Abadi", Font.ITALIC, 10));
		
		tipo11 = new JRadioButton("Tóxicas/venenosas");
		tipo11.setForeground(Color.white);
		tipo11.setBackground(new Color(0, 100,0));
		tipo11.setFont(new Font("Abadi", Font.ITALIC, 10));
		
		informacoes = new JButton("Informações", informacao);
		informacoes.setFont(new Font("Arial Black", Font.ITALIC, 14));
		informacoes.setForeground(Color.ORANGE);
		
		limpar = new JButton("LIMPAR ÁREA");
		limpar.setFont(new Font("Arial Black", Font.ITALIC, 18));
		limpar.setForeground(Color.ORANGE);
		
		grupo.add(tipo1);
		grupo.add(tipo2);
		grupo.add(tipo3);
		grupo.add(tipo4);
		grupo.add(tipo5);
		grupo.add(tipo6);
		grupo.add(tipo7);
		grupo.add(tipo8);
		grupo.add(tipo9);
		grupo.add(tipo10);
		grupo.add(tipo11);
		
		add(tipo1);
		add(tipo2);
		add(tipo3);
		add(tipo4);
		add(tipo5);
		add(tipo6);
		add(tipo7);
		add(tipo8);
		add(tipo9);
		add(tipo10);
		add(tipo11);
		add(informacoes);
		add(limpar);
		add(janela);
		add(tipoCapes);
		
		
		tipoCapes.setBounds(2, 15, 900, 80);
		tipo1.setBounds(5, 100, 200, 30);
		tipo2.setBounds(200, 100, 100, 30);
		tipo3.setBounds(330, 100, 100, 30);
		tipo4.setBounds(425, 100, 100, 30);
		tipo10.setBounds(2, 150, 266, 30);
		tipo6.setBounds(263, 150, 98, 30);
		tipo11.setBounds(395, 150, 203, 30);
		tipo8.setBounds(5, 200, 80, 30);
		tipo9.setBounds(145, 200, 190, 30);
		tipo5.setBounds(330, 200, 100, 30);
		tipo7.setBounds(430, 200, 100, 30);
		informacoes.setBounds(620, 100, 200, 35);
		limpar.setBounds(600, 160, 250, 35);
		janela.setBounds(70, 170, 700, 600);
		
		
		
		
		
	}

	private void definirEventos() {
		informacoes.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				if(tipo1.isSelected()) {
					
					janela.setIcon(new ImageIcon(getClass().getResource("/imagem/Tipo1.png")));
				}else {
					if(tipo2.isSelected()) {
						janela.setIcon(new ImageIcon(getClass().getResource("/imagem/Tipo2.png")));
					}else {
						if(tipo3.isSelected()) {
							janela.setIcon(new ImageIcon(getClass().getResource("/imagem/Tipo3.png")));
						}
						else {
							if(tipo4.isSelected()) {
								janela.setIcon(new ImageIcon(getClass().getResource("/imagem/Tipo4.png")));
							}else {
								if(tipo5.isSelected()) {
									janela.setIcon(new ImageIcon(getClass().getResource("/imagem/Tipo5.png")));
								}else {
									if(tipo6.isSelected()) {
										janela.setIcon(new ImageIcon(getClass().getResource("/imagem/Tipo6.png")));
									}
									else {
										if(tipo7.isSelected()) {
											janela.setIcon(new ImageIcon(getClass().getResource("/imagem/Tipo7.png")));
										}else {
											if(tipo8.isSelected()) {
												janela.setIcon(new ImageIcon(getClass().getResource("/imagem/Tipo8.png")));
											}else {
												if(tipo9.isSelected()) {
													janela.setIcon(new ImageIcon(getClass().getResource("/imagem/Tipo9.png")));
												}else {
													if(tipo10.isSelected()) {
														janela.setIcon(new ImageIcon(getClass().getResource("/imagem/Tipo10.png")));
													}else {
														if(tipo11.isSelected()) {
															janela.setIcon(new ImageIcon(getClass().getResource("/imagem/Tipo11.png")));
														}
													}
												}
											}
											
										}
									}
								}
							}
						}
					}
				}
				
			}
		});
		
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				janela.setIcon(null);
			}
		});
}
}
