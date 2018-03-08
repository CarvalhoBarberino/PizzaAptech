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
	public static void salvarCadastroDeFuncionario(String[] informacoesArg){
		try{
			if(informacoesArg[11].equals(informacoesArg[12])){
				Boolean senhaConfirmada = false;
				String url = "jdbc:mysql://localhost/pizzatech";
				Class.forName("com.mysql.jdbc.Driver");
				Connection conexao = DriverManager.getConnection(url, usuario, senhaDoBancoDeDados);
				//String[] nomeDoLabel = {"CPF:", "RG:", "Nome:", "Telefone fixo:", "Celular:", "Endereço:", "Email:", 
				//"Data de nascimento:", "Sexo:", "Função:", "Login:", "Senha:", "Confirmar Senha:"};
				PreparedStatement pesquisa = conexao.prepareStatement("INSERT INTO `pizzatech`.`funcionarios` (`cpf`, `rg`, `nome`, `telefonefixo`, `celular`, `endereco`, `email`, `datanascimento`, `sexo`, `funcao`, `dataadmissao`, `login`, `senha`) VALUES ('" + informacoesArg[0] + "', '" + informacoesArg[1] + "', '" + informacoesArg[2] + "', '" + informacoesArg[3] + "', '" + informacoesArg[4] + "', '" + informacoesArg[5] + "', '" + informacoesArg[6] + "', '" + informacoesArg[7] + "', '" + informacoesArg[8] + "', '" + informacoesArg[9] + "', '" + new SimpleDateFormat("dd/MM/yyyy").format(new Date()) + "', '" + informacoesArg[10] + "', '" + informacoesArg[11] + "');");
				pesquisa.execute();
				pesquisa.close();
				conexao.close();
			}
			else{
				JOptionPane.showMessageDialog(null, "A senha não esta igual nos dois campos.");
			}
			
		}catch(Exception e){
			System.out.println("Erro em:\n    Dao.salvarCadastroDeFuncionario(String[] informacoesArg)");
			e.printStackTrace();
		}
	}
	public static void salvarCadastroDeCliente(String[] informacoesArg){
		System.out.println("Salvando informacoes dos clientes");
	}
	public static void salvarCadastroDeProduto(String[] informacoesArg){
		System.out.println("Salvando informacoes dos produto");
	}
}
