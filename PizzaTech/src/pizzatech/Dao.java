package pizzatech;

public class Dao {
	public static boolean conferirSenha(String nome, String senha){
		System.out.println(nome + senha);
		return true;
	}
	public static void salvarCadastroDeFuncionario(String[] informacoesDosFuncionariosArg){
		System.out.println("Salvando informacoes dos funcionarios");
	}
}
