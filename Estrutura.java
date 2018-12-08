package MeuProjeto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Estrutura extends JPanel{
	private ButtonGroup grupo;
	private JRadioButton orgao1;
	private JRadioButton orgao2;
	private JRadioButton orgao3;
	private JRadioButton orgao4;
	private JRadioButton orgao5;
	private JButton informacoes;
	private ImageIcon informacao, estru;
	private JLabel tipoCapes;
	private JLabel imgEstrutura;

	
	
	
	public Estrutura() {
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes() {
		setLayout(null);
		setBackground(new Color(0,100,0));
		
		informacao = new ImageIcon(getClass().getResource("/imagem/informacoes.png"));
		grupo = new ButtonGroup();
		
		estru = new ImageIcon(getClass().getResource("/imagem/estrutura.png"));
		imgEstrutura = new JLabel(estru);
		
		tipoCapes = new JLabel("Conheça a estrutura CAPES - clique numa opção e aperte o botão "+"INFORMAÇÕES");
		tipoCapes.setForeground(Color.white);
		tipoCapes.setFont(new Font("Corbel", Font.BOLD, 24));
				
		orgao1 = new JRadioButton("Órgãos colegiados");
		orgao1.setForeground(Color.white);
		orgao1.setBackground(new Color(0, 100,0));
		orgao1.setFont(new Font("Abadi", Font.ITALIC, 10));
		
		orgao2 = new JRadioButton("Órgão Executivo");
		orgao2.setForeground(Color.white);
		orgao2.setBackground(new Color(0, 100,0));
		orgao2.setFont(new Font("Abadi", Font.ITALIC, 10));
		
		orgao3 = new JRadioButton("Órgão de assis. presidente");
		orgao3.setForeground(Color.white);
		orgao3.setBackground(new Color(0, 100,0));
		orgao3.setFont(new Font("Abadi", Font.ITALIC, 10));
		
		orgao4 = new JRadioButton("Órgãos seccionais");
		orgao4.setForeground(Color.white);
		orgao4.setBackground(new Color(0, 100,0));
		orgao4.setFont(new Font("Abadi", Font.ITALIC, 10));
		
		orgao5 = new JRadioButton("Órgãos esp. singulares");
		orgao5.setForeground(Color.white);
		orgao5.setBackground(new Color(0, 100,0));
		orgao5.setFont(new Font("Abadi", Font.ITALIC, 10));
		
		
		informacoes = new JButton("Informações", informacao);
		informacoes.setFont(new Font("Arial Black", Font.ITALIC, 14));
		informacoes.setForeground(Color.ORANGE);
		
		grupo.add(orgao1);
		grupo.add(orgao2);
		grupo.add(orgao3);
		grupo.add(orgao4);
		grupo.add(orgao5);
		
		add(orgao1);
		add(orgao2);
		add(orgao3);
		add(orgao4);
		add(orgao5);
		add(informacoes);
		add(tipoCapes);
		add(imgEstrutura);
		
		
		tipoCapes.setBounds(2, 15, 900, 80);
		imgEstrutura.setBounds(95, 100, 750, 300);
		orgao1.setBounds(15, 400, 200, 30);
		orgao2.setBounds(15, 440, 200, 30);
		orgao3.setBounds(15, 480, 200, 30);
		orgao4.setBounds(15, 520, 200, 30);
		orgao5.setBounds(15, 560, 200, 30);
		informacoes.setBounds(400, 500, 200, 60);
		
		
		
		
	}

	private void definirEventos() {
		informacoes.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
			if(orgao1.isSelected()) {
				JOptionPane.showMessageDialog(null, null, "Órgãos colegiados", 
						JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagem/estrut01.png")));
			}else {
				if(orgao2.isSelected()) {
					JOptionPane.showMessageDialog(null, null, "Órgão Executivo", 
							JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagem/estrut02.png")));
				}else {
					if(orgao3.isSelected()) {
						JOptionPane.showMessageDialog(null, null, "Órgão de assis. presidente", 
								JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagem/estrut03.png")));
					}else {
						if(orgao4.isSelected()) {
							JOptionPane.showMessageDialog(null, null, "Órgãos seccionais", 
									JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagem/estrut04.png")));
						}else {
							if(orgao5.isSelected()) {
								JOptionPane.showMessageDialog(null, null, "Órgãos esp. singulares", 
										JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagem/estrut05.png")));
							}
						}
					}
				}
			}
			}
		});
		
		
}
}
