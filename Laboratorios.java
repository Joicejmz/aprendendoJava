package MeuProjeto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import javax.swing.text.*;

public class Laboratorios extends JPanel{
	
	ConexaoBD bd = new ConexaoBD();
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	Comandos c = new Comandos();// para utlizar o insert - só pra mostrar que aprendi :P, mas a preferência foi fazer os métodos aui mesmo  :)
	
	private JLabel nome_lab;
	private JLabel rua_lab;
	private JLabel numero_lab;
	private JLabel complemento_lab;
	private JLabel bairro_lab;
	private JLabel cep_lab;
	private JLabel cidade_lab;
	private JLabel estado_lab;
	private JLabel telefone_lab;
	private JLabel email_lab;
	private JLabel cadastro_lab;
	private JLabel regra;
	
	private JTextField campoNome_lab;
	private JTextField campoRua_lab;
	private JTextField campoNumero_lab;
	private JTextField campoComplemento_lab;
	private JTextField campoBairro_lab;
	private JFormattedTextField campoCep_lab;
	private MaskFormatter mfCep;
	private JTextField campoCidade_lab;
	private JFormattedTextField campoTelefone_lab;
	private MaskFormatter mfTel;
	private JTextField campoEmail_lab;
	
	private JButton cadastrar;
	private JButton alterar;
	private JButton deletar;
	private JButton pesquisar;
	private JButton ver;
	
	
	private JList liEstados;
	private JScrollPane spEstados;
	private ImageIcon cadastro, altera, deleta, pesquisa, regras, mostra;
	
	public Laboratorios() {
		inicializarComponentes();
		definirEventos();
		conexao = bd.conectar();
	}

	private void inicializarComponentes() {
		try {
		
		setLayout(null);
		setBackground(new Color(0,100,0));
	
		
		String[] escolhaEstado = {"","AC","AL","AM","AP","BA","CE","DF","ES","GO","MA", "MG", "MS","MT","PA","PB","PE","PI","PR","RJ","RN","RO", "RR", "RS", "SE", "SC", "SP", "TO"};
		
		liEstados = new JList(escolhaEstado);
		spEstados = new JScrollPane(liEstados);
		
		//regra = new JLabel(regras);
		
		mfTel = new MaskFormatter("(###)####-####");
		mfCep = new MaskFormatter("##.###-###");
		
		cadastro = new ImageIcon(getClass().getResource("/imagem/cadastrar.png"));
		altera = new ImageIcon(getClass().getResource("/imagem/altera.png"));
		deleta = new ImageIcon(getClass().getResource("/imagem/deletar.png"));
		pesquisa = new ImageIcon(getClass().getResource("/imagem/pesquisar.png"));
		regras = new ImageIcon(getClass().getResource("/imagem/regras1.jpg"));
		mostra = new ImageIcon(getClass().getResource("/imagem/mostrar.png"));
		
		
		nome_lab = new JLabel ("Nome do Laboratório:");
		nome_lab.setFont(new Font("Comic Sans", Font.ITALIC,14));
		nome_lab.setForeground(Color.white);
		
		rua_lab = new JLabel ("Rua:");
		rua_lab.setFont(new Font("Comic Sans", Font.ITALIC,14));
		rua_lab.setForeground(Color.white);
		
		numero_lab = new JLabel ("Número:");
		numero_lab.setFont(new Font("Comic Sans", Font.ITALIC,14));
		numero_lab.setForeground(Color.white);
		
		complemento_lab = new JLabel ("Complemento:");
		complemento_lab.setFont(new Font("Comic Sans", Font.ITALIC,14));
		complemento_lab.setForeground(Color.white);
		
		bairro_lab = new JLabel ("Bairro:");
		bairro_lab.setFont(new Font("Comic Sans", Font.ITALIC,14));
		bairro_lab.setForeground(Color.white);
		
		cep_lab = new JLabel ("CEP:");
		cep_lab.setFont(new Font("Comic Sans", Font.ITALIC,14));
		cep_lab.setForeground(Color.white);
		
		cidade_lab = new JLabel ("Cidade:");
		cidade_lab.setFont(new Font("Comic Sans", Font.ITALIC,14));
		cidade_lab.setForeground(Color.white);
		
		estado_lab = new JLabel ("Estado:");
		estado_lab.setFont(new Font("Comic Sans", Font.ITALIC,14));
		estado_lab.setForeground(Color.white);
		
		telefone_lab = new JLabel ("Telefone:");
		telefone_lab.setToolTipText("Ex.: (0xx)xxxx-xxxx");
		telefone_lab.setFont(new Font("Comic Sans", Font.ITALIC,14));
		telefone_lab.setForeground(Color.white);
		
		email_lab = new JLabel ("E-mail:");
		email_lab.setToolTipText("Ex.: exemplo@Xmail.com");
		email_lab.setFont(new Font("Comic Sans", Font.ITALIC,14));
		email_lab.setForeground(Color.white);
		
		cadastro_lab = new JLabel ("Cadastro dos laboratórios dos alunos que recebem aporte financeiro");
		cadastro_lab.setFont(new Font("Verdana", Font.ITALIC,24));
		cadastro_lab.setForeground(Color.white);
		
		
		campoNome_lab = new JTextField(100);
		campoRua_lab = new JTextField(100);
		campoNumero_lab = new JTextField(6);
		campoComplemento_lab = new JTextField(50);
		campoBairro_lab = new JTextField(70);
		campoCep_lab = new JFormattedTextField(mfCep);
		campoCidade_lab = new JTextField(100);
		campoTelefone_lab = new JFormattedTextField(mfTel);
		campoEmail_lab = new JTextField(100);
		
		cadastrar = new JButton("Cadastro", cadastro);
		cadastrar.setForeground(new Color(0,100,0));
		cadastrar.setFont(new Font("Verdana", Font.BOLD, 16));
		
		alterar = new JButton("Alterar", altera);
		alterar.setForeground(new Color(0,100,0));
		alterar.setFont(new Font("Verdana", Font.BOLD, 16));
		
		deletar = new JButton("Deletar", deleta);
		deletar.setForeground(new Color(0,100,0));
		deletar.setFont(new Font("Verdana", Font.BOLD, 16));
		
		ver = new JButton("Ver", mostra);
		ver.setForeground(new Color(0,100,0));
		ver.setFont(new Font("Verdana", Font.BOLD, 16));
		
		
		pesquisar = new JButton("Pesquisar", pesquisa);
		pesquisar.setForeground(new Color(0,100,0));
		pesquisar.setFont(new Font("Verdana", Font.BOLD, 16));
		pesquisar.setToolTipText("Use o campo Nome do Laboratório");
		
		
		
		add(nome_lab);
		add(rua_lab);
		add(numero_lab);
		add(complemento_lab);
		add(bairro_lab);
		add(cep_lab);
		add(cidade_lab);
		add(estado_lab);
		add(telefone_lab);
		add(email_lab);
		add(cadastro_lab);
		add(campoNome_lab);
		add(campoRua_lab);
		add(campoNumero_lab);
		add(campoComplemento_lab);
		add(campoBairro_lab);
		add(campoCep_lab);
		add(campoCidade_lab);
		add(campoTelefone_lab);
		add(campoEmail_lab);
		add(cadastrar);
		add(alterar);
		add(deletar);
		add(pesquisar);
		//add(regra);
		add(spEstados);
		add(ver);
		
		
		
		
		cadastro_lab.setBounds(2, 15, 900, 80);
		
		nome_lab.setBounds(15, 100, 220, 20);
		campoNome_lab.setBounds(15, 130, 300, 20);
		
		rua_lab.setBounds(360, 100, 200, 20);
		campoRua_lab.setBounds(360, 130, 250, 20);
		
		numero_lab.setBounds(700, 100, 100, 20);
		campoNumero_lab.setBounds(700, 130, 50, 20);
		
		complemento_lab.setBounds(15, 170, 200, 20);
		campoComplemento_lab.setBounds(15, 200, 200, 20);
		
		bairro_lab.setBounds(360, 170, 200, 20);
		campoBairro_lab.setBounds(360, 200, 250, 20);
		
		cep_lab.setBounds(700, 170, 50, 20);
		campoCep_lab.setBounds(700, 200, 100, 20);
		
		cidade_lab.setBounds(15, 240, 100, 20);
		campoCidade_lab.setBounds(15, 270, 300, 20);
		
		estado_lab.setBounds(360, 240, 100, 20);
		spEstados.setBounds(360, 270, 50, 40);
		
		telefone_lab.setBounds(500, 240, 100, 20);
		campoTelefone_lab.setBounds(500, 270, 100, 20);
		
		email_lab.setBounds(700, 240, 70, 20);
		campoEmail_lab.setBounds(700, 270, 200, 20);
		
		cadastrar.setBounds(120, 330, 170, 50);
		alterar.setBounds(290, 330, 170, 50);
		deletar.setBounds(460, 330, 170, 50);
		pesquisar.setBounds(630, 330, 170, 50);
		ver.setBounds(375, 430, 200, 60);
		
		
		//regra.setBounds(5, 430, 890, 250);
		
		
		}catch(ParseException erro) {
			erro.printStackTrace();
		}
		
	}
	private void definirEventos(){
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(c.cadastrarLaboratorios(campoNome_lab.getText(), campoRua_lab.getText(), campoNumero_lab.getText(), 
						campoComplemento_lab.getText(), campoBairro_lab.getText(), campoCep_lab.getText(), 
						campoCidade_lab.getText(), liEstados.getSelectedIndex(), campoTelefone_lab.getText(), 
						campoEmail_lab.getText())){
				
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
					campoNome_lab.setText("");
					campoRua_lab.setText("");
					campoNumero_lab.setText("");
					campoComplemento_lab.setText("");
					campoBairro_lab.setText("");
					campoCep_lab.setText("");
					campoCidade_lab.setText("");
					campoTelefone_lab.setText("");
					campoEmail_lab.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Erro! "+"\n*Veja se o Estado está selecionado"
				+"\n*Veja se este laboratório já está cadastrado");
				}
			}
		});
		
		
		alterar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				alterar();
			}
		});
		
		ver.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				JOptionPane.showMessageDialog(null, null, "Ajuda", 
						JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagem/regras1.jpg")));
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
	//PESQUISA
	private void pesquisar() {
			String sql = "select * from  laboratorios where campoNome_lab  = ?";
		
			try{
				pst=conexao.prepareStatement(sql);
				pst.setString(1, campoNome_lab.getText());
				rs = pst.executeQuery();
				
				if(rs.next()) {
					campoRua_lab.setText(rs.getString(2));
					campoNumero_lab.setText(rs.getString(3));
					campoComplemento_lab.setText(rs.getString(4));
					campoBairro_lab.setText(rs.getString(5));
					campoCep_lab.setText(rs.getString(6));
					campoCidade_lab.setText(rs.getString(7));
					liEstados.setSelectedIndex(rs.getInt(8));
					campoTelefone_lab.setText(rs.getString(9));
					campoEmail_lab.setText(rs.getString(10));
					
					
					
					}else {
					JOptionPane.showMessageDialog(null, "Erro! "+"Veja se:"+"\n*o nome do laboratório já está cadastrado?"
							+"\n*o nome foi digitado corretamente?");
					}
			
			
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Verfique registros anteriores");
				System.out.println(e.toString());}
				
		}
		
		// ::::::::::::::::::::::::::::::::::::::::::::::::::: MÉTODOS ::::::::::::::::::::::::::::::::::::::::::::::::::: //
		//DELETE
		private void deletar() {
			
			int confirma = JOptionPane.showConfirmDialog(null, "Você ter certeza?", "Atenção", JOptionPane.YES_NO_OPTION);
			if(confirma==0) {
		
			String sqlCom = "delete from laboratorios where campoNome_lab = ?";
			try {
				pst=conexao.prepareStatement(sqlCom);
				pst.setString(1, campoNome_lab.getText());
				
				int del = pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Apagado com sucesso");
				campoRua_lab.setText(null);
				campoNumero_lab.setText(null);
				campoComplemento_lab.setText(null);
				campoBairro_lab.setText(null);
				campoCep_lab.setText(null);
				campoCidade_lab.setText(null);
				campoTelefone_lab.setText(null);
				campoEmail_lab.setText(null);
				campoNome_lab.setText(null);
				
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Você não pode alterar o Estado. Se houve equívoco, terá que deletar o registro e refazer");
				System.out.println(e.toString());}
				
		}
				
		}
		
		// ::::::::::::::::::::::::::::::::::::::::::::::::::: MÉTODOS ::::::::::::::::::::::::::::::::::::::::::::::::::: //	
		//ALTERAR
		private void alterar() {
			String slq1 = "update laboratorios set campoRua_lab=?, campoNumero_lab=?, campoComplemento_lab=?, campoBairro_lab=?, campoCep_lab=?,"
		+" campoCidade_lab=?,  campoTelefone_lab=?, campoEmail_lab=? where campoNome_lab=?";
		try {
			pst=conexao.prepareStatement(slq1);
			
			pst.setString(1, campoRua_lab.getText());
			pst.setString(2, campoNumero_lab.getText());
			pst.setString(3, campoComplemento_lab.getText());
			pst.setString(4, campoBairro_lab.getText());
			pst.setString(5, campoCep_lab.getText());
			pst.setString(6, campoCidade_lab.getText());
			pst.setString(7, campoTelefone_lab.getText());
			pst.setString(8, campoEmail_lab.getText());
			pst.setString(9,campoNome_lab.getText());
			
			int alterado = pst.executeUpdate();
			if(alterado >0) {
				JOptionPane.showMessageDialog(null, "Alterado com sucesso");
				campoRua_lab.setText(null);
				campoNumero_lab.setText(null);
				campoComplemento_lab.setText(null);
				campoBairro_lab.setText(null);
				campoCep_lab.setText(null);
				campoCidade_lab.setText(null);
				campoTelefone_lab.setText(null);
				campoEmail_lab.setText(null);
				campoNome_lab.setText(null);
			}else {
				JOptionPane.showMessageDialog(null, "Erro"+"\nVocê não pode alterar o nome do laboratório "
						+"e estado. "
						+ "Caso tenha que mudá-los, terá que apagar o cadastro e re-cadastrar");
			}
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Você digitou algo errado ou no campo errado");
			System.out.println(e);
		}
			
		}
		
			
}
