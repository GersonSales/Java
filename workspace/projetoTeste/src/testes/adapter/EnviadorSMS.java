package testes.adapter;

public interface EnviadorSMS {
	public void enviarSMS(String origem, String destino, String[] mensagem) throws Exception;
}
