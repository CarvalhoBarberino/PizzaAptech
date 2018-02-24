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
        setTitle("Login"); setLocation(150, 150); setSize(280, 130); setResizable(true); setVisible(true); setDefaultCloseOperation(EXIT_ON_CLOSE); getContentPane().setLayout(new FlowLayout());
        JLabel lNomeDoUsuario = new JLabel("Nome do usuário: ");   add(lNomeDoUsuario);
        JTextField tNomeDoUsuario = new JTextField(10);            add(tNomeDoUsuario);        
        JLabel lSenhaDoUsuario = new JLabel("Senha do usuário: "); add(lSenhaDoUsuario);
        JPasswordField tSenhaDoUsuario = new JPasswordField(10);   add(tSenhaDoUsuario);
        JButton bEntrar = new JButton("Entrar");                   add(bEntrar);
        bEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean senhaCorreta = Dao.conferirSenha(tNomeDoUsuario.getText(), String.valueOf(tSenhaDoUsuario.getPassword()));
                if(!senhaCorreta){
                    JOptionPane.showMessageDialog(null, "Senha incorreta");
                    tNomeDoUsuario.setText("");
                    tSenhaDoUsuario.setText("");
                }
                if(senhaCorreta){
                    new JanelaDeOpcoes();
                    dispose();
                }
            }
        });
        
        
    }
}
