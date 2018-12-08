package MeuProjeto;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Plantas extends JPanel{
	
	ConexaoBD bd = new ConexaoBD();
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	Comandos c = new Comandos();// para utlizar o insert - só pra mostrar que aprendi :P, mas a preferência foi fazer os métodos aui mesmo  :)
	
	private JTextField campoNomePop;
	private JLabel nomePop;
	private JTextField campoNomeEsp;
	private JLabel nomeEsp;
	private JTextField campoGenero;
	private JLabel genero;
	private JTextField campoNomeFamilia;
	private JLabel nomeFamilia;
	private JTextField campoNomePesquisa;
	private JLabel nomePesquisa;
	private JList liTipos;
	private JScrollPane jsTipos;
	private JLabel jlTipos;
	private JButton cadastrar;
	private JButton alterar;
	private JButton deletar;
	private JButton pesquisar;
	private JLabel regra;
	private JLabel tipo;
	private JLabel texto;
	private JLabel texto2;
	private ImageIcon imagem01, cadastro, altera, deleta, pesquisa, regras;
	private JLabel caixaImagem01;
	private JScrollPane ver;
	
	
	
	public Plantas(){
		inicializarComponentes();
		definirEventos();
		conexao = bd.conectar();
	}
	
	public void inicializarComponentes(){
		
		setLayout(null);
		setBackground(new Color(0,100,0));
		
		
		String[] escolhaTipo = {"","alimentícia","alucinógena","aquática","aromática","carnívora","desconhecida","fitocosmética","medicinal","ornamental","panc", "tóxica"};
		
		
	
		
		imagem01 = new ImageIcon(getClass().getResource("/imagem/imagem01.jpg"));
		cadastro = new ImageIcon(getClass().getResource("/imagem/cadastrar.png"));
		altera = new ImageIcon(getClass().getResource("/imagem/altera.png"));
		deleta = new ImageIcon(getClass().getResource("/imagem/deletar.png"));
		pesquisa = new ImageIcon(getClass().getResource("/imagem/pesquisar.png"));
		regras = new ImageIcon(getClass().getResource("/imagem/regras3.jpg"));
		
		//criando objetos de cada componentes para inicializá-los
		
		
		
		tipo = new JLabel("Escolha apenas um tipo classificatório principal");
		tipo.setForeground(Color.WHITE);
		tipo.setFont(new Font("Verdana", Font.BOLD, 20));
		
		nomeEsp = new JLabel("Nome científico:");
		nomeEsp.setFont(new Font("Comic Sans", Font.ITALIC,14));
		nomeEsp.setForeground(Color.white);
		
		nomePop = new JLabel("Nome popular:");
		nomePop.setFont(new Font("Comic Sans", Font.ITALIC,14));
		nomePop.setForeground(Color.white);
		
		nomeFamilia = new JLabel("Família:");
		nomeFamilia.setFont(new Font("Comic Sans", Font.ITALIC,14));
		nomeFamilia.setForeground(Color.white);
		
		nomePesquisa = new JLabel("Pertence/pertenceu à pesquisa");
		nomePesquisa.setFont(new Font("Comic Sans", Font.ITALIC,14));
		nomePesquisa.setForeground(Color.white);
		
		genero = new JLabel("Gênero:");
		genero.setFont(new Font("Comic Sans", Font.ITALIC,14));
		genero.setForeground(Color.white);
		
		campoNomePop = new JTextField(100);
		campoNomeEsp = new JTextField(100);
		campoGenero = new JTextField(70);
		campoNomeFamilia = new JTextField(70);
		campoNomePesquisa = new JTextField(100);
				
		liTipos = new JList(escolhaTipo);
		
		jlTipos = new JLabel("Tipo:");
		jlTipos.setFont(new Font("Comic Sans", Font.ITALIC,14));
		jlTipos.setForeground(Color.white);
		
		jsTipos = new JScrollPane (liTipos);
		
		regra = new JLabel(regras);
		caixaImagem01 = new JLabel(imagem01);
		
		
		cadastrar = new JButton("Cadastro", cadastro);
		cadastrar.setForeground(new Color(0,100,0));
		cadastrar.setFont(new Font("Verdana", Font.BOLD, 16));
		
		alterar = new JButton("Alterar", altera);
		alterar.setForeground(new Color(0,100,0));
		alterar.setFont(new Font("Verdana", Font.BOLD, 16));
		
		deletar = new JButton("Deletar", deleta);
		deletar.setForeground(new Color(0,100,0));
		deletar.setFont(new Font("Verdana", Font.BOLD, 16));
		
		
		pesquisar = new JButton("Pesquisar", pesquisa);
		pesquisar.setForeground(new Color(0,100,0));
		pesquisar.setFont(new Font("Verdana", Font.BOLD, 16));
		pesquisar.setToolTipText("Use o nome do Nome Científico");
		
				
		texto = new JLabel("As plantas podem e têm mais de uma funcionalidade.");
		texto.setForeground(Color.WHITE);
		texto.setFont(new Font("Comic Sans", Font.ITALIC, 18));
		
		texto2 = new JLabel("Para fins de registro a CAPES classifica as plantas em uma funcionalidade principal");
		texto2.setForeground(Color.WHITE);
		texto2.setFont(new Font("Comic Sans", Font.ITALIC, 14));
		
		
		//adicionando
		
		add(nomeEsp);
		add(nomePop);
		add(genero);
		add(nomeFamilia);
		add(nomePesquisa);
		add(tipo);
		add(jsTipos);
		add(jlTipos);
		add(cadastrar);
		add(alterar);
		add(deletar);
		add(pesquisar);
		add(campoNomePop);
		add(campoNomeEsp);
		add(campoGenero);
		add(campoNomeFamilia);
		add(campoNomePesquisa);
		add(texto);
		add(texto2);
		add(regra);
		add(caixaImagem01);
		
		
		//posicionado e dimensionando
		
		
		caixaImagem01.setBounds(695, 10, 250, 650);
		
		jlTipos.setBounds(5, 90, 90, 35);
		jsTipos.setBounds(5, 125, 110, 120);
		
		nomePop.setBounds(170, 90, 105, 35);
		campoNomePop.setBounds(170, 125, 140, 20);
		
		nomeEsp.setBounds(350, 90, 110, 35);
		campoNomeEsp.setBounds(350, 125, 140, 20);
		
		genero.setBounds(525, 90, 90, 35);
		campoGenero.setBounds(525, 125, 140, 20);
		
		nomeFamilia.setBounds(170, 160, 90, 35);
		campoNomeFamilia.setBounds(170, 195, 140, 20);
		
		nomePesquisa.setBounds(350, 160, 200, 35);
		campoNomePesquisa.setBounds(350, 195, 200, 20);
						
		cadastrar.setBounds(470, 350, 200, 50);
		alterar.setBounds(470, 420, 200, 50);
		deletar.setBounds(470, 490, 200, 50);
		pesquisar.setBounds(470, 560, 200, 50);
		
		tipo.setBounds(100, 0, 600, 85);
		texto.setBounds(117, 250, 700, 25);
		texto2.setBounds(75, 280, 700, 25);
		regra.setBounds(20, 330, 410, 310);
		//verTela.setBounds(25, 340, 400, 300);
		
		
	}
	
	public void definirEventos(){
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			
				if(c.cadastrarPlantas(campoNomePop.getText(), campoNomeEsp.getText(), campoGenero.getText(), 
				  campoNomeFamilia.getText(), campoNomePesquisa.getText(), liTipos.getSelectedIndex())) {
					
					
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
					campoNomePop.setText("");
					campoNomeEsp.setText("");
					campoGenero.setText("");
					campoNomeFamilia.setText("");
					campoNomePesquisa.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Erro! "+"Veja se:"+"\n*o nome científico já está cadastrado?"
				+"\n*o nome da pesquisa está correto;"+
				"\n*a pesquisa já está cadastrada?;"+"\n*o tipo de planta foi selecionado;");
				}

			}
		});
		
		alterar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				alterar();
			}
		});
		
		deletar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				deletar();
			}
		});
		
		pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				pesquisar();
			}
		});
	}
	// ::::::::::::::::::::::::::::::::::::::::::::::::::: MÉTODOS ::::::::::::::::::::::::::::::::::::::::::::::::::: //
	private void pesquisar() {
		String sql = "select * from  plantas where campoNomeEsp  = ?";
	
		try{
			pst=conexao.prepareStatement(sql);
			pst.setString(1, campoNomeEsp.getText());
			rs = pst.executeQuery();
			
			if(rs.next()) {
				campoNomePop.setText(rs.getString(1));
				campoGenero.setText(rs.getString(3));
				campoNomeFamilia.setText(rs.getString(4));
				campoNomePesquisa.setText(rs.getString(5));
				liTipos.setSelectedIndex(rs.getInt(6));
				
				
				
				
				
				}else {
					JOptionPane.showMessageDialog(null, "Erro! "+"Veja se:"+"\n*o nome científico já está cadastrado?"
							+"\n*ele foi digitado corretamente?");
					}
	
		
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Você não pode alterar o tipo! Se quiser mudar, terá que apagar o registro e refazer\n Esta pesuisa não está registrada");
			System.out.println(e.toString());}
			
	}
	// ::::::::::::::::::::::::::::::::::::::::::::::::::: MÉTODOS ::::::::::::::::::::::::::::::::::::::::::::::::::: //	
	//ALTERAR
	private void alterar() {
		String sql = "update plantas set campoNomePop=?, campoGenero=?, campoNomeFamilia=?, "
			+"campoNomePesquisa=? where campoNomeEsp=?";
	try {
		pst=conexao.prepareStatement(sql);
		pst.setString(1, campoNomePop.getText());
		pst.setString(2, campoGenero.getText());
		pst.setString(3, campoNomeFamilia.getText());
		pst.setString(4, campoNomePesquisa.getText());
		pst.setString(5, campoNomeEsp.getText());
		
		int alterado = pst.executeUpdate();
		if(alterado >0) {
			JOptionPane.showMessageDialog(null, "Alterado com sucesso");
			
			campoNomePop.setText(null);
			campoGenero.setText(null);
			campoNomeFamilia.setText(null);
			campoNomePesquisa.setText(null);
			campoNomeEsp.setText(null);
			
		}else {
			JOptionPane.showMessageDialog(null, "Erro"+"\nSe for alterar o nome da pesquisa:"
		+"\n*confira se o nome está correto e\"\r\n" + 
		"n veja se a mesma já está cadastrada no sistema. Senão, cadastre-a primeiro"
		+ "\nSe precisar alterar o tipo, delete o cadastro e refaça-o corretamente."
		+"\n Você não pode alterar o nome da espécie. Caso digitou errado, apague o cadastro e refaça-o");
		}
		
		
	}catch(Exception e) {
		System.out.println(""+e);
		JOptionPane.showMessageDialog(null,"Você não pode alterar o nome da pesquisa enquanto não terminar o projeto!"
				+ "\n");
	}
		
	}
	
	// ::::::::::::::::::::::::::::::::::::::::::::::::::: MÉTODOS ::::::::::::::::::::::::::::::::::::::::::::::::::: //
	//DELETE
	
	private void deletar() {
		int confirma = JOptionPane.showConfirmDialog(null, "Você ter certeza?", "Atenção", JOptionPane.YES_NO_OPTION);
		if(confirma==0) {
	
		String sqlCom = "delete from plantas where campoNomeEsp = ?";
		try {
			pst=conexao.prepareStatement(sqlCom);
			pst.setString(1, campoNomeEsp.getText());
			
			int del = pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Apagado com sucesso");
			campoNomePop.setText(null);
			campoGenero.setText(null);
			campoNomeFamilia.setText(null);
			campoNomePesquisa.setText(null);
			campoNomeEsp.setText(null);
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Você digitou algo errado ou no campo errado");
			System.out.println(e.toString());}
			
	}
	}
}

