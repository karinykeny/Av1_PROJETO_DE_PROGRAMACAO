import java.util.LinkedList;
import java.util.Scanner;

public class ManipularProduto {
	
	private LinkedList produtos = new LinkedList<Produto>();
	private Scanner s = new Scanner(System.in);

	public void cadastrarProduto(int opcao) {
		Produto produto = cadastroProduto(opcao);
		produtos.add(produto);
		int posicao = produtos.indexOf(produto);
		Produto prod = (Produto) produtos.get(posicao);
		System.out.println(prod.getNome() + ", cadastrado com sucesso!");
		System.out.println("==========================================================================================================");
	}
	
	public void consultarProduto() {
		System.out.println("Qual produto deseja consultar?");
		int inf = getProdutos();
		if (inf == 1) {
			int index = s.nextInt();
			if (produtos.size() >= index) {
				Produto prod = (Produto) produtos.get(index - 1);
				System.out.println(prod.descritivo());
				System.out.println("==========================================================================================================");
			} else {
				System.out.println("Opção inválida!");
				System.out.println("==========================================================================================================");
				
			}
		}
		
	}
	
	public void alterarProduto() {
		System.out.println("Qual produto deseja alterar?");
		int inf = getProdutos();
		if (inf == 1) {
			int index = s.nextInt();
			if(produtos.size() >= index) {
				Produto prod = (Produto) produtos.get(index - 1);
				int opcao = tipoProduto(prod);
				produtos.remove(index - 1);
				cadastrarProduto(opcao);
			} else {
				System.out.println("Opção inválida!");
				System.out.println("==========================================================================================================");			
			}
		}
		
	}
	
	public void removerProduto() {
		System.out.println("Qual produto deseja alterar?");
		int inf = getProdutos();
		if (inf == 1) {
			int index = s.nextInt();
			if(produtos.size() >= index) {
				produtos.remove(index - 1);
				System.out.println("Produto excluido com sucesso!");
				System.out.println("==========================================================================================================");
			} else {
				System.out.println("Opção inválida!");
				System.out.println("==========================================================================================================");
				
			}
		}
		
	}
	
	public void getRelatorio() {
		if (produtos.isEmpty()) {
			System.out.println("Não existe produto cadastrado.");
			System.out.println("==========================================================================================================");
		} else {
			System.out.println("================================= RELATÓRIO GERAL ========================================================");
			
			for ( int i = 0; i < produtos.size(); i++ ) {
				Produto temp = (Produto) produtos.get(i);
				System.out.println(temp.descritivo());
			}

			System.out.println("==========================================================================================================");
		}
	}
	
	public int getProdutos() {
		for ( int i = 0; i < produtos.size(); i++ ) {
			Produto temp = (Produto) produtos.get(i);
			System.out.println((i + 1)+ " - " + temp.getNome());
			return 1;
		}
		if(produtos.isEmpty()) {
			System.out.println("Não existe produtos cadastrados");
			System.out.println("==========================================================================================================");
			return 0;
		}
		return 0;
	}
	
	private Produto cadastroProduto(int opcao) {
		
		switch (opcao) {
		case 1:
			System.out.println("Informe o nome do CD: ");
			String nomeCd = s.nextLine();	
			System.out.println("Informe o preço do CD: ");
			String precoCd = s.nextLine();
			System.out.println("Informe o cantor: ");
			String cantor = s.nextLine();
			System.out.println("Informe o produtor: ");
			String produtor = s.nextLine();
		
			Cd cd = new Cd(produtos.size() + 1, nomeCd, Float.parseFloat(precoCd), cantor, produtor);
			return cd;
		case 2:
			System.out.println("Informe o nome do DVD: ");
			String nomeDvd = s.nextLine();	
			System.out.println("Informe o preço do DVD: ");
			String precoDvd = s.nextLine();
			System.out.println("Informe o diretor: ");
			String diretor = s.nextLine();
			System.out.println("Informe a duração: ");
			String duracao = s.nextLine();
			
			Dvd dvd = new Dvd(produtos.size() + 1, nomeDvd, Float.parseFloat(precoDvd), diretor, duracao);
			return dvd;
		case 3:
			System.out.println("Informe o nome do Livro: ");
			String nomeLivro = s.nextLine();	
			System.out.println("Informe o preço do livro: ");
			String precoLivro = s.nextLine();
			System.out.println("Informe o nome do autor: ");
			String autor = s.nextLine();
			System.out.println("Informe o diretor: ");
			String editor = s.nextLine();
			
			Livro livro = new Livro(produtos.size() + 1, nomeLivro, Float.parseFloat(precoLivro), autor, editor);
			return livro;
		}
		
		return null;
	}
	
	private int tipoProduto(Produto produto) {
		if (produto.getClass().equals(Cd.class)) {
			return 1;
		} else if (produto.getClass().equals(Dvd.class)) {
			return 2;
		} else if (produto.getClass().equals(Livro.class)) {
			return 3;
		}
		return 0;
	}

}
