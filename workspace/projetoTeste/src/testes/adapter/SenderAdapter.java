package testes.adapter;

public class SenderAdapter implements SMSSender {

	private EnviadorSMS enviadorSMS;

	public SenderAdapter(EnviadorSMS enviadorSMS) {
		this.enviadorSMS = enviadorSMS;
	}

	@Override
	public boolean sendSMS(SMS sms) {
		String origem = sms.getOrigem();
		String destino = sms.getDestino();
		String[] mensagem = sms.getTexto().split(" ");

		try {
			this.enviadorSMS.enviarSMS(origem, destino, mensagem);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

}
