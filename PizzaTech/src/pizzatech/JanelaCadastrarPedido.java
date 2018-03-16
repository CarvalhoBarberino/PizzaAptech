package pizzatech;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class JanelaCadastrarPedido extends JFrame{
	String[] vecString;
	public JanelaCadastrarPedido(){
		setTitle("Cadastrar Pedidos 2"); setLocation(180, 180); setSize(650, 500); setResizable(true); setDefaultCloseOperation(EXIT_ON_CLOSE); getContentPane().setLayout(new FlowLayout());setVisible(true);
		DefaultListModel modelo1 = new DefaultListModel();
		JList lista1 = new JList(modelo1);
		JScrollPane rolagem1 = new JScrollPane(lista1);
		JLabel lDigiteNomeCliente = new JLabel("Digite nome do cliente:");
		JTextField tBuscar = new JTextField(50);
		JButton bBuscar = new JButton("Buscar");
		JButton bAdicionar = new JButton("Adicionar");
		getContentPane().add(lDigiteNomeCliente);
		getContentPane().add(tBuscar);
		getContentPane().add(bBuscar);
		bBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				vecString = Dao.consultarCliente(tBuscar.getText());
				for(int i = 0; i < vecString.length; i++){
					modelo1.addElement(vecString[i]);
					System.out.println(i + " < " + vecString.length + " | " + vecString[i]);
				}
			}
		});
		rolagem1.setPreferredSize(new Dimension(600, 150));
		getContentPane().add(rolagem1);
		getContentPane().add(bAdicionar);
		bAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new JanelaCadastrarPedido2(vecString[lista1.getSelectedValue()]);
				dispose();
			}
		});
		
		
	}
}
