package testes.aspecto;

public class Pessoa {
	private String nome;
	private Integer idade;
	
	public Pessoa(@NaoNulo String nome, @NaoNulo @NaoNegativo Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(@NaoNulo String nome) {
		this.nome = nome;
	}
	
	public void setIdade(@NaoNulo @NaoNegativo Integer idade) {
		this.idade = idade;
	}
	
	public Integer getIdade() {
		return this.idade;
	}
	
}
