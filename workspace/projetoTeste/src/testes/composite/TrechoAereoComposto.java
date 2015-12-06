package testes.composite;

public class TrechoAereoComposto implements TrechoAereo {

	private TrechoAereo primeiro;
	private TrechoAereo segundo;
	private Double taxaConexao;

	public TrechoAereoComposto(TrechoAereo primeiro, TrechoAereo segundo, Double taxaConexao) {
		setPrimeiro(primeiro);
		setSegundo(segundo);
		setTaxaConexao(taxaConexao);
	}

	public void setPrimeiro(TrechoAereo primeiro) {
		this.primeiro = primeiro;
	}

	public void setSegundo(TrechoAereo segundo) {
		this.segundo = segundo;
	}

	public void setTaxaConexao(Double taxaConexao) {
		this.taxaConexao = taxaConexao;
	}

	@Override
	public String getOrigem() {
		return this.primeiro.getOrigem();
	}

	@Override
	public String getDestino() {
		return this.segundo.getDestino();
	}

	@Override
	public Double getPreco() {
		return this.taxaConexao + this.primeiro.getPreco() + this.segundo.getPreco();
	}

}
