package pizzatech;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
		JButton bSelecionar = new JButton("Selecionar");
		JComboBox cFormaDePagamento = new JComboBox(new String[]{"", "Dinheiro", "Debito", "Credito", "Deposito", "Conta Caderno"});
		JLabel lEscolhaFormaPagamento = new JLabel("Escolha a forma de pagamento");
		getContentPane().add(lDigiteNomeCliente);
		getContentPane().add(tBuscar);
		getContentPane().add(bBuscar);
		bBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				modelo1.clear();
				vecString = Dao.consultarCliente(tBuscar.getText());
				for(int i = 0; i < vecString.length; i++){
					modelo1.addElement(vecString[i]);
					System.out.println(i + " < " + vecString.length + " | " + vecString[i]);
				}
			}
		});
		rolagem1.setPreferredSize(new Dimension(600, 150));
		getContentPane().add(rolagem1);
		getContentPane().add(lEscolhaFormaPagamento);
		getContentPane().add(cFormaDePagamento);
		getContentPane().add(bSelecionar);
		bSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!cFormaDePagamento.getSelectedItem().equals("")) && (!lista1.isSelectionEmpty())){
					int fimDoId = vecString[lista1.getSelectedIndex()].indexOf(";") - 1;
					String stringSelecionada = vecString[lista1.getSelectedIndex()];
					String segmentoId = stringSelecionada.substring(0, fimDoId);
					int id = Integer.valueOf(segmentoId);
					new JanelaCadastrarPedido2(stringSelecionada, id, (String)cFormaDePagamento.getSelectedItem());
					System.out.println("JanelaCadastrarPedido2(\"" + stringSelecionada + "\", \"" + id + "\", \"" + (String)cFormaDePagamento.getSelectedItem() + "\"");
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Escolha o cliente e a forma de pagamento");
				}
			}
		});
	}
}
