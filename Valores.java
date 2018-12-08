package MeuProjeto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Valores extends JPanel{
		
	private JButton btCalcular; 

    
    private JTextField quantidade, tfValorBolsista; 
    private ImageIcon imagemCapes;
    private JLabel grau; 
    private JLabel texto;
    private JLabel simulacao;
	private JLabel caixaImagemCapes;
    private JList liGrau; 

    private JScrollPane spLista; 

 

    public Valores() { 

        inicializarComponentes(); 
        definirEventos(); 

    } 

 

    private void inicializarComponentes() { 

    	setLayout(null);
		setBackground(new Color(0,100,0));

        String[] escolhaGrau = {"Inicia��o cient�fica","Mestrado","Doutorado","P�s-Doc"}; 

        imagemCapes = new ImageIcon(getClass().getResource("/imagem/capes.jpg"));
        btCalcular = new JButton("Calcular"); 

        grau = new JLabel("Informe a quantidade de bolsistas"); 
        texto = new JLabel("Aporte financeiro ao laborat�rio: grau/aluno");
        simulacao = new JLabel("Fa�a a simula��o dos valores antes de liberar a verba");
        caixaImagemCapes = new JLabel(imagemCapes);
        

        liGrau = new JList(escolhaGrau); // adicionando array no objeto JList 

        tfValorBolsista = new JTextField(); 
        quantidade = new JTextField(); 

        spLista = new JScrollPane(liGrau);// barra de rolagem  

        btCalcular.setToolTipText("Faz o c�lculo"); // criando um texto auxiliar no bot�o 
        btCalcular.setMnemonic(KeyEvent.VK_C); // cria tecla de atalho para o bot�o "alt c" 
        
        simulacao.setBounds(17, 450, 700, 80);
        simulacao.setFont(new Font("Comic Sans", Font.BOLD,18));
        simulacao.setForeground(Color.white);
                
        texto.setBounds(50, 10, 700, 80);
        texto.setFont(new Font("Comic Sans", Font.BOLD,22));
        texto.setForeground(Color.white);
        
        grau.setBounds(80, 105, 350, 25);
        grau.setFont(new Font("Comic Sans", Font.ITALIC,20));
        grau.setForeground(Color.white);
        
        quantidade.setBounds(215, 160, 70, 25); 
        spLista.setBounds(170, 200, 170, 55); 
        btCalcular.setBounds(200, 280, 90, 50); 
        tfValorBolsista.setBounds(165, 350, 170, 25);
        caixaImagemCapes.setBounds(510, 10, 390, 650);

        add(btCalcular); 

        add(grau); 
        add(texto);
        add(simulacao);
        add(caixaImagemCapes);
        add(quantidade); 
        add(spLista); 
        add(tfValorBolsista); 
        

    } 

    private void definirEventos() { 

        btCalcular.addActionListener(new ActionListener() { 

            public void actionPerformed(ActionEvent arg0) { 

                if (quantidade.getText().equals("")) { 

                	quantidade.requestFocus();// prompt pisca no campo selecionado  

                    return; 

                } 

                try { 

                    float valor = Float.parseFloat(quantidade.getText()); 

                    if (liGrau.getSelectedIndex() == -1) { //list retorna -1 um caso n�o foi nada selecionado 

                        JOptionPane.showMessageDialog(null, "Selecione um item da lista"); 

                        return; 

                    } 

                    float aluno = 400.55f;

                    if (liGrau.getSelectedIndex() == 1) {

                    	aluno = 857.63f; 

              } else if (liGrau.getSelectedIndex() == 2) { 

            	  aluno = 1200f; 

             } else if (liGrau.getSelectedIndex() == 3) { 

            	 aluno = 1987.32f; 
             }
            

                      tfValorBolsista.setText("" + valor * aluno); 

                }

                catch (NumberFormatException erro) { 

                    JOptionPane.showMessageDialog(null, "Forne�a apenas valores num�ricos\n" + 

                            erro.toString()); 

                    quantidade.requestFocus(); 

                } 

            } 

        }); 

    }

}
