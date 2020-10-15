
public class Livro extends Produto {
	
	private String autor;
	private String editora;

	public Livro(int codigo, String nome, float preco, String autor, String editora) {
		super(codigo, nome, preco);
		this.autor = autor;
		this.editora = editora;
	}

	@Override
	String descritivo() {
		return "Livro -> Código: " + getCodigo() +
			    ", Nome: " + getNome() +
			    ", Preço: " + getPreco() +
			    ", Desconto a vista: " + getDeconto_a_vista() +
			    ", Autor: " + this.autor +
			    " e Editora: " + this.editora;
	}

	@Override
	float precoAVista() {
		float desconto = (getPreco() * getDeconto_a_vista());
		if (desconto > (float) 7.0) {
			return (getPreco() - desconto) + (float) 1.5;
		}
		return getPreco() - desconto;
	}

}
