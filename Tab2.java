package MeuProjeto;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Tab2 extends JFrame{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new Tab2();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private JLabel pesquisas;
	private JButton ver;
	private JScrollPane scrollTab;
	private JTable tab1;
	private ConexaoBD bd;
	private PreparedStatement pst;
	private ResultSet rs;
	private ImageIcon mostra;

	public Tab2() {
		inicializarComponentes();
		
		definirEventos();
	}
	
public void inicializarComponentes(){
	
		setLayout(null);
		setBounds(200,200,1000,500);
		setResizable(false);
		setBackground(Color.PINK);
		setTitle("Pesquisas");
			
		pesquisas = new JLabel("Pesquisas/projetos registrados");
		pesquisas.setFont(new Font("Comic Sans", Font.ITALIC,18));
		pesquisas.setForeground(Color.BLACK);
		mostra = new ImageIcon(getClass().getResource("/imagem/mostrar.png"));
		ver = new JButton("Ver", mostra);
		ver.setForeground(Color.BLUE);
		ver.setFont(new Font("Verdana", Font.BOLD, 16));
		scrollTab = new JScrollPane();
		bd = new ConexaoBD();
		
		add(pesquisas);
		add(ver);
		add(scrollTab);
		
		pesquisas.setBounds(50,10,290,25);
		ver.setBounds(50,70,170, 50);
		scrollTab.setBounds(50,150,900,300);
		
	}
	
	public void definirEventos(){
		
		ver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String slq = "select * from pesquisas";
				try {
					pst = bd.conectar().prepareStatement(slq);
					rs = pst.executeQuery();
					DefaultTableModel tableModel = new DefaultTableModel (
							new String[] {}, 0) {
						
					};
					
					int qtdeColunas = rs.getMetaData().getColumnCount();
					for(int indice = 1; indice <=qtdeColunas; indice ++)
						tableModel.addColumn(rs.getMetaData().getColumnName(indice));
							tab1 = new JTable(tableModel);
							DefaultTableModel dtm = (DefaultTableModel) tab1.getModel();
							
							while(rs.next()) {
								try {
									String[] dados = new String[qtdeColunas];
									for(int i=1; i<=qtdeColunas; i++) {
										dados[i-1] = rs.getString(i);
									}
									dtm.addRow(dados);
									System.out.println();
								}
								catch(SQLException erro) {
									
								}
								scrollTab.setViewportView(tab1);
							}
							rs.close();
							pst.close();
				}
				catch(Exception erro) {
					System.out.println(erro);
							
				}
				
				
			}
		});
	}
	
}


