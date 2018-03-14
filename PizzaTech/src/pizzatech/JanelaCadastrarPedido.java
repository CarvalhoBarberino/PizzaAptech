package pizzatech;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class JanelaCadastrarPedido extends JFrame{
	public class Linha{
		JLabel l;
		JTextField t;
	}
	ArrayList<Produto> vecProdutoOpcoes;
	public JanelaCadastrarPedido(){
		setTitle("Cadastrar Pedidos"); setLocation(180, 180); setSize(650, 400); setResizable(true); setDefaultCloseOperation(EXIT_ON_CLOSE); getContentPane().setLayout(new FlowLayout());setVisible(true);
		int selecionado = 0;
		JTextField tBuscar = new JTextField(50);
		JButton bBuscar = new JButton("Buscar");
		JButton bAdicionar = new JButton("Adicionar");
		DefaultListModel modelo1 = new DefaultListModel();
		JList lista1 = new JList(modelo1);
		JScrollPane rolagem1 = new JScrollPane(lista1);
		getContentPane().add(tBuscar);
		getContentPane().add(bBuscar);
		rolagem1.setPreferredSize(new Dimension(600, 150));
		getContentPane().add(rolagem1);
		getContentPane().add(bAdicionar);
		bBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				modelo1.clear();
				vecProdutoOpcoes = Dao.consultarProduto(tBuscar.getText().equals("")?"NULO":tBuscar.getText());
				for(int i = 0; i < vecProdutoOpcoes.size(); i++){
					modelo1.addElement(vecProdutoOpcoes.get(i).nome + "	|	R$" + vecProdutoOpcoes.get(i).preco);
				}
			}
		});
		bAdicionar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//continuar aqui
			}
		});
	}
}

