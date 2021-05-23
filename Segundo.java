package testes;

import java.util.Scanner;

public class Segundo{
	
	private static String[] nomes;
	private static int[] idades;
	private static float[] salarios;
	private static float[] bonus;
	private static float[] descontos;
	
	private static int index;
	private static final int QTDE = 5;
			
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);//definir um vetor de string, ou seja nomes para o projeto
		
		nomes = new String[QTDE];
		idades = new int[QTDE];
		salarios = new float[QTDE];
		bonus = new float [QTDE];
		descontos = new float [QTDE];
		
		String opcao = null;
		
		do {
			System.out.println("[1]Cadastrar");
			System.out.println("[2]Consultar um");
			System.out.println("[3]Consultar todos");
			System.out.println("[4]Sair");
			
			System.out.println("Informe a op��o desejada: ");
			opcao = in.next();
			
			switch (opcao) {
			case"1":
				if(index < QTDE) {
					System.out.println("Informe seu nome: ");
					nomes[index] = in.next();
						
					System.out.println("Informe seu idade: ");	
					idades[index] = in.nextInt();
						
					System.out.println( "Informe seu salario: ");
					salarios[index] = in.nextFloat();
					
					System.out.println( "Informe seu bonus: ");
					bonus[index] = in.nextFloat();
						
					System.out.println( "Informe seu desconto: ");
					descontos[index] = in.nextFloat();
						
					System.out.println("Funcion�rio cadastrado com sucesso: " + index);
					imprimir(index);
						
					index++;
				} else {
					System.out.println("N�o existe mais vaga para cadastramento");
				}
				break;
				
			case"2":
				System.out.println("Informe a posi��o: ");
				int pos = in.nextInt();
				
				if(pos >= 0 && pos < index) {
					imprimir(pos);
				} else {
					System.out.println("Funcion�rio inexistente");
				}
				break;
				
			case"3":
				imprimir();
				
				break;
				
			case"4":
				System.out.println("Finalizou!!!");
				break;
				
			default:
				System.out.println("Op��o inv�lida");
				break;
			}
			
		} while (!opcao.equals("4"));
		
		exibirRelatorio();
		
		in.close();
	}		
		
	private static float calcularMediaSalarial() {
		
		float soma = 0;
		
		for(int i = 0; i < index; i++ ) {
			soma =  soma + calcularSalario(i);
		}
		
		return soma / index;
	}
	private static float calcularSalario(int idx) {
		return salarios[idx] + bonus[idx] - descontos [idx];
	}	
	private static void exibirRelatorio() {
		int qtde = index;
		
		System.out.println("Relat�rio");
		System.out.println("Quantidade de Funcion�rios: " + qtde);
		System.out.println("M�dia salarial dos funcion�rios: " + calcularMediaSalarial());
	}	
	private static void imprimir() {
		System.out.println("Listagem de inscritos");
		for(int i = 0; i < index; i++) {
			imprimir(i);
		}
	}
	private static void imprimir(int posicao){
		
		float salarioLiquido = calcularSalario(posicao); 
		
		System.out.printf( " %d - %s - %d - R$%.2f - R$%.2f - R$%.2f (%s)\n",
			posicao + 1,
			nomes[posicao],
			idades[posicao],
			salarios[posicao],
			bonus[posicao],
			descontos[posicao],
			salarioLiquido,
			getSituacao(salarioLiquido)
		);
	}
	private static String getSituacao(float sl) {
		return sl > 100000 ? "rico" :"pobre";
	}
}