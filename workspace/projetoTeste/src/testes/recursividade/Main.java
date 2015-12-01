package testes.recursividade;

public class Main {
	public static int fatorial(int num) {
		return num == 0 ? 1 : fatorial(num - 1) * num;
	}
	
	public static double pot(double a, double b) {
		return b == 0? 1 : pot(a, b - 1) * a;
	}

	public static void main(String[] args) {
		System.out.println(fatorial(5));
		System.out.println(pot(10, 300));
	}
}
