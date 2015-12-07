package testes.adapter;

public class SMS {
	private String origem;
	private String destino;
	private String texto;
	
	public SMS(String origem, String destino, String texto) {
		setOrigem(origem);
		setDestino(destino);
		setTexto(texto);
	}

	public String getDestino() {
		return destino;
	}

	public String getOrigem() {
		return origem;
	}

	public String getTexto() {
		return texto;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
