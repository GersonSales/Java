package testes.adapter;

public class SmartPhone implements SMSSender{

	@Override
	public boolean sendSMS(SMS sms) {
		System.out.println("----SmartPhone----");
		System.out.println("Origem: " + sms.getOrigem());
		System.out.println("Destino: " + sms.getDestino());
		System.out.println("Mensagem: " +sms.getTexto());
		return true;
	}

}
