package MeuProjeto;

import javax.swing.*;

import java.awt.*;

public class Sobre extends JPanel{

	private ImageIcon image1;
	private JLabel caixaImagem;

	public Sobre() {
	inicializarComponentes();
	}
	/***************Metodo para inicializar componentes *************/
	private void inicializarComponentes() {
		
		
		image1 = new ImageIcon(getClass().getResource("/imagem/gnux1.png"));
		caixaImagem = new JLabel(image1);
		add(caixaImagem);
		
}
}
