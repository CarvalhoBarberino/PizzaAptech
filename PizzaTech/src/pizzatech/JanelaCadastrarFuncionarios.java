package pizzatech;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaCadastrarFuncionarios extends JFrame{
	public class Linha{
		JLabel l;
		JTextField t;
	}
	public JanelaCadastrarFuncionarios(){
		setTitle("Janela de Opcoes"); setLocation(180, 180); setSize(600, 600); setResizable(true); setDefaultCloseOperation(EXIT_ON_CLOSE); getContentPane().setLayout(new FlowLayout()); getContentPane().setBackground(Color.PINK);
		JPanel p1 = new JPanel(); p1.setSize(400, 400); p1.setLayout(new GridLayout(13, 2)); p1.setBackground(Color.YELLOW);
		String[] nomeDoLabel = {"CPF:", "RG:", "Nome:", "Telefone fixo:", "Celular:", "Endereço:", "Email:", "Data de nascimento:", "Sexo:", "Função:", "Login:", "Senha:", "Confirmar Senha:"};
		
		ArrayList<Linha> vL = new ArrayList<Linha>();
		for(int i = 0; i < 13; i++){
			vL.add(new Linha());
			vL.get(i).l = new JLabel(nomeDoLabel[i]);
			p1.add(vL.get(i).l);
			vL.get(i).t = new JTextField(12);
			p1.add(vL.get(i).t);
		}
		add(p1);
		JButton bSalvar = new JButton("Salvar"); bSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] informacoesDosFuncionarios = new String[13];
				if(vL.get(11).t.getText().equals(vL.get(12).t.getText())){
					for(int i = 0; i < 13; i++){
						informacoesDosFuncionarios[i] = vL.get(i).t.getText();
						System.out.println(informacoesDosFuncionarios[i]);
						vL.get(i).t.setText("");
					}
					Dao.salvarCadastroDeFuncionario(informacoesDosFuncionarios);
					JOptionPane.showMessageDialog(null, "O funcionario " + informacoesDosFuncionarios[2] + "foi cadastrado com sucesso");
					new JanelaDeOpcoes();
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Digite a mesma senha no campo \"Confirmar Senha\"");
				}
				
				
				
			}
		});
		add(bSalvar);
		setVisible(true); 
		
	}
}

