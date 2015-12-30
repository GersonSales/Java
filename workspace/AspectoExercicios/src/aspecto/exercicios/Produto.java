package aspecto.exercicios;

public class Produto {
	private static int id = 0;
	private Double preco;
	private String nome;
	
	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
		id++;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public static int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return getNome() + "(R$ " + getPreco() + ")";
	}

	public String getNome() {
		return this.nome;
	}
	
	
	
	
	

}
