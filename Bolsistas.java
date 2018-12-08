package MeuProjeto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import javax.swing.text.*;


public class Bolsistas extends JPanel{
	
	ConexaoBD bd = new ConexaoBD();
	Connection conexao = null;
	PreparedStatement pst, pst1 = null;
	ResultSet rs = null;
	
	Comandos c = new Comandos();// para utlizar o insert - só pra mostrar que aprendi :P, mas a preferência foi fazer os métodos aui mesmo  :)
		
	private JLabel nome_bolsista;
	private JLabel rg_bolsista;
	private JLabel cpf_bolsista;
	private JLabel instituicao_bolsista;
	private JLabel curso_bolsista;
	private JLabel projeto_bolsista;
	private JLabel grau_bolsista;
	private JLabel telefone_bolsista;
	private JLabel cadastro_bolsista;
	private JLabel imagem;
	private JLabel regra;
	
	private JTextField campoNome_bolsista;
	private JFormattedTextField campoRg_bolsista;
	private MaskFormatter mfRg;
	private JFormattedTextField campoCpf_bolsista;
	private MaskFormatter mfCpf;
	private JTextField campoInstituicao_bolsista;
	private JTextField campoCurso_bolsista;
	private JTextField campoLab_bolsista;
	private JTextField campoProjeto_bolsista;
	private JFormattedTextField campoTelefone_bolsista;
	private MaskFormatter mfTel;

	
	private JButton alterar;
	private JButton cadastrar;
	private JButton deletar;
	private JButton pesquisar;
	
	private JList liGrau;
	
	
	private JScrollPane spGrau;
	private ImageIcon cadastro, deleta, pesquisa, altera, img, regras;

	
	
	
	public Bolsistas() {
		inicializarComponentes();
		definirEventos();
		conexao = bd.conectar();
	}

	private void inicializarComponentes() {
		try {
		setLayout(null);
		setBackground(new Color(0,100,0));
		
		
		String[] escolhaGrau = {"","Iniciação científica","Mestrado","Doutorado","Pós-Doc"};
		
		liGrau = new JList(escolhaGrau);
		spGrau = new JScrollPane(liGrau);
				
		mfRg = new MaskFormatter("##.###.###-#");
		mfCpf = new MaskFormatter("###.###.###-##");
		mfTel = new MaskFormatter("(###)####-####");
		
		
		cadastro = new ImageIcon(getClass().getResource("/imagem/cadastrar.png"));
		img = new ImageIcon(getClass().getResource("/imagem/aluno.gif"));
		deleta = new ImageIcon(getClass().getResource("/imagem/deletar.png"));
		pesquisa = new ImageIcon(getClass().getResource("/imagem/pesquisar.png"));
		altera = new ImageIcon(getClass().getResource("/imagem/altera.png"));
		regras = new ImageIcon(getClass().getResource("/imagem/regras4.jpg"));
		
		imagem = new JLabel(img);
		
		regra = new JLabel(regras);
		nome_bolsista = new JLabel ("Nome do Estudante:");
		nome_bolsista.setFont(new Font("Comic Sans", Font.ITALIC,14));
		nome_bolsista.setForeground(Color.white);
		
		rg_bolsista = new JLabel ("RG:");
		rg_bolsista.setFont(new Font("Comic Sans", Font.ITALIC,14));
		rg_bolsista.setForeground(Color.white);
		
		cpf_bolsista = new JLabel ("CPF:");
		cpf_bolsista.setFont(new Font("Comic Sans", Font.ITALIC,14));
		cpf_bolsista.setForeground(Color.white);
		
		instituicao_bolsista = new JLabel ("Instituição de Ensino:");
		instituicao_bolsista.setFont(new Font("Comic Sans", Font.ITALIC,14));
		instituicao_bolsista.setForeground(Color.white);
		
		curso_bolsista = new JLabel ("Nome do curso:");
		curso_bolsista.setFont(new Font("Comic Sans", Font.ITALIC,14));
		curso_bolsista.setForeground(Color.white);
				
		projeto_bolsista = new JLabel ("Projeto que atua:");
		projeto_bolsista.setFont(new Font("Comic Sans", Font.ITALIC,14));
		projeto_bolsista.setForeground(Color.white);
		
		grau_bolsista = new JLabel ("Grau:");
		grau_bolsista.setFont(new Font("Comic Sans", Font.ITALIC,14));
		grau_bolsista.setForeground(Color.white);
		
		telefone_bolsista = new JLabel ("Telefone:");
		telefone_bolsista.setToolTipText("Ex.: (0xx)xxxx-xxxx");
		telefone_bolsista.setFont(new Font("Comic Sans", Font.ITALIC,14));
		telefone_bolsista.setForeground(Color.white);
		
		
		cadastro_bolsista = new JLabel ("Cadastro dos alunos que passaram pela seleção e recebem bolsa");
		cadastro_bolsista.setFont(new Font("Verdana", Font.ITALIC,24));
		cadastro_bolsista.setForeground(Color.white);
		
		
		campoNome_bolsista = new JTextField(100);
		campoRg_bolsista = new JFormattedTextField(mfRg);
		campoCpf_bolsista = new JFormattedTextField(mfCpf);
		campoInstituicao_bolsista = new JTextField(100);
		campoCurso_bolsista = new JTextField(100);
		campoLab_bolsista = new JTextField(100);
		campoProjeto_bolsista = new JTextField(100);
		campoTelefone_bolsista = new JFormattedTextField(mfTel);
		
		
		alterar = new JButton("Alterar", altera);
		alterar.setForeground(new Color(0,100,0));
		alterar.setFont(new Font("Verdana", Font.BOLD, 16));
		
		
		cadastrar = new JButton("Cadastro", cadastro);
		cadastrar.setForeground(new Color(0,100,0));
		cadastrar.setFont(new Font("Verdana", Font.BOLD, 16));
		
		deletar = new JButton("Deletar", deleta);
		deletar.setForeground(new Color(0,100,0));
		deletar.setFont(new Font("Verdana", Font.BOLD, 16));
		
		
		pesquisar = new JButton("Pesquisar", pesquisa);
		pesquisar.setForeground(new Color(0,100,0));
		pesquisar.setFont(new Font("Verdana", Font.BOLD, 16));
		pesquisar.setToolTipText("Use o campo Nome do Estudante");
		
		
		
		add(nome_bolsista);
		add(rg_bolsista);
		add(cpf_bolsista);
		add(instituicao_bolsista);
		add(curso_bolsista);
		add(projeto_bolsista);
		add(grau_bolsista);
		add(telefone_bolsista);
		add(cadastro_bolsista);
		add(campoNome_bolsista);
		add(campoRg_bolsista);
		add(campoCpf_bolsista);
		add(campoInstituicao_bolsista);
		add(campoCurso_bolsista);
		add(campoProjeto_bolsista);
		add(campoTelefone_bolsista);
		add(alterar);
		add(cadastrar);
		add(imagem);
		add(deletar);
		add(pesquisar);
		add(regra);
		
		add(spGrau);
		
		cadastro_bolsista.setBounds(2, 15, 900, 80);
		
		nome_bolsista.setBounds(15, 100, 220, 20);
		campoNome_bolsista.setBounds(15, 130, 300, 20);
		
		rg_bolsista.setBounds(360, 100, 120, 20);
		campoRg_bolsista.setBounds(360, 130, 100, 20);
		
		cpf_bolsista.setBounds(500, 100, 100, 20);
		campoCpf_bolsista.setBounds(500, 130, 100, 20);
		
		instituicao_bolsista.setBounds(15, 170, 200, 20);
		campoInstituicao_bolsista.setBounds(15, 200, 300, 20);
		
		curso_bolsista.setBounds(360, 170, 200, 20);
		campoCurso_bolsista.setBounds(360, 200, 250, 20);
				
		projeto_bolsista.setBounds(15, 240, 150, 20);
		campoProjeto_bolsista.setBounds(15, 270, 300, 20);
		
		grau_bolsista.setBounds(360, 225, 100, 20);
		spGrau.setBounds(360, 245, 126, 70);
		
		telefone_bolsista.setBounds(503, 245, 100, 20);
		campoTelefone_bolsista.setBounds(503, 270, 100, 20);
		
		imagem.setBounds(665, 70, 255, 350);
		cadastrar.setBounds(120, 410, 170, 50);
		alterar.setBounds(290, 410, 170, 50);
		deletar.setBounds(460, 410, 170, 50);
		pesquisar.setBounds(630, 410, 170, 50);
		
		regra.setBounds(1, 442, 890, 259);
		
		
		
		}catch(ParseException erro) {
			erro.printStackTrace();
		}
		
	}
	private void definirEventos(){
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(c.cadastrarBolsista(campoNome_bolsista.getText(), campoRg_bolsista.getText(), campoCpf_bolsista.getText(),
						campoInstituicao_bolsista.getText(), campoCurso_bolsista.getText(), campoProjeto_bolsista.getText(),
						campoTelefone_bolsista.getText(), liGrau.getSelectedIndex())){
				
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
					campoNome_bolsista.setText("");
					campoRg_bolsista.setText("");
					campoCpf_bolsista.setText("");
					campoInstituicao_bolsista.setText("");
					campoCurso_bolsista.setText("");
					campoLab_bolsista.setText("");
					campoProjeto_bolsista.setText("");
					campoTelefone_bolsista.setText("");
					
				}else {
					JOptionPane.showMessageDialog(null, "Erro! "+"Veja se:"+"\n*se RG e/ou CPF já estão cadastrados?"
							+"\n*o nome do projeto está correto?;"
							+"\n*o projeto já está cadastrado?;"
							+"\n*o grau de estudo foi selecionado?");
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
	//PESQUISA
	private void pesquisar() {
		String sql = "select * from  bolsistas where campoNome_bolsista  = ?";
	
		try{
			pst=conexao.prepareStatement(sql);
			pst.setString(1, campoNome_bolsista.getText());
			rs = pst.executeQuery();
			
			if(rs.next()) {
				campoRg_bolsista.setText(rs.getString(2));
				campoCpf_bolsista.setText(rs.getString(3));
				campoInstituicao_bolsista.setText(rs.getString(4));
				campoCurso_bolsista.setText(rs.getString(5));
				campoProjeto_bolsista.setText(rs.getString(6));
				campoTelefone_bolsista.setText(rs.getString(7));
				liGrau.setSelectedIndex(rs.getInt(8));
				
				
				
				
				}else {
					JOptionPane.showMessageDialog(null, "Erro! "+"Veja se:"+"\n*o nome já está cadastrado?"
							+"\n*o nome foi digitado corretamente?");
					}
		
		
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Você digitou algo errado ou no campo errado");
			System.out.println(e.toString());}
			
	}
	// ::::::::::::::::::::::::::::::::::::::::::::::::::: MÉTODOS ::::::::::::::::::::::::::::::::::::::::::::::::::: //
	//DELETE
	private void deletar() {
	
		int confirma = JOptionPane.showConfirmDialog(null, "Você ter certeza?", "Atenção", JOptionPane.YES_NO_OPTION);
		if(confirma==0) {
			String sqlCom = "delete from bolsistas where campoRg_bolsista = ?";
			try {
				
				pst=conexao.prepareStatement(sqlCom);
				pst.setString(1, campoRg_bolsista.getText());
				
				int del = pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Apagado com sucesso");
				campoNome_bolsista.setText(null);
				campoCpf_bolsista.setText(null);
				campoInstituicao_bolsista.setText(null);
				campoCurso_bolsista.setText(null);
				campoProjeto_bolsista.setText(null);
				campoTelefone_bolsista.setText(null);
				campoRg_bolsista.setText(null);
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Você digitou algo errado ou no campo errado");
				System.out.println(e.toString());}
				
		}
		
		}
		
		
	
	// ::::::::::::::::::::::::::::::::::::::::::::::::::: MÉTODOS ::::::::::::::::::::::::::::::::::::::::::::::::::: //	
	//ALTERAR
	private void alterar() {
		
		String sql1 = "update bolsistas set campoNome_bolsista=?, campoCpf_bolsista=?, campoInstituicao_bolsista=?, campoCurso_bolsista=?, "
		+"campoProjeto_bolsista=?, campoTelefone_bolsista=?  where campoRg_bolsista=?";   
		
		try {
		pst1=conexao.prepareStatement(sql1);
		pst1.setString(1, campoNome_bolsista.getText());
		pst1.setString(2, campoCpf_bolsista.getText());
		pst1.setString(3, campoInstituicao_bolsista.getText());
		pst1.setString(4, campoCurso_bolsista.getText());
		pst1.setString(5, campoProjeto_bolsista.getText());
		pst1.setString(6, campoTelefone_bolsista.getText());
		pst1.setString(7, campoRg_bolsista.getText());
		
		int alterado = pst1.executeUpdate();
		if(alterado >0) {
			JOptionPane.showMessageDialog(null, "Alterado com sucesso");
			campoNome_bolsista.setText(null);
			campoCpf_bolsista.setText(null);
			campoInstituicao_bolsista.setText(null);
			campoCurso_bolsista.setText(null);
			campoProjeto_bolsista.setText(null);
			campoTelefone_bolsista.setText(null);
			campoRg_bolsista.setText(null);
			
			
		}else {
			JOptionPane.showMessageDialog(null, "Erro"+"\nSe está tentando alterar o nome do projeto:"
			+ "\n Verifique se se o projeto já está cadastrado"
			+"\n Caso o nome do projeto foi digitado errado, delete o cadastro e refaça-o"
			+"\nVocê não pode alterar RG, se cadastrou errado apague o cadastro e refaça-o "
					+ "\nSe precisar alterar o grau, delete o cadastro e refaça-o corretamente.");
					}
		
		
		
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null,"Você não pode alterar o grau! Se o aluno se formou, delete o cadastro e faça outro.\nO nome do projeto/pesquisa está errado ou não foi cadastrado");
		System.out.println(e);
	}
	}
}





