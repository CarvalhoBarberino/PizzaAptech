package pizzatech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Dao {
	static final String usuario = "root";
	static final String senhaDoBancoDeDados = "bancodedados";
	public static int idFuncionario = 0;
	public static int conferirSenha(String nome, String senha){
		try{
			idFuncionario = -1;
			String url = "jdbc:mysql://localhost/pizzatech";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection(url, usuario, senhaDoBancoDeDados);
			PreparedStatement pesquisa = conexao.prepareStatement("SELECT id, login, senha FROM pizzatech.funcionarios WHERE login=\"" + nome + "\";");
			ResultSet resultado = pesquisa.executeQuery();
			while(resultado.next()){
				if(resultado.getString("senha").equals(senha)){
					idFuncionario = resultado.getInt("id");
					System.out.println("id do funcionario = " + idFuncionario);
				}
			}
			resultado.close();
			pesquisa.close();
			conexao.close();
			return idFuncionario;
		}catch(Exception e){
			System.out.println("Erro em:\n    Dao.conferirSenha(String nome, String senha)");
			e.printStackTrace();
			return -1;
		}
	}
	public static boolean salvarCadastroDeFuncionario(String[] informacoesArg){
		try{
			Boolean todosCamposPreenchidos = true;
			for(int i = 0; i < 13 ; i++){
				if(informacoesArg[i].equals("")){
					todosCamposPreenchidos = false;
				}
			}
			if(informacoesArg[11].equals(informacoesArg[12]) && todosCamposPreenchidos){
				String url = "jdbc:mysql://localhost/pizzatech";
				Class.forName("com.mysql.jdbc.Driver");
				Connection conexao = DriverManager.getConnection(url, usuario, senhaDoBancoDeDados);
				PreparedStatement pesquisa = conexao.prepareStatement("INSERT INTO `pizzatech`.`funcionarios` (`cpf`, `rg`, `nome`, `telefonefixo`, `celular`, `endereco`, `email`, `datanascimento`, `sexo`, `funcao`, `dataadmissao`, `login`, `senha`) VALUES ('" + informacoesArg[0] + "', '" + informacoesArg[1] + "', '" + informacoesArg[2] + "', '" + informacoesArg[3] + "', '" + informacoesArg[4] + "', '" + informacoesArg[5] + "', '" + informacoesArg[6] + "', '" + informacoesArg[7] + "', '" + informacoesArg[8] + "', '" + informacoesArg[9] + "', '" + new SimpleDateFormat("dd/MM/yyyy").format(new Date()) + "', '" + informacoesArg[10] + "', '" + informacoesArg[11] + "');");
				pesquisa.execute();
				pesquisa.close();
				conexao.close();
				System.out.println("INSERT INTO `pizzatech`.`funcionarios` (`cpf`, `rg`, `nome`, `telefonefixo`, `celular`, `endereco`, `email`, `datanascimento`, `sexo`, `funcao`, `dataadmissao`, `login`, `senha`) VALUES ('" + informacoesArg[0] + "', '" + informacoesArg[1] + "', '" + informacoesArg[2] + "', '" + informacoesArg[3] + "', '" + informacoesArg[4] + "', '" + informacoesArg[5] + "', '" + informacoesArg[6] + "', '" + informacoesArg[7] + "', '" + informacoesArg[8] + "', '" + informacoesArg[9] + "', '" + new SimpleDateFormat("dd/MM/yyyy").format(new Date()) + "', '" + informacoesArg[10] + "', '" + informacoesArg[11] + "');");
				return true;
			}
			else{
				JOptionPane.showMessageDialog(null, "1) Todos os campos devem estar preenchidos.\n2) A senha deve ser igual nos dois campos.");
				return false;
			}
		}catch(Exception e){
			System.out.println("Erro em:\n    Dao.salvarCadastroDeFuncionario(String[] informacoesArg)");
			e.printStackTrace();
			return false;
		}
	}
	public static void salvarCadastroDeCliente(String[] informacoesArg){
		try{
			Boolean todosCamposPreenchidos = true;
			for(int i = 0; i < 10 ; i++){
				if(informacoesArg[i].equals("")){
					todosCamposPreenchidos = false;
				}
			}
			if(todosCamposPreenchidos){
				String url = "jdbc:mysql://localhost/pizzatech";
				Class.forName("com.mysql.jdbc.Driver");
				Connection conexao = DriverManager.getConnection(url, usuario, senhaDoBancoDeDados);
				PreparedStatement pesquisa = conexao.prepareStatement("INSERT INTO `pizzatech`.`clientes` (`cpf`, `rg`, `nome`, `telefonefixo`, `celular`, `endereco`, `distanciametros`, `email`, `datanascimento`, `sexo` ,`datadoprimeiropedido`) VALUES ('" + informacoesArg[0] + "', '" + informacoesArg[1] + "', '" + informacoesArg[2] + "', '" + informacoesArg[3] + "', '" + informacoesArg[4] + "', '" + informacoesArg[5] + "', '" + informacoesArg[6] + "', '" + informacoesArg[7] + "', '" + informacoesArg[8] + "', '" + informacoesArg[9] + "', '" + new SimpleDateFormat("dd/MM/yyyy").format(new Date()) + "');");
				System.out.println("INSERT INTO `pizzatech`.`clientes` (`cpf`, `rg`, `nome`, `telefonefixo`, `celular`, `endereco`, `distanciametros`, `email`, `datanascimento`, `sexo` ,`datadoprimeiropedido`) VALUES ('" + informacoesArg[0] + "', '" + informacoesArg[1] + "', '" + informacoesArg[2] + "', '" + informacoesArg[3] + "', '" + informacoesArg[4] + "', '" + informacoesArg[5] + "', '" + informacoesArg[6] + "', '" + informacoesArg[7] + "', '" + informacoesArg[8] + "', '" + informacoesArg[9] + "', '" + new SimpleDateFormat("dd/MM/yyyy").format(new Date()) + "');");
				pesquisa.execute();
				pesquisa.close();
				conexao.close();
			}
			else{
				JOptionPane.showMessageDialog(null, "1) Todos os campos devem estar preenchidos.");
			}
		}catch(Exception e){
			System.out.println("Erro em:\n    salvarCadastroDeCliente(String[] informacoesArg)");
			e.printStackTrace();
		}
	}
	public static void salvarCadastroDeProduto(String[] informacoesArg){
		try{
			Boolean todosCamposPreenchidos = true;
			for(int i = 0; i < 3 ; i++){
				if(informacoesArg[i].equals("")){
					todosCamposPreenchidos = false;
				}
			}
			if(todosCamposPreenchidos){
				String url = "jdbc:mysql://localhost/pizzatech";
				Class.forName("com.mysql.jdbc.Driver");
				Connection conexao = DriverManager.getConnection(url, usuario, senhaDoBancoDeDados);
				//String[] nomeDoLabel = {"Nome:", "Tipo:", "Preço:"};
				PreparedStatement pesquisa = conexao.prepareStatement("INSERT INTO `pizzatech`.`produtos` (`nome`, `tipo`, `preco`, `sequencia`) VALUES ('" + informacoesArg[0] + "', '" + informacoesArg[1] + "', '" + informacoesArg[2] + "', '0');");
				System.out.println("INSERT INTO `pizzatech`.`produtos` (`nome`, `tipo`, `preco`, `sequencia`) VALUES ('" + informacoesArg[0] + "', '" + informacoesArg[1] + "', '" + informacoesArg[2] + "', '0');");
				pesquisa.execute();
				pesquisa.close();
				conexao.close();
			}
			else{
				JOptionPane.showMessageDialog(null, "1) Todos os campos devem estar preenchidos.");
			}
		}catch(Exception e){
			System.out.println("Erro em:\n    salvarCadastroDeProduto(String[] informacoesArg)");
			e.printStackTrace();
		}
	}
	public static ArrayList<Produto> consultarProduto(String segmentoDeNome){
		ArrayList<Produto> vecProduto = new ArrayList<Produto>();
		try{
			String url = "jdbc:mysql://localhost/pizzatech";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection(url, usuario, senhaDoBancoDeDados);
			PreparedStatement pesquisa = conexao.prepareStatement("SELECT nome, tipo, preco, id FROM pizzatech.produtos WHERE nome LIKE '%" + segmentoDeNome + "%';");
			ResultSet resultado = pesquisa.executeQuery();
			while(resultado.next()){
				Produto x = new Produto();
				x.id = resultado.getInt("id");
				x.nome = resultado.getString("nome");
				x.tipo = resultado.getString("tipo");
				x.preco = (float) resultado.getFloat("preco");
				vecProduto.add(x);
			}
			resultado.close();
			pesquisa.close();
			conexao.close();
		}catch(Exception e){
			System.out.println("Erro em:\n    consultarProduto(String segmentoDeNome)");
			e.printStackTrace();
		}
		return vecProduto;
	}
	public static void fecharPedido(ArrayList<Produto> vecProduto, int idDoCliente, int idFuncionario, String formaDePagamento, float trocoPrevisto){
		try{
			String comandoSql;
			String url = "jdbc:mysql://localhost/pizzatech";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection(url, usuario, senhaDoBancoDeDados);
			PreparedStatement pesquisa;
			ResultSet resultado;
			String especificacao = "";
			float preco = 0;
			int[] vecQuant = new int[vecProduto.size()];
			for(int i = 0; i < vecProduto.size(); i++){//Este laco é importante pois cada elemento precisa inicializar com quantidade = 1
				vecQuant[i] = 1;
			}
			for(int cursorEsquerda = 0; cursorEsquerda < vecProduto.size(); cursorEsquerda++){//Unir produtor iguais
				for(int cursorDireita = cursorEsquerda + 1; cursorDireita < vecProduto.size(); cursorDireita++){
					if(vecProduto.get(cursorEsquerda).id == vecProduto.get(cursorDireita).id){
						vecQuant[cursorEsquerda]++;
						vecProduto.remove(cursorDireita);
						cursorDireita--;
					}
				}
			}
			for(int i = 0; i < vecProduto.size(); i++){
				int upDateSequencia = 0;
				especificacao = especificacao + " | " + vecQuant[i] + " | " + vecProduto.get(i).tipo + " | " + vecProduto.get(i).nome + "\n";
				preco = preco + vecQuant[i] * vecProduto.get(i).preco;
				comandoSql = "SELECT id, sequencia FROM pizzatech.produtos WHERE id='" + vecProduto.get(i).id + "';";
				pesquisa = conexao.prepareStatement(comandoSql);
				resultado = pesquisa.executeQuery();
				while(resultado.next()){
					upDateSequencia = resultado.getInt("sequencia") + vecQuant[i];
				}
				comandoSql = "UPDATE `pizzatech`.`produtos` SET `sequencia`='" + upDateSequencia + "' WHERE `id`='" + vecProduto.get(i).id + "';";
				System.out.println(comandoSql);
				pesquisa = conexao.prepareStatement(comandoSql);
				pesquisa.execute();
				pesquisa.close();
			}
			comandoSql = "INSERT INTO `pizzatech`.`pedidos` (`data`, `idcliente`, `especificacao`, `valor`, `formadepagamento`, `trocoprevisto`, `iddofuncionario`) VALUES ('" + new SimpleDateFormat("dd/MM/yyyy").format(new Date()) + "', '" + idDoCliente + "', '" + especificacao + "', '" + preco + "', '" + formaDePagamento + "', '" + trocoPrevisto + "', '" + idFuncionario + "');";
			System.out.println(comandoSql);
			imprimirPedido(idDoCliente, idFuncionario, especificacao, formaDePagamento, trocoPrevisto, preco);
			pesquisa = conexao.prepareStatement(comandoSql);
			pesquisa.execute();
			pesquisa.close();
			conexao.close();
			
		}catch(Exception err){
			System.out.println("Erro em:\n    fecharPedido(ArrayList<Produto> vecProduto, int idDoCliente, int idFuncionario, int formaDePagamento, float trocoPrevisto)");
			err.printStackTrace();
		}
	}
	public static String[] consultarCliente(String segmentoNome){
		String[] vecString = null;
		int i = 0;
		String sql = "SELECT nome, telefonefixo, celular, endereco, id FROM pizzatech.clientes WHERE nome LIKE '%" + segmentoNome + "%';";
		try{
			String url = "jdbc:mysql://localhost/pizzatech";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection(url, usuario, senhaDoBancoDeDados);
			PreparedStatement pesquisa = conexao.prepareStatement(sql);
			ResultSet resultado = pesquisa.executeQuery();
			resultado.last();
			vecString = new String[resultado.getRow()];
			resultado.beforeFirst();
			while(resultado.next()){
				vecString[i] = resultado.getString(5) + " ; " + resultado.getString(1) + " | " + resultado.getString(2) + " | " + resultado.getString(3) + " | " + resultado.getString(4);
				System.out.println("Dao " + vecString[i]);
				i++;
			}
			resultado.close();
			pesquisa.close();
			conexao.close();
			return vecString;
		}catch(Exception err){
			System.out.println("Erro em:\n    consultarCliente(String segmentoNome)");
			err.printStackTrace();
		}
		return vecString;
	}
	public static void imprimirPedido(int idDoCliente, int idFuncionario, String especificacao, String formaDePagamento, float trocoPrevisto, float preco){
		String imprimir = "";
		try{
			String url = "jdbc:mysql://localhost/pizzatech";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection(url, usuario, senhaDoBancoDeDados);
			PreparedStatement pesquisa = conexao.prepareStatement("SELECT nome, telefonefixo, celular, endereco id FROM pizzatech.clientes WHERE id='" + idDoCliente + "';");
			ResultSet resultado = pesquisa.executeQuery();
			while(resultado.next()){
				//+ "\nENDERECO: " + resultado.getString("endereco") 
				imprimir = "CLIENTE: " + resultado.getString("nome") + "\nTELEFONES: " + resultado.getString("telefonefixo") + "    " + resultado.getString("celular") + "\n----------------\n\n";
				imprimir = imprimir + "\nENDERECO: " + resultado.getString("nome") + "\n";
			}
			imprimir = imprimir + "ESPECIFICAÇÃO:\n" + especificacao + "\n----------------\n\n" + "FORMA DE PAGAMENTO: " + formaDePagamento + "\nTROCO PREVISTO: " + trocoPrevisto + "\nPRECO TOTAL: " + preco;
			resultado.close();
			pesquisa.close();
			conexao.close();
			JFrame jImprimirPedido = new JFrame("Imprimir pedido");
			jImprimirPedido.setBounds(200, 200, 600, 600); jImprimirPedido.setVisible(true);
			JTextArea tArea = new JTextArea();
			tArea.setSize(500, 400); tArea.setText(imprimir);
			jImprimirPedido.add(tArea);
			
		}catch(Exception e){
			System.out.println("Erro em:\n    imprimirPedido(int idDoCliente, int idFuncionario, String especificacao, String formaDePagamento, float trocoPrevisto)");
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
