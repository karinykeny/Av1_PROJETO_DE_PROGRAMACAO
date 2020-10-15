import java.util.LinkedList;
import java.util.Scanner;

public class ManipularProduto {
	
	private LinkedList produtos = new LinkedList<Produto>();

	public void cadastrarProduto(int opcao) {
		Produto produto = cadastroProduto(opcao);
		produtos.add(produto);
		int posicao = produtos.indexOf(produto);
		Produto prod = (Produto) produtos.get(posicao);
		System.out.println(prod.getNome() + ", cadastrado com sucesso!");
	}
	
	public void consultarProduto(int index) {
		if((boolean) produtos.get(index)) {
			Produto prod = (Produto) produtos.get(index);
			System.out.println(prod.descritivo());
		} else {
			System.out.println("Opção inválida!");
		}
	}
	
	public String alterarProduto(int index) {
		return "";
	}
	
	public void removerProduto(Produto produto) {
		try {
			produtos.remove(produto);
			System.out.println("Produto removido com sucesso!");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	public void getProdutos() {
		for ( int i = 0; i < produtos.size(); i++ ) {
			Produto temp = (Produto) produtos.get(i);
			System.out.println((i + 1)+ " - " + temp.getNome());
		}
		if(produtos.isEmpty()) {
			System.out.println("Não existe produtos cadastrados");
		}
	}
	
	private Produto cadastroProduto(int opcao) {
		
		Scanner s = new Scanner(System.in);
		
		switch (opcao) {
		case 1:
			System.out.println("Informe o nome do CD: ");
			String nomeCd = s.nextLine();	
			System.out.println("Informe o preço do CD: ");
			float precoCd = s.nextFloat();
			System.out.println("Informe o cantor: ");
			String cantor = s.nextLine();
			System.out.println("Informe o produtor: ");
			String produtor = s.nextLine();
		
			Cd cd = new Cd(produtos.size() + 1, nomeCd, precoCd, cantor, produtor);
			return cd;
		case 2:
			System.out.println("Informe o nome do CD: ");
			String nomeDvd = s.nextLine();	
			System.out.println("Informe o preço do CD: ");
			float precoDvd = s.nextFloat();
			String diretor = s.nextLine();
			System.out.println("Informe o produtor: ");
			String duracao = s.nextLine();
			
			Dvd dvd = new Dvd(produtos.size() + 1, nomeDvd, precoDvd, diretor, duracao);
			return dvd;
		case 3:
			System.out.println("Informe o nome do CD: ");
			String nomeLivro = s.nextLine();	
			System.out.println("Informe o preço do CD: ");
			float precoLivro = s.nextFloat();
			String autor = s.nextLine();
			System.out.println("Informe o produtor: ");
			String editora = s.nextLine();
			
			Livro livro = new Livro(produtos.size() + 1, nomeLivro, precoLivro, autor, editora);
			return livro;
		}
		
		return null;
	}

}
