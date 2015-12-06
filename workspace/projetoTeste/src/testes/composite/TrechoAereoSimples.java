package testes.composite;

public class TrechoAereoSimples implements TrechoAereo {

	private String origem;
	private String destino;
	private Double preco;

	public TrechoAereoSimples(String origem, String destino, Double preco) {
		setOrigem(origem);
		setDestino(destino);
		setPreco(preco);
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String getOrigem() {
		return this.origem;
	}

	@Override
	public String getDestino() {
		return this.destino;
	}

	@Override
	public Double getPreco() {
		return this.preco;
	}

}
