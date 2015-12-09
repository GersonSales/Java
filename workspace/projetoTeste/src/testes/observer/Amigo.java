package testes.observer;

import java.util.ArrayList;
import java.util.List;

public class Amigo implements Observador {
	
	List<String> notificacoes;
	
	public Amigo() {
		this.notificacoes = new ArrayList<>();
	}

	@Override
	public void recebeNotificacao(String notificacao) {
		this.notificacoes.add(notificacao);
	}
	
	public String getNotificacoes() {
		StringBuilder sb = new StringBuilder();
		String fdl = System.getProperty("line.separator");
		for (String notificacao : notificacoes) {
			sb.append(notificacao);
			sb.append(fdl);
		}
		return sb.toString();
	}
	
	

}
