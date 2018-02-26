package pizzatech;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaCadastrarFuncionarios extends JFrame{
	public JanelaCadastrarFuncionarios(){
		setTitle("Janela de Opcoes"); setLocation(180, 180); setSize(600, 600); setResizable(true); setDefaultCloseOperation(EXIT_ON_CLOSE); getContentPane().setLayout(new FlowLayout()); getContentPane().setBackground(Color.PINK);
		JPanel p1 = new JPanel(); p1.setSize(400, 400); p1.setLayout(new GridLayout(13, 2)); p1.setBackground(Color.YELLOW);
		String[] nomeDoLabel = {"CPF:", "RG:", "Nome:", "Telefone fixo:", "Celular:", "Endereço:", "Email:", "Data de nascimento:", "Sexo:", "Função:", "Login:", "Senha:", "Confirmar Senha:"};
		ArrayList vC = new ArrayList();
		for(int i = 0; i < 26; i++){
			System.out.println("antes" + i);
			vC.add(new JLabel(nomeDoLabel[i / 2])); p1.add((JLabel)(vC.get(i)));
			i++;
			vC.add(new JTextField(12)); p1.add((JTextField)(vC.get(i)));
			System.out.println("depois" + i);
		}
		add(p1);
		setVisible(true); 
		/*
		Tabela Cadastro de funcionarios
		id
		CPF
		RG
		Nome
		Telefone fixo
		Celular
		Endereço
		Email
		Data de nascimento
		Sexo
		Funcao
		Data de admissao
		Login
		Senha
		*/
	}
}
