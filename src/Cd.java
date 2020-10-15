
public class Cd extends Produto {
	
	private String cantor;
	private String produtor;

	public Cd(int codigo, String nome, float preco, String cantor, String produtor) {
		super(codigo, nome, preco);
		this.cantor = cantor;
		this.produtor = produtor;
	}

	@Override
	String descritivo() {
		return "CD -> Código: " + getCodigo() +
				    ", Nome: " + getNome() +
				    ", Preço: " + getPreco() +
				    ", Desconto a vista: " + getDeconto_a_vista() +
				    ", Cantor: " + this.cantor +
				    " e Produtor: " + this.produtor;
	}

	@Override
	float precoAVista() {
		float preco_a_vista = getPreco() - (getPreco() * getDeconto_a_vista());
		return preco_a_vista;
	}
	
	

}
