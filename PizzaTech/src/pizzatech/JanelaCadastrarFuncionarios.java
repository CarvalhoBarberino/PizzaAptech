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
		setTitle("Cadastrar Funcionario"); setLocation(180, 180); setSize(300, 320); setResizable(true); setDefaultCloseOperation(EXIT_ON_CLOSE); getContentPane().setLayout(new FlowLayout());
		JPanel p1 = new JPanel(); p1.setLayout(new GridLayout(13, 2));
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
				String[] informacoes = new String[13];
				for(int i = 0; i < 13; i++){
					informacoes[i] = vL.get(i).t.getText();
					System.out.println(informacoes[i]);
					vL.get(i).t.setText("");
				}
				Dao.salvarCadastroDeFuncionario(informacoes);
				new JanelaDeOpcoes();
				dispose();
			}
		});
		add(bSalvar);
		setVisible(true); 
		
	}
}

