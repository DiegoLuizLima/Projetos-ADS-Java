package testes;

import java.util.Scanner;

public class appAcademy {

	private static String[] nomes; // o que significa static?
	private static Float[] notasAv1; // Por que esses tipos são com letras maiúsculas
	private static Float[] notasAv2;
	
	private static int index;
	private static final int QTDE = 100; // O que significa final?
	
	public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		
		nomes = new String[QTDE];
		notasAv1 = new Float[QTDE];
		notasAv2 = new Float[QTDE];
		
		String opcao = null; // por que essa variável eu não preciso colocar como privada?
		
		do {
			System.out.println("[1] Registrar as notas de um novo aluno.");
			System.out.println("[2] Consultar boletim de um aluno.");
			System.out.println("[3] Consultar notas da turma.");
			System.out.println("[4] Sair.");
			
			System.out.println("Informe a opção desejada: ");
			opcao = in.next();
			
			//Como eu faço para comentar blocos de texto?
			
			switch (opcao) { //switch é considerada uma estrutura condicional?
			case"1": 
				if(index < QTDE) {
					System.out.println("Informe seu nome: "); // Como eu faço para voltar um Tab, só consigo avançar
					nomes[index] = in.next(); 
								
					System.out.println("Informe a primeira nota: ");	
					notasAv1[index] = in.nextFloat();
						
					System.out.println( "Informe a segunda nota: ");
					notasAv2[index] = in.nextFloat();
								
					index++;
					} else {
					System.out.println("Não existe mais vaga para cadastramento");
					}
					break;
				
			case"2":
					System.out.println("Informe a posição: ");
					int pos = in.nextInt();
					
					if(pos >= 0 && pos < index) {
						imprimir(pos); // 
					} else {
						System.out.println("Aluno inexistente");
					}
					break;
			case"3":
				if(index != 0 ) {
					imprimir();
				} else {
					System.out.println("Não existe boletim Cadastrada");
				}
					break;
				
			case"4":
					System.out.println("Você encerrou sua pesquisa");
					break;
				
			default:
					System.out.println("Opção inválida");
					break;
			}	
			
		} while (!opcao.equals("4")); // o que significa esse !
		
		in.close();// por que tenho que fechar o Scanner
	}
	
		private static void imprimir() {
			System.out.println("Listagem de alunos");
			for(int i = 0; i < index; i++) {
				imprimir(i);
			}
		}
		private static void imprimir(int posicao){
			
			float media = calcularMedia(posicao); 
				
			System.out.printf("[%d] - %s - %.2f - %.2f - %.2f - %s\n",
				posicao + 1,
				nomes[posicao],
				notasAv1[posicao],
				notasAv2[posicao],
				media,
				situacaoDoAluno(media));
			}
			
		private static float calcularMedia(int idx) {
			return (notasAv1[idx] + notasAv2[idx]) / 2;
		}
		private static String situacaoDoAluno(float medAluno) {
			if (medAluno < 4) {
				return "Reprovado";
			} else if (medAluno >= 7) {	
				return "Aprovado";
			} else {	
				return "Exame";
			}
					
		}
}
