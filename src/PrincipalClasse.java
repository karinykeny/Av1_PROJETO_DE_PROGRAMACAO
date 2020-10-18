import java.util.Scanner;

public class PrincipalClasse {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int opcao = 1;
		int produto = 1;
		ManipularProduto mp = new ManipularProduto();	
		
		while (opcao > 0 && opcao < 7) {	
			System.out.println("Escolha uma opção para iniciar:");
			System.out.println("1 - Cadastrar produto;");
			System.out.println("2 - Consultar produto;");
			System.out.println("3 - Alterar produto;");
			System.out.println("4 - Excluir produto;");
			System.out.println("5 - Relatório geral;");
			System.out.println("6 - Sair.");
			
			try {
				opcao = s.nextInt();
				switch (opcao) {
				case 1:
					System.out.println("Qual produto gostaria de cadastrar?");
					while (produto != 4) {
						System.out.println("1 - CD;");
						System.out.println("2 - DVD;");
						System.out.println("3 - Livro;");
						System.out.println("4 - Retornar ao menu anterior.");
						
						produto = s.nextInt();
						if (produto != 4 ) {
							if (produto > 0 && produto < 5) {
								mp.cadastrarProduto(produto);
								System.out.println("Deseja cadastrar um novo produto?");
							} else {
								System.out.println("Opção inválida, tente novamente.");
							}
						}
					}
					break;
				case 2:
					mp.consultarProduto();		
					break;
				case 3:
					mp.alterarProduto();
					break;
				case 4:
					mp.removerProduto();
					break;
				case 5:
					mp.getRelatorio();
					break;
				case 6:
					opcao = 7;
					break;
				default:
					System.out.println("Opção inválida!");
					break;
				}
			} catch (Exception e) {
				System.out.println("Erro na entrada de dados.");
			}
		}
	}

}
