package MeuProjeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoBD {
	
private Connection conexao;
	
	public Connection conectar() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conexao = DriverManager.getConnection("/*nome do endereço*/"+
				"/*nome do banco de dados do mysql que quer usar*/"+"?user=/*loguin para entrar no mysql*/"+
						      "&password=/*senha pra entrar no mysql*/"
				+"&useSSL=false&useTimezone=true&serverTimezone=UTC");
		System.out.println(" Conectou :) ao banco de dados");
		
		
	}
	catch(ClassNotFoundException e) {
		System.out.println("Driver não encontrado! "+"\n"+"Você NÃO ESTÁ EM CONEXÃO COM O BANCO DE DADOS"+e.toString());
		//JOptionPane.showMessageDialog(null, "erro - Driver não encontrado "+"\n"+"Você NÃO ESTÁ EM CONEXÃO COM O BANCO DE DADOS"+e.toString());
		e.printStackTrace();
	}catch(SQLException e) {
		System.out.println("Falha ao conectar"+"\n"+"Você NÃO ESTÁ EM CONEXÃO COM O BANCO DE DADOS"+e.toString());
		JOptionPane.showMessageDialog(null, "erro  - falha ao conectar"+"\n"+"Você NÃO ESTÁ EM CONEXÃO COM O BANCO DE DADOS"+"\nFeche o programa e chame o técnico"+e.toString());
		e.printStackTrace();
	}
		return conexao;
	}
	
	
	/*
	
	 //quando testei essa conexão, funcionou perfeitamente
	public static void main(String[]args) {
		new ConexaoBD().conectar();
		
	}  */

}
