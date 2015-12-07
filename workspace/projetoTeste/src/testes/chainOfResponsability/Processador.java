package testes.chainOfResponsability;

public abstract class Processador {

	private Processador proximoProcessador;
	
	public Processador(Processador proximoProcessador) {
		this.proximoProcessador = proximoProcessador;
	}
	
	public Processador() {
	}
	
	public byte[] processarCadeia(byte[] bytes) {
		bytes = processar(bytes);
		
		if (this.proximoProcessador != null) {
			return proximoProcessador.processarCadeia(bytes);
		}else {
			return bytes;
		}
		
	}
	
	protected abstract byte[] processar(byte[] bytes);
	
	
}
