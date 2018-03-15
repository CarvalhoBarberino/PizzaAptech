package pizzatech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Dao {
	static final String usuario = "root";
	static final String senhaDoBancoDeDados = "dadossentados";
	public static boolean conferirSenha(String nome, String senha){
		try{
			Boolean senhaConfirmada = false;
			String url = "jdbc:mysql://localhost/pizzatech";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection(url, usuario, senhaDoBancoDeDados);
			PreparedStatement pesquisa = conexao.prepareStatement("SELECT login, senha FROM pizzatech.funcionarios WHERE login=\"" + nome + "\";");
			ResultSet resultado = pesquisa.executeQuery();
			while(resultado.next()){
				if(resultado.getString("senha").equals(senha)){
					senhaConfirmada = true;
				}
			}
			resultado.close();
			pesquisa.close();
			conexao.close();
			return senhaConfirmada;
		}catch(Exception e){
			System.out.println("Erro em:\n    Dao.conferirSenha(String nome, String senha)");
			e.printStackTrace();
			return false;
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
				PreparedStatement pesquisa = conexao.prepareStatement("INSERT INTO `pizzatech`.`produtos` (`nome`, `tipo`, `preco`) VALUES ('" + informacoesArg[0] + "', '" + informacoesArg[1] + "', '" + informacoesArg[2] + "');");
				System.out.println("INSERT INTO `pizzatech`.`produtos` (`nome`, `tipo`, `preco`) VALUES ('" + informacoesArg[0] + "', '" + informacoesArg[1] + "', '" + informacoesArg[2] + "');");
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
	public static void fecharPedido(ArrayList<Produto> vecProduto, int idDoCliente){
		try{
			String url = "jdbc:mysql://localhost/pizzatech";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection(url, usuario, senhaDoBancoDeDados);
			String comandoSql = continuar aqui "INSERT INTO `pizzatech`.`pedidos` (`data`, `idcliente`, `especificacao`, `valor`, `formadepagamento`, `trocoprevisto`, `iddofuncionario`) VALUES ('14/03/2018', '1', 'bla bla bla', '13', 'Denheiro', '11', '1');";
			PreparedStatement pesquisa = conexao.prepareStatement(comandoSql);
			
		}catch(Exception err){
			
		}
	}
	
	
	
	
	
	
	
	
}
