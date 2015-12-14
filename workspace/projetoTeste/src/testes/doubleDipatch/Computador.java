package testes.doubleDipatch;

public class Computador extends Produto {

	private String processador;

	public Computador(String nome, String processador , Double preco) {
		super(nome, preco);
		setProcessador(processador);
	}

	@Override
	protected String addCaracteristicas() {
		return "processador: " + getProcessador() + " por: " + getPreco();
	}

	public String getProcessador() {
		return this.processador;
	}
	
	public void setProcessador(String processador) {
		this.processador = processador;
	}

}
