package testes.strategy;

public class Loja {

	private Double peso;
	private Double distancia;
	
	public Loja() {
		this.peso = 0d;
		this.distancia = 0d;
	}

	public void cadastrarItem(Double peso, Double distancia) {
		this.peso = peso;
		this.distancia = distancia;
	}

	public Double simularFrete(String tipoFrete) {
		return TipoFrete.valueOf(tipoFrete).calcularFrete(peso, distancia);
	}

}
