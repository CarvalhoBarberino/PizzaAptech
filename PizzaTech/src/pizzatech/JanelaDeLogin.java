package pizzatech;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class JanelaDeLogin extends JFrame{
	public JanelaDeLogin(){
		setTitle("Login"); setLocation(150, 150); setSize(280, 130); setResizable(false); setDefaultCloseOperation(EXIT_ON_CLOSE); getContentPane().setLayout(new FlowLayout());
		JLabel lNomeDoUsuario = new JLabel("Nome do usuário: ");   getContentPane().add(lNomeDoUsuario);
		JTextField tNomeDoUsuario = new JTextField(10);            getContentPane().add(tNomeDoUsuario);        
		JLabel lSenhaDoUsuario = new JLabel("Senha do usuário: "); getContentPane().add(lSenhaDoUsuario);
		JPasswordField tSenhaDoUsuario = new JPasswordField(10);   getContentPane().add(tSenhaDoUsuario);
		JButton bEntrar = new JButton("Entrar");                   getContentPane().add(bEntrar);
		setVisible(true); 
		bEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				int idFuncionario = Dao.conferirSenha(tNomeDoUsuario.getText(), String.valueOf(tSenhaDoUsuario.getPassword()));
				if(idFuncionario <= 0){
					JOptionPane.showMessageDialog(null, "Senha incorreta");
					tNomeDoUsuario.setText("");
					tSenhaDoUsuario.setText("");
				}
				if(idFuncionario > 0){
					Dao.idFuncionario = idFuncionario;
					new JanelaDeOpcoes();
					dispose();
				}
			}
		});
		
		
	}
}
