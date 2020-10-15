import java.util.Scanner;

public class PrincipalClasse {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int opcao = 1;
		int produto = 1;
		ManipularProduto mp = new ManipularProduto();
//		Cd cd = new Cd(001, "CÁSSIA ELLER - ACÚSTICO", (float) 20.0, "Cássia Eller", "Nando Reis e Luiz Brasil");
//		Dvd dvd = new Dvd(002, "Reta Lee Ovelha Negra",(float) 30.50, "Biônica Filmes", "08:16");
//		Livro livro = new Livro(003, "O Código Da Vinci", (float) 34.90, "Dan Brown", "Editora Arqueiro");
//		
//		LinkedList produtos = new LinkedList<Produto>();
//		produtos.add(cd);
//		produtos.add(dvd);
//		produtos.add(livro);
//		
//		System.out.println("================================ RELATÓRIO GERAL ========================================================");
//		
//		for ( int i = 0; i < produtos.size(); i++ ) {
//			Produto temp = (Produto) produtos.get(i);
//			System.out.println(temp.descritivo());
//		}
//
//		System.out.println("==========================================================================================================");
		
		
		
		while (opcao > 0 && opcao < 7) {	
			System.out.println("Escolha uma opção para iniciar:");
			System.out.println("1 - Cadastrar produto;");
			System.out.println("2 - Consultar produto;");
			System.out.println("3 - Alterar produto;");
			System.out.println("4 - Excluir produto;");
			System.out.println("5 - Relatório geral;");
			System.out.println("6 - Sair.");
			
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
					if (produto > 0 && produto < 5) {
						mp.cadastrarProduto(produto);
						System.out.println("Deseja cadastrar um novo produto?");
					} else {
						System.out.println("Opção inválida, tente novamente.");
						produto = s.nextInt();
					}
				}
				break;
			case 2:
				System.out.println("Qual produto deseja consultar?");
				mp.getProdutos();
				produto = s.nextInt();
				mp.consultarProduto(produto);		
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				opcao = 7;
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
		
		mp.getProdutos();


	}

}
