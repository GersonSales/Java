package testes.adapter;

public class EnviadorAdapter implements EnviadorSMS{
	
	private SMSSender smsSender;
	
	public EnviadorAdapter(SMSSender smsSender) {
		this.smsSender = smsSender;
	}

	@Override
	public void enviarSMS(String origem, String destino, String[] mensagem) throws Exception {
		String texto = "";
		for (String string : mensagem) {
			texto = texto + string + " ";
		}
		
		SMS sms = new SMS(origem, destino, texto);
		
		if(!this.smsSender.sendSMS(sms)) {
			throw new Exception("A mensagem nao foi enviada!");
		}
		
		
		
	}

}
