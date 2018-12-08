package MeuProjeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;


public class Comandos {

	Connection conexao;
	ResultSet rs = null;
	PreparedStatement pst = null;
//#################### ::::: Método para fazer INSERT ::::: ####################//

		//para usar no JPanel Bolsistas//
public boolean cadastrarBolsista(String campoNome_bolsista, String campoRg_bolsista,
		String campoCpf_bolsista, String campoInstituicao_bolsista, String campoCurso_bolsista,
		String campoProjeto_bolsista, String campoTelefone_bolsista, int grau_idgrau) {
	
	String sql = "insert into bolsistas values(?, ?, ?, ?, ?, ?, ?, ?)";
	conexao = new ConexaoBD().conectar();
	
	try {
		PreparedStatement statement = conexao.prepareStatement(sql);
			
			//está pegando o atributo da classe Dados usando o objeto dados
			statement.setString(1, campoNome_bolsista);
			statement.setString(2, campoRg_bolsista);
			statement.setString(3, campoCpf_bolsista);
			statement.setString(4, campoInstituicao_bolsista);
			statement.setString(5, campoCurso_bolsista);
			statement.setString(6, campoProjeto_bolsista);
			statement.setString(7, campoTelefone_bolsista);
			statement.setInt(8, grau_idgrau);
			
			if(statement.executeUpdate() != 0)
				return true;
		
	}catch(SQLException e) {
		e.printStackTrace();
		System.out.println(e.toString());
		JOptionPane.showMessageDialog(null, "Atenção, ou você cadastrou algo errado ou esqueceu de preencher um campo essencial");
	}
	return false;
}


	//para usar no JPanel Laboratorios//
		public boolean cadastrarLaboratorios(String campoNome_lab, String campoRua_lab,
				String campoNumero_lab, String campoComplemento_lab, String campoBairro_lab,
				String campoCep_lab, String campoCidade_lab, int estados_idestados,
				String campoTelefone_lab, String campoEmail_lab){

			String sql = "insert into laboratorios values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conexao = new ConexaoBD().conectar();
			
			try {
				
					PreparedStatement pr = conexao.prepareStatement(sql);
									
					pr.setString(1, campoNome_lab);
					pr.setString(2, campoRua_lab);
					pr.setString(3, campoNumero_lab);
					pr.setString(4, campoComplemento_lab);
					pr.setString(5, campoBairro_lab);
					pr.setString(6, campoCep_lab);
					pr.setString(7, campoCidade_lab);
					pr.setInt(8, estados_idestados);
					pr.setString(9, campoTelefone_lab);
					pr.setString(10, campoEmail_lab);
					
					if(pr.executeUpdate() != 0)
						return true;
				
				
	}catch(SQLException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Atenção, ou você cadastrou algo errado ou esqueceu de preencher um campo essencial");
	}
	return false;
}
		
	//para usar no JPanel Plantas//
		public boolean cadastrarPlantas(String campoNomePop, String campoNomeEsp,
			String campoGenero, String campoNomeFamilia, 
			String campoNomePesquisa, int tipo_tipo){
			
			String sql = "insert into plantas values(?, ?, ?, ?, ?, ?)";
			conexao = new ConexaoBD().conectar();
try{
	PreparedStatement pp = conexao.prepareStatement(sql);
	

pp.setString(1, campoNomePop);
pp.setString(2, campoNomeEsp);
pp.setString(3, campoGenero);
pp.setString(4, campoNomeFamilia);
pp.setString(5, campoNomePesquisa);
pp.setInt(6, tipo_tipo);

if(pp.executeUpdate() != 0)
	return true;

}catch(SQLException e) {
	e.printStackTrace();
	JOptionPane.showMessageDialog(null, "Atenção, ou você cadastrou algo errado ou esqueceu de preencher um campo essencial");
}
return false;
}
		
		
		//para usar no JPanel Pesquisas//
		public boolean cadastrarPesquisas(String campoNome_pequisa, String campoAluno_bolsista,
			String campoDataInicio, String campoNome_planta, String campoPes_lab,
			String campoDataFim, String campoNome_orientador, String campoTelefone_orientador, String campoEmail_orientador){
			String sql = "insert into pesquisas values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conexao = new ConexaoBD().conectar();
			
			try{

				sql = "insert into pesquisas values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pe = conexao.prepareStatement(sql);

pe.setString(1, campoNome_pequisa);
pe.setString(2, campoAluno_bolsista);
pe.setString(3, campoDataInicio);
pe.setString(4, campoNome_planta);
pe.setString(5, campoPes_lab);
pe.setString(6, campoDataFim);
pe.setString(7, campoNome_orientador);
pe.setString(8,campoTelefone_orientador);
pe.setString(9, campoEmail_orientador);

if(pe.executeUpdate() != 0)
	return true;

			}catch(SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Atenção, ou você cadastrou algo errado ou esqueceu de preencher um campo essencial");
			}
			return false;
			}
		
		
		

}
