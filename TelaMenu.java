package MeuProjeto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaMenu extends JFrame{

private Container contentPane;
private JMenuBar barra;
private JMenu cadastrar;
private JMenu informacoes;
private JMenu sair;
private JMenu tabelas;
private JMenuItem sairTela;
private JMenuItem estrutura;
private JMenuItem tipo;
private JMenuItem sobre;
private JMenuItem tab1, tab2, tab3, tab4;
private JMenuItem valores;
private JMenuItem planta;
private JMenuItem bolsista;
private JMenuItem laboratorio;
private JMenuItem pesquisa;
private ImageIcon image1;
private JLabel caixaImagem;

public TelaMenu() {
inicializarComponentes();
definirEventos();
}
/***************Metodo para inicializar componentes *************/
private void inicializarComponentes() {
	
	
	image1 = new ImageIcon(getClass().getResource("/imagem/capa.jpg"));
	caixaImagem = new JLabel(image1);
	add(caixaImagem);
	
	
	
	
	setTitle("CAPES - Setor 56 - apoio à pesquisa botânica");
	setSize(950,750);
	setResizable(false);
	
	contentPane = getContentPane();
	barra = new JMenuBar();
	
	cadastrar = new JMenu("CADASTRAR");
	cadastrar.setFont(new Font("Serif", Font.BOLD, 24));
	cadastrar.setForeground(new Color(34, 139, 34));
	
	tabelas = new JMenu("REGISTROS");
	tabelas.setFont(new Font("Serif", Font.BOLD, 24));
	tabelas.setForeground(new Color(34, 139, 34));
	
	informacoes = new JMenu("INFORMAÇÕES");
	informacoes.setFont(new Font("Serif", Font.BOLD, 24));
	informacoes.setForeground(new Color(34, 139, 34));
	
	sair = new JMenu("SAIR");
	sair.setFont(new Font("Comic Sans", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	sair.setForeground(new Color(139, 69, 19));
	
	sairTela = new JMenuItem("SAIR");
	planta = new JMenuItem("Plantas");
	tipo = new JMenuItem("Tipos");
	bolsista = new JMenuItem("Bolsistas");
	laboratorio = new JMenuItem("Laboratórios");
	pesquisa = new JMenuItem("Projetos e pesquisas");
	estrutura = new JMenuItem("Estrutura");
	sobre = new JMenuItem("Sobre");
	valores = new JMenuItem("Valores");
	tab1 = new JMenuItem("Laboratórios");
	tab2 = new JMenuItem("Pesquisas/Projetos");
	tab3 = new JMenuItem("Bolsistas");
	tab4 = new JMenuItem("Plantas");
	
	
	

//adicionando

		sair.add(sairTela);
		tabelas.add(tab1);
		tabelas.add(tab2);
		tabelas.add(tab3);
		tabelas.add(tab4);
		informacoes.add(sobre);
		informacoes.add(valores);
		informacoes.add(tipo);
		informacoes.add(estrutura);
		cadastrar.add(planta);
		cadastrar.add(bolsista);
		cadastrar.add(laboratorio);
		cadastrar.add(pesquisa);
		barra.add(cadastrar);
		barra.add(informacoes);
		barra.add(tabelas);
		barra.add(sair);
		setJMenuBar(barra);
		
		
		}

	public void definirEventos() {
		sairTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] escolha = {"SIM", "NÃO"};
				int opcao;
				
				opcao = JOptionPane.showOptionDialog(null, "Deseja realmente sair?", "CAPES - Setor 56", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha,"NÃO");
		if(opcao==0) {
		System.exit(0); }
			}
		});
		
		tab1.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				
				new Tab1().setVisible(true);
				
				
			}
		});
		
		tab2.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				
				new Tab2().setVisible(true);
			}
		});
		
		tab3.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				
				new Tab3().setVisible(true);
			}
		});
		
		tab4.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				
				new Tab4().setVisible(true);
			}
		});
		
		tipo.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				Tipos tipos = new Tipos();
				contentPane.removeAll();
				contentPane.add(tipos);
				contentPane.validate();
			}
		});
		
		sobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				contentPane.removeAll();
				contentPane.add(sobre);
				contentPane.validate();
			}
		});
		
		
		
		
		estrutura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estrutura estrutura = new Estrutura();
				contentPane.removeAll();
				contentPane.add(estrutura);
				contentPane.validate();
			}
		});
		
	planta.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			Plantas plantas = new Plantas();
			contentPane.removeAll(); 
			contentPane.add(plantas); 
			contentPane.validate();
			
		}
	});
	
		
	laboratorio.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			Laboratorios laboratorios = new Laboratorios();
			contentPane.removeAll();
			contentPane.add(laboratorios);
			contentPane.validate();
			
		}
	});
	
	bolsista.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			Bolsistas bolsistas = new Bolsistas();
			contentPane.removeAll();
			contentPane.add(bolsistas);
			contentPane.validate();
		}
	});
	
	pesquisa.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Pesquisas pesquisas = new Pesquisas();
			contentPane.removeAll();
			contentPane.add(pesquisas);
			contentPane.validate();
		}
	});
	
	valores.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			Valores valores = new Valores();
			contentPane.removeAll();
			contentPane.add(valores);
			contentPane.validate();
		}
	});
	
	}
/********Método que cria a frame do menu principal ***********/
public static void abrir(){
	TelaMenu frame = new TelaMenu();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((tela.width - frame.getSize().width)/2,
			(tela.height - frame.getSize().height)/2);
	frame.setVisible(true);
}


}

