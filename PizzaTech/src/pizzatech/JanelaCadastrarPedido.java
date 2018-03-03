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

public class JanelaCadastrarPedido extends JFrame{
	public class Linha{
		JLabel l;
		JTextField t;
	}
	public JanelaCadastrarPedido(){
		setTitle("Janela de Opcoes"); setLocation(180, 180); setSize(380, 330); setResizable(true); setDefaultCloseOperation(EXIT_ON_CLOSE); getContentPane().setLayout(new FlowLayout());
		JPanel p1 = new JPanel(); p1.setLayout(new GridLayout(6, 2));
		String[] nomeDoLabel = {"Id do cliente:", "Especificação:", "Valor", "Forma de pagamento:", "Troco previsto:", "Id do funcionario:"};
		
		ArrayList<Linha> vL = new ArrayList<Linha>();
		for(int i = 0; i < 6; i++){
			vL.add(new Linha());
			vL.get(i).l = new JLabel(nomeDoLabel[i]);
			p1.add(vL.get(i).l);
			vL.get(i).t = new JTextField(15);
			p1.add(vL.get(i).t);
		}
		p1.setBounds(50, 50, 200, 100);
		add(p1);
		JButton bSalvar = new JButton("Salvar"); bSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] informacoes = new String[13];
				for(int i = 0; i < 3; i++){
					informacoes[i] = vL.get(i).t.getText();
					System.out.println(informacoes[i]);
					vL.get(i).t.setText("");
				}
				Dao.salvarCadastroDePedido(informacoes);
				new JanelaDeOpcoes();
				dispose();
			}
		});
		add(bSalvar);
		setVisible(true);
		/*
		
		*/
	}
}

