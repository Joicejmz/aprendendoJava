package MeuProjeto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;

public class TelaLogar extends JFrame{
	
	
	
	private JTextField campoLogar;    
	private JLabel senha;       
	private JLabel logar;        
	private JButton logando;       
	private JButton cancelar;    
	private JPasswordField digaSenha;
	private JLabel label4;
	private ImageIcon image1;
	private ImageIcon imagem2;
	private static TelaLogar frame; // usarei na classe principal
	
	
	
	//CONSTRUTOR//
	
	public TelaLogar(){    
	
		
		inicializarComponentes(); 
		definirEventos();
		
		
		
		
		
	}
	// Método para inicializar componentes //
	private void inicializarComponentes() {
		
		
		setTitle("Login CAPES - Setor 56 - apoio à pesquisa botânica");
		setSize(530, 200);    
		setLayout (null);
		setResizable(false);
		image1 = new ImageIcon(getClass().getResource("/imagem/plantas01.jpg"));
		imagem2 = new ImageIcon(getClass().getResource("/imagem/network.png"));
		
		//Criando objetos//
		campoLogar = new JTextField();  
		campoLogar.setBackground(new Color(250, 250, 210));
		digaSenha = new JPasswordField(5);
		digaSenha.setBackground(new Color(250, 250, 210));
		senha = new JLabel("Senha: ");  
		senha.setFont(new Font("Verdana", Font.BOLD, 18));
		senha.setForeground(new Color(0, 100, 0));
		logar = new JLabel("Login: ");
		logar.setFont(new Font ("Verdana", Font.BOLD, 18));
		logar.setForeground(new Color(0, 100, 0));
		logando = new JButton("Logar", imagem2);
		logando.setForeground(new Color(0, 100, 0));
		logando.setBackground(new Color(250, 250, 210));
		logando.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cancelar = new JButton("Cancelar");
		cancelar.setBackground(new Color(250, 250, 210));
		cancelar.setForeground(new Color(0, 100, 0));
		cancelar.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		label4 = new JLabel(image1, JLabel.CENTER);
		//label4.setFont(new Font("Serif", Font.BOLD, 20));
		//label4.setForeground(Color.black);
		
		
	
		
	//AdicionandoAdiciona elementos à frame//	
		add(campoLogar);     //os componentes graficos são adicionados ao frame como um quebra cabeças 
		add(senha);     //estes são adicionados ao que foi definido anteriormente 
		add(logar);
		add(logando);
		add(cancelar);
		add(digaSenha);
		add(label4);
		
	
		
//Definindo o tamanho e o posicionamento dos elementos//
		
		campoLogar.setBounds(100, 30, 120, 25);    
		logar.setBounds(30, 30, 80, 25);
		senha.setBounds(30, 75, 80, 25);
		digaSenha.setBounds(100, 75, 120, 25);
		logando.setBounds(20, 120, 100, 25);
		cancelar.setBounds(125, 120, 100, 25);
		label4.setBounds(240, 15, 250, 130);
		
		
		
	}
	//Método que define os eventos dos componentes//	
	private void definirEventos(){     //definição de um método "filho" do anterior que define os eventos 
		logando.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String senha = String.valueOf(digaSenha.getPassword()); // o método getPassword retorna uma matriz de caracter eo o metodo valueOf convert em uma String
				if (campoLogar.getText().equals("joice") && senha.equals("mafagafos")){ //testa se a senha esta correta e o loguin
						 frame.setVisible(false);
						 
						ConexaoBD logar = new ConexaoBD();  
						new ConexaoBD().conectar();
						 //se senha e login estiverem corretos o sistema já tenta conectar ao Banco de Dados
						// se logar e não conectar, o usuário receberá um aviso						 
						TelaMenu.abrir();
				}else{
					JOptionPane.showMessageDialog(null, "Loguin ou senha incorretos");
				}
				
			}
			
			
		});
		
		cancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						String[] escolha = {"SIM", "NÃO"};
						int opcao;
						
						opcao = JOptionPane.showOptionDialog(null, "Deseja realmente sair?", "Login CAPES - Setor 56", 
								JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha,"NÃO");
				if(opcao==0) {
				System.exit(0); }                           
			}
		});
	}
	
	
	//Método principal //
	public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
	public void run() {
	frame = new TelaLogar();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Dimension tela = Toolkit.getDefaultToolkit().getScreenSize(); // métodos que manipulam dimensão da tela do ambiente gráfico peguei do exercício de aprendizagem :P 
	frame.setLocation((tela.width - (frame).getSize().width)/2,          
	(tela.height - frame.getSize().height)/2);		   // centraliza janela coluna e a janela linha 
		frame.setVisible(true);
				
				
			}
		});
	}
}

