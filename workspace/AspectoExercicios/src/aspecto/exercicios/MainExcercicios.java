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
		main.excercicio2();

		

	}
	
	public void exercicio1() {
		Cliente gerson = new Cliente("Gerson");
		gerson.setNome("Gerson Sales");
		System.out.println(gerson.getNome());
	}
	
	public void excercicio2() {
		Produto caneta = new Produto("Caneta", 0.99d);
		System.out.println(caneta);
	}
}
