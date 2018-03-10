package pizzatech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Dao {
	static final String usuario = "root";
	static final String senhaDoBancoDeDados = "bancodedados";
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
				//String[] nomeDoLabel = {"CPF:", "RG:", "Nome:", "Telefone fixo:", "Celular:", "Endereço:", "Distancia", "Email:", "Data de nascimento:", "Sexo:"};
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
	public static void consultarProduto(String segmentoDeNome){
		try{
			String url = "jdbc:mysql://localhost/pizzatech";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection(url, usuario, senhaDoBancoDeDados);
			PreparedStatement pesquisa = conexao.prepareStatement("SELECT nome, tipo, preco, id FROM pizzatech.produtos WHERE nome LIKE '%" + segmentoDeNome + "%';");
			ResultSet resultado = pesquisa.executeQuery();
			while(resultado.next()){
				System.out.println(resultado.getString("id") + " | " + resultado.getString("nome") + " | " + resultado.getString("tipo") + " | " + resultado.getString("preco"));
			}
			resultado.close();
			pesquisa.close();
			conexao.close();
		}catch(Exception e){
			System.out.println("Erro em:\n    consultarProduto(String segmentoDeNome)");
			e.printStackTrace();
		}
	}
}
