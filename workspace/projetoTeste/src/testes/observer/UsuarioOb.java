package testes.observer;

import java.util.ArrayList;
import java.util.List;

public class UsuarioOb implements Observado, Observador{
	
	private List<Observador> observadores;
	private List<String> notificacoes;
	private List<String> atividades;
	private String nome;
	
	public UsuarioOb(String nome) {
		this.nome = nome;
		this.observadores = new ArrayList<>();
		this.notificacoes= new ArrayList<>();
		this.atividades = new ArrayList<>();

	}

	@Override
	public void recebeNotificacao(String notificacao) {
		this.notificacoes.add(notificacao);
	}

	@Override
	public void adicionaObservador(Observador observador) {
		this.observadores.add(observador);
	}

	@Override
	public void removerObservador(Observador observador) {
		this.observadores.remove(observador);
	}

	@Override
	public void notifica(String notificacao) {
		for (Observador observador : observadores) {
			observador.recebeNotificacao(notificacao);
		}
	}


	public void fazerAtividade(String atividade) {
		String acao = getNome() + " realizou a atividade: " + atividade;
		this.atividades.add(acao);
		notifica(acao);
	}
	private String getNome() {
		return this.nome;
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
