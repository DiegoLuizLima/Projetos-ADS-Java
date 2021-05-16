public class Primeiro {
	
	//metodo: visibilidade, tipo de retorno, nome, parâmetro
	//tipo-retorno: texto(string), inteiro(integer), real(float),lógico(boolean,classes, void
	private static String[] parametros;
	private static String nome;
	private static String sobrenome;
	private static int qtdMeses;
	private static int idade;
	private static float salario;
	private static boolean ehJava;
	
	
	private static void tratarParametros(){
		nome =  parametros[0];
		sobrenome =  parametros[1];
		idade = Integer.valueOf( parametros[2]);
		salario = Float.valueOf( parametros[3]);
		ehJava = "S".equalsIgnoreCase( parametros[4]) ? true : false;
		qtdMeses = Integer.valueOf( parametros[5]);
	}
	
	private static boolean validar(int qtd){
		return qtd == 6;
	}
	
	public static void main(String[] args){
		
		if(validar(args.length)){
			parametros = args;
			
			tratarParametros();
			
			float salarioTotal = salario * qtdMeses;
			String nivel = idade < 50 ? "iniciante" : "veterano";
			String situacao = salarioTotal > 1000 ? "estavel" : "instavel";
			int anoNascimento = 2021 - idade;
			
			
			System.out.println("Nome: " + nome);
			System.out.println("Sobrenome: " + sobrenome);
			System.out.println("Idade: " + idade);
			System.out.println("Nascimento: " + anoNascimento);
			System.out.println("Salario: " + salario);
			System.out.println("ehJava: " + ehJava);
			System.out.println("Salario Total: " + salarioTotal);
			System.out.println("Nivel: " + nivel);
			System.out.println("Situacao: " + situacao);
		} else {
			System.out.println("Problemas na quantidade de parametros.");
		}
	}

}