package MeuProjeto;

import javax.swing.*;


import java.text.ParseException;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Pesquisas extends JPanel{
	
	ConexaoBD bd = new ConexaoBD();
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	Comandos c = new Comandos();// para utlizar o insert - só pra mostrar que aprendi :P, mas a preferência foi fazer os métodos aui mesmo  :)
	
	private JLabel nome_pesquisa;
	private JLabel aluno_bolsista;
	private JLabel dataInicio_pesquisa;
	private JLabel nome_planta;
	private JLabel nome_lab;
	private JLabel dataFim_pesquisa;
	private JLabel nome_orientador;
	private JLabel telefone_orientador;
	private JLabel email_orientador;
	private JLabel cadastro_pesquisa;
	private JLabel regra;
	
	
	private JTextField campoNome_pesquisa;
	private JTextField campoAluno_bolsista;
	private JFormattedTextField campoDataInicio_pesquisa;
	private MaskFormatter mfDataIn, mfDataFi;
	private JTextField campoNome_planta;
	private JTextField campoNome_lab;
	private JFormattedTextField campoDataFim_pesquisa;
	private JTextField campoNome_orientador;
	private JFormattedTextField campoTelefone_orientador;
	private MaskFormatter mfTel;
	private JTextField campoEmail_orientador;
	
	private JButton cadastrar;
	private JButton alterar;
	private JButton deletar;
	private JButton pesquisar;
	
	
	
	private ImageIcon cadastro, altera, deleta, pesquisa, regras;
	
	public Pesquisas() {
		inicializarComponentes();
		definirEventos();
		conexao = bd.conectar();
	}

	private void inicializarComponentes() {
		try {
		
		setLayout(null);
		setBackground(new Color(0,100,0));
		
		
				
		
		cadastro = new ImageIcon(getClass().getResource("/imagem/cadastrar.png"));
		altera = new ImageIcon(getClass().getResource("/imagem/altera.png"));
		deleta = new ImageIcon(getClass().getResource("/imagem/deletar.png"));
		pesquisa = new ImageIcon(getClass().getResource("/imagem/pesquisar.png"));
		regras = new ImageIcon(getClass().getResource("/imagem/regras2.jpg"));
		
		mfTel = new MaskFormatter("(###)####-####");
		mfDataFi = new MaskFormatter("##/##/####");
		mfDataIn = new MaskFormatter("##/##/####");
		regra = new JLabel(regras);
		
		
		nome_pesquisa = new JLabel ("Nome da Pesquisa:");
		nome_pesquisa.setFont(new Font("Comic Sans", Font.ITALIC,14));
		nome_pesquisa.setForeground(Color.white);
		
		aluno_bolsista = new JLabel ("Nome do bolsista:");
		aluno_bolsista.setFont(new Font("Comic Sans", Font.ITALIC,14));
		aluno_bolsista.setForeground(Color.white);
		
		dataInicio_pesquisa = new JLabel ("Data de início:");
		dataInicio_pesquisa.setToolTipText("dd/mm/aaaa");
		dataInicio_pesquisa.setFont(new Font("Comic Sans", Font.ITALIC,14));
		dataInicio_pesquisa.setForeground(Color.white);
		
		nome_planta = new JLabel ("Planta estudada - nome científico:");
		nome_planta.setFont(new Font("Comic Sans", Font.ITALIC,14));
		nome_planta.setForeground(Color.white);
		
		nome_lab = new JLabel ("Laboratório:");
		nome_lab.setFont(new Font("Comic Sans", Font.ITALIC,14));
		nome_lab.setForeground(Color.white);
		
		dataFim_pesquisa = new JLabel ("Data de término:");
		dataFim_pesquisa.setFont(new Font("Comic Sans", Font.ITALIC,14));
		dataFim_pesquisa.setToolTipText("dd/mm/aaaa");
		dataFim_pesquisa.setForeground(Color.white);
		
		nome_orientador = new JLabel ("Orientador da pesquisa:");
		nome_orientador.setFont(new Font("Comic Sans", Font.ITALIC,14));
		nome_orientador.setForeground(Color.white);
		
		telefone_orientador = new JLabel ("Telefone orientador:");
		telefone_orientador.setToolTipText("Ex.: (0xx)xxxx-xxxx");
		telefone_orientador.setFont(new Font("Comic Sans", Font.ITALIC,14));
		telefone_orientador.setForeground(Color.white);
		
		email_orientador = new JLabel ("E-mail orientador:");
		email_orientador.setToolTipText("Ex.: exemplo@Xmail.com");
		email_orientador.setFont(new Font("Comic Sans", Font.ITALIC,14));
		email_orientador.setForeground(Color.white);
		
		cadastro_pesquisa = new JLabel ("Cadastro das pesquisas desenvolvidas");
		cadastro_pesquisa.setFont(new Font("Verdana", Font.ITALIC,24));
		cadastro_pesquisa.setForeground(Color.white);
		
		
		campoNome_pesquisa = new JTextField(100);
		campoAluno_bolsista = new JTextField(100);
		campoDataInicio_pesquisa = new JFormattedTextField(mfDataIn);
		campoNome_planta = new JTextField(100);
		campoNome_lab = new JTextField(100);
		campoDataFim_pesquisa = new JFormattedTextField(mfDataFi);
		campoNome_orientador = new JTextField(100);
		campoTelefone_orientador = new JFormattedTextField(mfTel);
		campoEmail_orientador = new JTextField();
		
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
		pesquisar.setToolTipText("Use o campo Nome da Pesquisa");
		
		
		
		add(nome_pesquisa);
		add(aluno_bolsista);
		add(dataInicio_pesquisa);
		add(nome_planta);
		add(nome_lab);
		add(dataFim_pesquisa);
		add(nome_orientador);
		add(telefone_orientador);
		add(email_orientador);
		add(cadastro_pesquisa);
		add(campoNome_pesquisa);
		add(campoAluno_bolsista);
		add(campoDataInicio_pesquisa);
		add(campoNome_planta);
		add(campoNome_lab);
		add(campoDataFim_pesquisa);
		add(campoNome_orientador);
		add(campoTelefone_orientador);
		add(campoEmail_orientador);
		add(cadastrar);
		add(alterar);
		add(deletar);
		add(pesquisar);
		add(regra);
		
				
		cadastro_pesquisa.setBounds(2, 15, 900, 80);
		
		nome_pesquisa.setBounds(15, 100, 220, 20);
		campoNome_pesquisa.setBounds(15, 130, 300, 20);
		
		aluno_bolsista.setBounds(360, 100, 200, 20);
		campoAluno_bolsista.setBounds(360, 130, 250, 20);
		
		dataInicio_pesquisa.setBounds(700, 100, 100, 20);
		campoDataInicio_pesquisa.setBounds(700, 130, 70, 20);
		
		nome_planta.setBounds(15, 170, 250, 20);
		campoNome_planta.setBounds(15, 200, 300, 20);
		
		nome_lab.setBounds(360, 170, 200, 20);
		campoNome_lab.setBounds(360, 200, 250, 20);
		
		dataFim_pesquisa.setBounds(700, 170, 150, 20);
		campoDataFim_pesquisa.setBounds(700, 200, 70, 20);
		
		nome_orientador.setBounds(15, 240, 160, 20);
		campoNome_orientador.setBounds(15, 270, 300, 20);
		
		telefone_orientador.setBounds(360, 240, 150, 20);
		campoTelefone_orientador.setBounds(360, 270, 100, 20);
		
		email_orientador.setBounds(700, 240, 170, 20);
		campoEmail_orientador.setBounds(700, 270, 200, 20);
		
		cadastrar.setBounds(120, 330, 170, 50);
		alterar.setBounds(290, 330, 170, 50);
		deletar.setBounds(460, 330, 170, 50);
		pesquisar.setBounds(630, 330, 170, 50);
		
		
		regra.setBounds(5, 430, 890, 250);
		
		
		
		}catch(ParseException erro) {
			erro.printStackTrace();
		}
		
	}
	private void definirEventos(){
		
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				
				if(c.cadastrarPesquisas(campoNome_pesquisa.getText(), campoAluno_bolsista.getText(), campoDataInicio_pesquisa.getText(),  
						campoNome_planta.getText(), campoNome_lab.getText(), campoDataFim_pesquisa.getText(), campoNome_orientador.getText(),
						campoTelefone_orientador.getText(), campoEmail_orientador.getText())) {
					
				
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
					campoNome_pesquisa.setText("");
					campoAluno_bolsista.setText("");
					campoDataInicio_pesquisa.setText("");
					campoNome_planta.setText("");
					campoNome_lab.setText("");
					campoDataFim_pesquisa.setText("");
					campoEmail_orientador.setText("");
					campoTelefone_orientador.setText("");
					campoNome_orientador.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Erro! "+"Veja se:"+"\n*esta pesquisa já está cadastrada?"
							+"\n*o nome do laboratório está correto;"+
							"\n*o laboratório já está cadastrado?;");
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
	//PESQUISAR
	private void pesquisar() {
		String sql = "select * from  pesquisas where campoNome_pesquisa  = ?";
	
		try{
			pst=conexao.prepareStatement(sql);
			pst.setString(1, campoNome_pesquisa.getText());
			rs = pst.executeQuery();
			
			if(rs.next()) {
				campoAluno_bolsista.setText(rs.getString(2));
				campoDataInicio_pesquisa.setText(rs.getString(3));
				campoNome_planta.setText(rs.getString(4));
				campoNome_lab.setText(rs.getString(5));
				campoDataFim_pesquisa.setText(rs.getString(6));
				campoNome_orientador.setText(rs.getString(7));
				campoTelefone_orientador.setText(rs.getString(8));
				campoEmail_orientador.setText(rs.getString(9));
				
				
				
				
				
				}else {
					JOptionPane.showMessageDialog(null, "Erro! "+"Veja se:"+"\n*a pesquisa já está cadastrada?"
							+"\n*seu nome foi digitado corretamente?");
				}
		
		
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Você digitou algo errado ou no campo errado");
			System.out.println(e.toString());}
			
	}
	// ::::::::::::::::::::::::::::::::::::::::::::::::::: MÉTODOS ::::::::::::::::::::::::::::::::::::::::::::::::::: //	
	//ALTERAR
	private void alterar(){
		String sql = "update pesquisas set campoAluno_bolsista=?, campoDataInicio=?, campoNome_planta=?, campoPes_lab=?, "
	+"campoDataFim=?, campoNome_orientador=?, campoTelefone_orientador=?, campoEmail_orientador=?  where campoNome_pesquisa=?";
	try {
		pst=conexao.prepareStatement(sql);
		
		pst.setString(1, campoAluno_bolsista.getText());
		pst.setString(2, campoDataInicio_pesquisa.getText());
		pst.setString(3, campoNome_planta.getText());
		pst.setString(4, campoNome_lab.getText());
		pst.setString(5, campoDataFim_pesquisa.getText());
		pst.setString(6, campoNome_orientador.getText());
		pst.setString(7, campoTelefone_orientador.getText());
		pst.setString(8, campoEmail_orientador.getText());
		pst.setString(9, campoNome_pesquisa.getText());
		
		int alterado = pst.executeUpdate();
		if(alterado >0) {
			JOptionPane.showMessageDialog(null, "Alterado com sucesso");
			campoAluno_bolsista.setText(null);
			campoDataInicio_pesquisa.setText(null);
			campoNome_planta.setText(null);
			campoNome_lab.setText(null);
			campoDataFim_pesquisa.setText(null);
			campoNome_orientador.setText(null);
			campoTelefone_orientador.setText(null);
			campoEmail_orientador.setText(null);
			campoNome_pesquisa.setText(null);
		}else {
			JOptionPane.showMessageDialog(null, "Erro"+"\nPrimeiro pesquise usando o campo nome da pesquisa"
		+"\nSe está tentando alterar o laboratório,"+"\n confira se o nome está correto e"
					+"\n veja se o mesmo já está cadastrado no sistema. Senão, cadastre-o primeiro");
		}
		
		
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null,"Certeza que este laboratório já está cadastrado?");
		System.out.println(e);
	}
	}
	
	// ::::::::::::::::::::::::::::::::::::::::::::::::::: MÉTODOS ::::::::::::::::::::::::::::::::::::::::::::::::::: //
			//DELETE
			private void deletar() {
				
				int confirma = JOptionPane.showConfirmDialog(null, "Você ter certeza?", "Atenção", JOptionPane.YES_NO_OPTION);
				if(confirma==0) {
			
				String sqlCom = "delete from pesquisas where campoNome_pesquisa = ?";
				try {
					pst=conexao.prepareStatement(sqlCom);
					pst.setString(1, campoNome_pesquisa.getText());
					
					int del = pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Apagado com sucesso");
					campoAluno_bolsista.setText(null);
					campoDataInicio_pesquisa.setText(null);
					campoNome_planta.setText(null);
					campoNome_lab.setText(null);
					campoDataFim_pesquisa.setText(null);
					campoNome_orientador.setText(null);
					campoTelefone_orientador.setText(null);
					campoEmail_orientador.setText(null);
					campoNome_lab.setText(null);
					
					
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Você digitou algo errado ou no campo errado");
					System.out.println(e.toString());}
					
			}
					
			}
}

