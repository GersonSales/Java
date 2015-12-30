package aspecto.exercicios;

public class MainExcercicios {
	public MainExcercicios() {
	}
	
	public static void main(String[] args) {
		MainExcercicios main = new MainExcercicios();
		
		System.out.println("exercicio1: ");
		main.exercicio1();
		
		System.out.println();
		
		System.out.println("exercicio2: ");
		main.exercicio2();
		
		System.out.println();
		
		System.out.println("exercicio3: ");
		main.exercicio3();

		

	}
	
	public void exercicio1() {
		Cliente gerson = new Cliente("Gerson");
		gerson.setNome("Gerson Sales");
		System.out.println(gerson.getNome());
	}
	
	public void exercicio2() {
		Produto caneta = new Produto("Caneta", 0.99d);
		System.out.println(caneta);
	}
	
	
	public void exercicio3() {
		Cliente gerson = new Cliente("Gerson");
		gerson.setCodigo("1234");
		gerson.setEndereco("r: Dias Goncalves");
		
		System.out.println(gerson.getCodigo());
		System.out.println(gerson.getEndereco());
		
	}
}
