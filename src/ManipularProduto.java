import java.util.LinkedList;
import java.util.Scanner;

public class ManipularProduto {
	
	private LinkedList<Produto> produtos = new LinkedList<Produto>();
	private Scanner i = new Scanner(System.in);
	private Scanner s = new Scanner(System.in);
	private Produto produto;
	private String alteracao;

	public void cadastrarProduto(int opcao) {
		produto = cadastroProduto(opcao);
		try {
			produtos.add(produto);
		} catch (Exception e) {
			System.out.println(e.getCause());
		}
		int posicao = produtos.indexOf(produto);
		Produto prod = (Produto) produtos.get(posicao);
		System.out.println(prod.getNome() + ", cadastrado com sucesso!");
		System.out.println("==========================================================================================================");
	}
	
	public void consultarProduto() {
		System.out.println("Qual produto deseja consultar?");
		int inf = getProdutos();
		if (inf == 1) {
			int index = i.nextInt();
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
			try {
				int index = i.nextInt();
				if(produtos.size() >= index) {
					produto = (Produto) produtos.get(index - 1);
					produto = alterarTipo(produto);
					System.out.println("Alterações feitas:");
					System.out.println(produto.descritivo());
				} else {
					System.out.println("Opção inválida!");
					System.out.println("==========================================================================================================");			
				}
			} catch (Exception e) {
				System.out.println("Esperado um valor numérico.");
			}
		}		
	}
	
	public void removerProduto() {
		System.out.println("Qual produto deseja alterar?");
		int inf = getProdutos();
		if (inf == 1) {
			int index = i.nextInt();
			if(produtos.size() >= index) {
				try {
					produtos.remove(index - 1);
				} catch (Exception e) {
					System.out.println(e.getCause());
				}
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
				produto = (Produto) produtos.get(i);
				System.out.println(produto.descritivo());
			}

			System.out.println("==========================================================================================================");
		}
	}
	
	private int getProdutos() {
		if(produtos.isEmpty()) {
			System.out.println("Não existe produtos cadastrados");
			System.out.println("==========================================================================================================");
			return 0;
		} else {
			for ( int i = 0; i < produtos.size(); i++ ) {
				produto = (Produto) produtos.get(i);
				System.out.println((i + 1) + " - " + produto.getNome());
			}
			return 1;
		}
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
		
			Cd cd = new Cd(produtos.size() + 1, nomeCd, convertFloat(precoCd), cantor, produtor);
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
			
			Dvd dvd = new Dvd(produtos.size() + 1, nomeDvd, convertFloat(precoDvd), diretor, duracao);
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
			
			Livro livro = new Livro(produtos.size() + 1, nomeLivro, convertFloat(precoLivro), autor, editor);
			return livro;
		}	
		return null;
	}
	
	@SuppressWarnings("finally")
	private float convertFloat(String str) {
		float preco = 0;
		try {
			preco = Float.parseFloat(str);
		} catch (NumberFormatException e) {
			System.out.println("Esperado um decimal, valor foi zerado.");
		} finally {
			return preco;
		}
	}
	private Produto alterarTipo(Produto produto) {
		
		if (produto.getClass().equals(Cd.class)) {
			Cd cd = (Cd) produto;
			cd = (Cd) alteracaoBasica(cd);
			
			System.out.println("Cantor: " + cd.getCantor());
			alteracao = s.nextLine();
			if (!(alteracao.trim().equalsIgnoreCase("n"))) {
				cd.setCantor(alteracao);
			}
			System.out.println("Produtor: " + cd.getProdutor());
			alteracao = s.nextLine();
			if (!(alteracao.trim().equalsIgnoreCase("n"))) {
				cd.setProdutor(alteracao);
			}
			produto = cd;
			
		} else if (produto.getClass().equals(Dvd.class)) {
			Dvd dvd = (Dvd) produto;
			dvd = (Dvd) alteracaoBasica(dvd);
			System.out.println("Diretor: " + dvd.getDiretor());
			alteracao = s.nextLine();
			if (!(alteracao.trim().equalsIgnoreCase("n"))) {
				dvd.setDiretor(alteracao);
			}
			System.out.println("Duração: " + dvd.getDuracao());
			alteracao = s.nextLine();
			if (!(alteracao.trim().equalsIgnoreCase("n"))) {
				dvd.setDuracao(alteracao);
			}
			produto = dvd;
			
		} else if (produto.getClass().equals(Livro.class)) {
			Livro livro = (Livro) produto;
			livro = (Livro) alteracaoBasica(livro);
			System.out.println("Autor: " + livro.getAutor());
			alteracao = s.nextLine();
			if (!(alteracao.trim().equalsIgnoreCase("n"))) {
				livro.setAutor(alteracao);
			}
			System.out.println("Editora: " + livro.getEditora());
			alteracao = s.nextLine();
			if (!(alteracao.trim().equalsIgnoreCase("n"))) {
				livro.setEditora(alteracao);
			}
			produto = livro;

		}
		return produto;
	}
	
	private Produto alteracaoBasica(Produto produto) {
		System.out.println("Indique as modificações: 'n' para não alterar ou nova informação para alteração.");
		System.out.println("Nome: " + produto.getNome());
		alteracao = s.nextLine();			
		if (!(alteracao.trim().equalsIgnoreCase("n"))) {
			produto.setNome(alteracao);
		}
		System.out.println("Preço: " + produto.getPreco());
		alteracao = s.nextLine();
		if (!(alteracao.trim().equalsIgnoreCase("n"))) {
			try {
				produto.setPreco(Float.parseFloat(alteracao));
			} catch (NumberFormatException e) {
				System.out.println("Esperado um decimal, valor não foi alterado.");
			}
		}		
		return produto;
	}

}
