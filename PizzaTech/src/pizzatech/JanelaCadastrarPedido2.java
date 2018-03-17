package pizzatech;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
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

public class JanelaCadastrarPedido2 extends JFrame{
	ArrayList<Produto> vecProdutoOpcoes = new ArrayList<Produto>();
	ArrayList<Produto> vecProdutoAdicionado = new ArrayList<Produto>();
	float total = 0;
	DecimalFormat df = new DecimalFormat("0.00");
	public JanelaCadastrarPedido2(String clienteString, int idDoCliente, String formaDePagamento){
		setTitle("Cadastrar Pedidos 2"); setLocation(180, 180); setSize(650, 500); setResizable(true); setDefaultCloseOperation(EXIT_ON_CLOSE); getContentPane().setLayout(new FlowLayout());setVisible(true);
		int selecionado = 0;
		JTextField tBuscar = new JTextField(50);
		JButton bBuscar = new JButton("Buscar");
		JButton bAdicionar = new JButton("Adicionar");
		DefaultListModel modelo1 = new DefaultListModel();
		JList lista1 = new JList(modelo1);
		JScrollPane rolagem1 = new JScrollPane(lista1);
		DefaultListModel modelo2 = new DefaultListModel();
		JList lista2 = new JList(modelo2);
		JScrollPane rolagem2 = new JScrollPane(lista2);
		JButton bFecharPedido = new JButton("Fechar Pedido");
		JLabel lTotal = new JLabel();
		JLabel lTrocoPara = new JLabel("Troco para: ");
		JTextField tTrocoPara = new JTextField(7);
		tTrocoPara.setText("0");
		getContentPane().add(tBuscar);
		getContentPane().add(bBuscar);
		rolagem1.setPreferredSize(new Dimension(600, 150));
		rolagem2.setPreferredSize(new Dimension(600, 150));
		getContentPane().add(rolagem1);
		getContentPane().add(bAdicionar);
		getContentPane().add(rolagem2);
		if(formaDePagamento.equals("Dinheiro")){
			getContentPane().add(lTrocoPara);
			getContentPane().add(tTrocoPara);
		}
		getContentPane().add(bFecharPedido);
		getContentPane().add(lTotal);
		bFecharPedido.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				float trocoPrevisto = 0;
				if(!((vecProdutoAdicionado.size() < 0) || (formaDePagamento.equals("Dinheiro") && (Integer.valueOf(tTrocoPara.getText()) < total) ))){
					try{
						trocoPrevisto = formaDePagamento.equals("Dinheiro") ? Integer.valueOf(tTrocoPara.getText()) - total : 0;
						Dao.fecharPedido(vecProdutoAdicionado, idDoCliente, Dao.idFuncionario, formaDePagamento, trocoPrevisto);
						new JanelaDeOpcoes();
						dispose();
					}catch(Exception err){
						JOptionPane.showMessageDialog(null, "Preencha corretamente o campo \"Troco para\"");
					}
				}
			}
		});
		
		bBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Buscar Tamanho do vetor = " + vecProdutoAdicionado.size());
				modelo1.clear();
				vecProdutoOpcoes = Dao.consultarProduto(tBuscar.getText().equals("")?"NULO":tBuscar.getText());
				for(int i = 0; i < vecProdutoOpcoes.size(); i++){
					modelo1.addElement(vecProdutoOpcoes.get(i).nome + "	|	R$" + df.format(vecProdutoOpcoes.get(i).preco));
					System.out.println("Encontrado" + vecProdutoOpcoes.get(i).nome + "	|	R$" + df.format(vecProdutoOpcoes.get(i).preco));
				}
			}
		});
		bAdicionar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Adicionar Tamanho do vetor = " + vecProdutoOpcoes.size());
				if(vecProdutoOpcoes.size() > 0){
					int i = lista1.getSelectedIndex();
					vecProdutoAdicionado.add(vecProdutoOpcoes.get(i));
					modelo2.addElement(vecProdutoOpcoes.get(i).nome + "	|	R$" + df.format(vecProdutoOpcoes.get(i).preco));
					System.out.println("Adicionado" + vecProdutoOpcoes.get(i).nome + "	|	R$" + vecProdutoOpcoes.get(i).preco);
					total = 0;
					for(int i1 = 0; i1 < vecProdutoAdicionado.size(); i1++){
						total = total + vecProdutoAdicionado.get(i1).preco;
					}
					lTotal.setText("Valor total do pedido: R$" + df.format(total));
				}
			}
		});
	}
}

