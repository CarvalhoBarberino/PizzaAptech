package pizzatech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.objects.NativeError;

public class Dao {
	public static boolean conferirSenha(String nome, String senha){
		System.out.println(nome + senha);
		return true;
	}
	public static void salvarCadastroDeFuncionario(String[] informacoesArg){
		if(informacoesArg[11].equals(informacoesArg[12])){
			informacoesArg[11] = informacoesArg[10];
			System.out.println("salvarCadastroDeFuncionario(String[] informacoesArg");
			Date atual = new Date();
			DateFormat dataadmissao = new SimpleDateFormat("DD/mm/yy");
			informacoesArg[10] = dataadmissao.format(atual);
			try{
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception e){
				e.printStackTrace();System.exit(1);
			}


			String esquema = "pizzatech";
			String usuario = "root";
			String senha = "bancodedados";
			String local = "jdbc:Mysql://localhost/" + esquema;

			Connection conexao = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try{
				conexao = DriverManager.getConnection(local, usuario, senha);
			}catch(Exception e){System.out.println("NÃO Conectou com o banco de dados");e.printStackTrace();System.exit(1);}		
			System.out.println("Conectou com o banco de dados");

			//3 Criando query
			String query = "INSERT INTO `pizzatech`.`funcionarios` (`cpf`, `rg`, `nome`, `telefonefixo`, `celular`, `endereco`, `email`, `datanascimento`, `sexo`, `funcao`, `dataadmissao`, `login`, `senha`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			//4 configurando Query
			try{
				stmt = conexao.prepareStatement(query);
			}catch(Exception e){e.printStackTrace();System.exit(1);}
			try{
				stmt.setInt(1, Integer.valueOf(informacoesArg[0])); //cpf
				stmt.setInt(2, Integer.valueOf(informacoesArg[1])); //rg
				stmt.setString(3, informacoesArg[2]); //nome
				stmt.setInt(4, Integer.valueOf(informacoesArg[3])); //telefonefixo
				stmt.setInt(5, Integer.valueOf(informacoesArg[4])); //celular
				stmt.setString(6, informacoesArg[5]); //endereco
				stmt.setString(7, informacoesArg[6]); //email
				stmt.setString(8, informacoesArg[7]); //datadenascimento
				stmt.setString(9, informacoesArg[8]); //sexo
				stmt.setString(10, informacoesArg[9]); //funcao
				stmt.setString(11, informacoesArg[10]); //dataadmissao
				stmt.setString(12, informacoesArg[11]); //login
				stmt.setString(13, informacoesArg[12]); //senha
			}catch(Exception e){System.out.println("stmt.set...(int, ...)");e.printStackTrace();System.exit(1);}


			try {
				//5 Executar a query
				stmt.execute();
			}catch(Exception e){System.out.println("NÃO Cadastrou o aluno com sucesso");e.printStackTrace();System.exit(1);}
			System.out.println("Cadastrou o aluno com sucesso");

			try {
				//6 Fechar o banco de dados
				stmt.close();
			}catch(Exception e){System.out.println("NÃO Fechou o banco de dados");e.printStackTrace();System.exit(1);}
			try {
				conexao.close();
			}catch(Exception e){System.out.println("NÃO Fechou a conexção com o banco de dados");e.printStackTrace();System.exit(1);}
			System.out.println("Fechou o banco de dados");
		}
		else{
			//O que fazer se as senhas não conferirem
		}
	}
	public static void salvarCadastroDeCliente(String[] informacoesArg){
		System.out.println("Salvando informacoes dos clientes");
	}
	public static void salvarCadastroDeProduto(String[] informacoesArg){
		System.out.println("Salvando informacoes dos produto");
	}
	public static void salvarCadastroDePedido(String[] informacoesArg){
		System.out.println("Salvando informacoes dos pedidos");
	}
}
