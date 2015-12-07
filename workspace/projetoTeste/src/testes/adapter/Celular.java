package testes.adapter;

public class Celular implements EnviadorSMS {

	@Override
	public void enviarSMS(String origem, String destino, String[] mensagem) throws Exception {
		System.out.println("----celular----");
		System.out.println("Origem: " + origem);
		System.out.println("Destino: " + destino);
		System.out.println("Mensagem: " + mensagem);
	}
	

}
