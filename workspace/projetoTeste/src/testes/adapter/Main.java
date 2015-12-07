package testes.adapter;

public class Main {
	public static void main(String[] args) throws Exception {
		EnviadorSMS celular = new Celular();
		SMSSender smartPhone = new SmartPhone();
		
		SMS sms = new SMS("origem", "destino", "texto");
		
		celular.enviarSMS("", "", "".split(""));
		smartPhone.sendSMS(sms);
		
		SenderAdapter smsAdapter = new SenderAdapter(celular);
		EnviadorAdapter enviadorAdapter = new EnviadorAdapter(smartPhone);
		
		enviadorAdapter.enviarSMS("origem", "destino", "mensagem".split(""));
		smsAdapter.sendSMS(sms);
		
		
		
	}
}
