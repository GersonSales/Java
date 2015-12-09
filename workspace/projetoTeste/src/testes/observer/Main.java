package testes.observer;

public class Main {
	public static void main(String[] args) {
		Usuario luis = new Usuario("Luis");

		Amigo antonio = new Amigo();
		Amigo felipe = new Amigo();
		
		luis.adicionaObservador(felipe);
		luis.adicionaObservador(antonio);
		
		luis.fazerAtividade("Jogar video-game");
		
		System.out.println("<Luis: \n" + luis.getAtividades() + ">");
		System.out.println("<Antonio: \n" + antonio.getNotificacoes() + ">");
		System.out.println("<Felipe: \n" +felipe.getNotificacoes() + ">");

		System.out.println("-----");
		
		luis.removerObservador(felipe);
		
		luis.fazerAtividade("jogar basquete");
		
		System.out.println("<Luis: \n" + luis.getAtividades() + ">");
		System.out.println("<Antonio: \n" + antonio.getNotificacoes() + ">");
		System.out.println("<Felipe: \n" +felipe.getNotificacoes() + ">");
		
		System.out.println("-----------------------------------");
		
		UsuarioOb maria = new UsuarioOb("Maria");
		UsuarioOb luiza = new UsuarioOb("Luiza");
		UsuarioOb marcos = new UsuarioOb("Marcos");
		
		maria.adicionaObservador(marcos);
		maria.adicionaObservador(luiza);
		
		maria.fazerAtividade("Comer");
		
		System.out.println("<Maria: \n" + maria.getAtividades() + ">");
		System.out.println("<Luiza: \n" + luiza.getNotificacoes() + ">");
		System.out.println("<Marcos: \n" +marcos.getNotificacoes() + ">");
		
		

		
		
		

	}
}
