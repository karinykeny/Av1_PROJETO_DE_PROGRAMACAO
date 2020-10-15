
public class Dvd extends Produto {
	
	private String diretor;
	private String duracao;

	public Dvd(int codigo, String nome, float preco, String diretor, String duracao) {
		super(codigo, nome, preco);
		this.diretor = diretor;
		this.duracao = duracao;
	}

	@Override
	String descritivo() {
		return "DVD -> C�digo: " + getCodigo() +
			    ", Nome: " + getNome() +
			    ", Pre�o: " + getPreco() +
			    ", Desconto a vista: " + getDeconto_a_vista() +
			    ", Diretor: " + this.diretor +
			    " e Dura��o: " + this.duracao;
	}

	@Override
	float precoAVista() {
		float desconto = (getPreco() * getDeconto_a_vista());
		if (desconto > (float) 5.0) {
			return (getPreco() - desconto) + (float) 1.0;
		}
		return getPreco() - desconto;
	}

}
