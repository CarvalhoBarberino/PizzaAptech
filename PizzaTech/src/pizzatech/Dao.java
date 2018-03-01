package pizzatech;

public class Dao {
	public static boolean conferirSenha(String nome, String senha){
		System.out.println(nome + senha);
		return true;
	}
	public static void salvarCadastroDeFuncionario(String[] informacoesArg){
		System.out.println("Salvando informacoes dos funcionarios");
	}
	public static void salvarCadastroDeCliente(String[] informacoesArg){
		System.out.println("Salvando informacoes dos clientes");
	}
	public static void salvarCadastroDeProduto(String[] informacoesArg){
		System.out.println("Salvando informacoes dos produto");
	}
}
