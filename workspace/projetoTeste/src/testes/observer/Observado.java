package testes.observer;

public interface Observado {

	public void adicionaObservador(Observador observador);

	public void removerObservador(Observador observador);

	public void notifica(String notificacao);

}
