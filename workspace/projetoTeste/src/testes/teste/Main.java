package testes.teste;

public class Main {
	
	public static void main(String[] args) {
		ClasseTeste<String> classeTeste = new ClasseTeste<>("Teste");
		
		System.out.println(classeTeste.getTeste());
		
		classeTeste.setTeste("NovoTeste");
		
		System.out.println(classeTeste.getTeste());
		
	}

}
