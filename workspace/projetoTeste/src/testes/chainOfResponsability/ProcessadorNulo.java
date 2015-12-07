package testes.chainOfResponsability;

public class ProcessadorNulo extends Processador{

	
	public ProcessadorNulo() {
		super();
	}
	
	@Override
	protected byte[] processar(byte[] bytes) {
		return bytes;
	}
	

}
