package testes.doubleDipatch;

public abstract class Produto {
	private String nome;
	private Double preco;

	public Produto(String nome, Double preco) {
		setNome(nome);
		setPreco(preco);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public void addCaracteristicas(Carrinho carrinho) {
		carrinho.adicionaCaracteristicas(getNome(), addCaracteristicas());
	}
	
	protected abstract String addCaracteristicas();
	
	
}
