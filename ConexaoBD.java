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
		conexao = DriverManager.getConnection("jdbc:mysql://esn509vmysql:3306/"+// no senai �: "jdbc:mysql://esn509vmysql:3306/"
				"projetojoice"+"?user=aluno"+"&password=Senai1234"
				+"&useSSL=false&useTimezone=true&serverTimezone=UTC");
		System.out.println(" Conectou :) ao banco de dados");
		
		
	}
	catch(ClassNotFoundException e) {
		System.out.println("Driver n�o encontrado! "+"\n"+"Voc� N�O EST� EM CONEX�O COM O BANCO DE DADOS"+e.toString());
		//JOptionPane.showMessageDialog(null, "erro - Driver n�o encontrado "+"\n"+"Voc� N�O EST� EM CONEX�O COM O BANCO DE DADOS"+e.toString());
		e.printStackTrace();
	}catch(SQLException e) {
		System.out.println("Falha ao conectar"+"\n"+"Voc� N�O EST� EM CONEX�O COM O BANCO DE DADOS"+e.toString());
		JOptionPane.showMessageDialog(null, "erro  - falha ao conectar"+"\n"+"Voc� N�O EST� EM CONEX�O COM O BANCO DE DADOS"+"\nFeche o programa e chame o t�cnico"+e.toString());
		e.printStackTrace();
	}
		return conexao;
	}
	
	
	/*
	
	 //quando testei essa conex�o, funcionou perfeitamente
	public static void main(String[]args) {
		new ConexaoBD().conectar();
		
	}  */

}
