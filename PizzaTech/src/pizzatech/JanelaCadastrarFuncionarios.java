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
        setTitle("Janela de Opcoes"); setLocation(180, 180); setSize(600, 600); setResizable(true); setVisible(true); setDefaultCloseOperation(EXIT_ON_CLOSE); getContentPane().setLayout(new FlowLayout());
        JPanel p1 = new JPanel(); p1.setLayout(new GridLayout(13, 2));
        JLabel lCPF = new JLabel("CPF:"); p1.add(lCPF);
        JTextField tCPF = new JTextField(12); p1.add(tCPF);
        
        add(p1);
    }
}
