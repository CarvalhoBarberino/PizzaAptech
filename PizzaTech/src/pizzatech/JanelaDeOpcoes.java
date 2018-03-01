package pizzatech;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class JanelaDeOpcoes extends JFrame{
    public JanelaDeOpcoes(){
        setTitle("Janela de Opcoes"); setLocation(170, 170); setSize(300, 300); setResizable(true); setVisible(true); setDefaultCloseOperation(EXIT_ON_CLOSE); getContentPane().setLayout(new GridLayout(6, 1));
        JButton bCadastrarFuncionario = new JButton("Cadastrar funcionario"); add(bCadastrarFuncionario); bCadastrarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new JanelaCadastrarFuncionarios();
                dispose();
            }
        });
        
        JButton bCadastrarCliente = new JButton("Cadastrar cliente"); add(bCadastrarCliente); bCadastrarCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new JanelaCadastrarCliente();
				dispose();
				
			}
		});
        JButton bCadastrarProduto = new JButton("Cadastrar produto"); add(bCadastrarProduto); bCadastrarProduto.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				new JanelaCadastrarProduto();
				dispose();
			}
		});
        JButton bCadastrarPedido = new JButton("Cadastrar pedido"); add(bCadastrarPedido); bCadastrarPedido.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new JanelaCadastrarPedido();
				dispose();
			}
		});
        JButton bBalanco = new JButton("Consultar Balanço"); add(bBalanco);
        
        JButton bDeslogar = new JButton("Deslogar"); add(bDeslogar); bDeslogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new JanelaDeLogin();
                dispose();
            }
        });
    }
}
