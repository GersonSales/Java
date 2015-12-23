package testes.aspecto;

public class Pessoa {
	private String nome;
	
	public Pessoa(@NaoNulo String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(@NaoNulo String nome) {
		this.nome = nome;
	}
	
}
