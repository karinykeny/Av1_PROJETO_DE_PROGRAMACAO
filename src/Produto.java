
public class Produto {
	
	private int codigo;
	private String nome;
	private float preco;
	private float deconto_a_vista;
	
	public Produto(int codigo, String nome, float preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.deconto_a_vista = (float) 0.3;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public float getPreco() {
		return preco;
	}

	public float getDeconto_a_vista() {
		return deconto_a_vista;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void setDeconto_a_vista(float deconto_a_vista) {
		this.deconto_a_vista = deconto_a_vista;
	}

	float precoAVista() {
		return 0;
	}
	
	String descritivo() {
		return null;
	}
	
}
