package testes.observer;

import java.util.ArrayList;
import java.util.List;

public class Usuario implements Observado {

	private List<Observador> observadores;
	private List<String> atividades;
	private String nome;

	public Usuario(String nome) {
		this.nome = nome;
		this.observadores = new ArrayList<>();
		this.atividades = new ArrayList<>();
	}

	@Override
	public void adicionaObservador(Observador observador) {
		this.observadores.add(observador);

	}

	public void fazerAtividade(String atividade) {
		String acao = getNome() + " realizou a atividade: " + atividade;
		this.atividades.add(acao);
		notifica(acao);
	}

	private String getNome() {
		return this.nome;
	}

	@Override
	public void notifica(String notificacao) {
		for (Observador observador : observadores) {
			observador.recebeNotificacao(notificacao);
		}
	}

	@Override
	public void removerObservador(Observador observador) {
		this.observadores.remove(observador);
	}
	
	
	public String getAtividades() {
		StringBuilder sb = new StringBuilder();
		String fdl = System.getProperty("line.separator");
		for (String atividade : atividades) {
			sb.append(atividade);
			sb.append(fdl);
		}
		return sb.toString();
	}

}
