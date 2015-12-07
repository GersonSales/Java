package testes.chainOfResponsability;

public class ProcessaCriptografado extends Processador {

	public ProcessaCriptografado(Processador proximoProcessador) {
		super(proximoProcessador);
	}
	
	@Override
	protected byte[] processar(byte[] bytes) {
		byte[] novoBytes = new byte[bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			novoBytes[i] = (byte) ((bytes[i] + 10) % Byte.MAX_VALUE);
		}
		return novoBytes;
	}

}
