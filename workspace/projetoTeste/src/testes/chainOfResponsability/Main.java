package testes.chainOfResponsability;

public class Main {
	public static void main(String[] args) {
		Processador procNulo = new ProcessadorNulo();
		Processador procCriptografado = new ProcessaCriptografado(procNulo);
		Processador procCompactado = new ProcessaCompactado(procCriptografado);
		
		
		byte[] bytes = new byte[1];
		procCompactado.processarCadeia(bytes);
		
	}
}
