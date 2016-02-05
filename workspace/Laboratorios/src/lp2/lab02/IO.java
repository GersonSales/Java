package lp2.lab02;

import java.util.Scanner;

public class IO {
	
	private static Scanner entrada = new Scanner(System.in);
	
	
	public static String leString() {
		return entrada.nextLine();
	}
	
	public static int leInteiro() {
		int numero = entrada.nextInt();
		leString();
		return numero;
	}
	
	public static double leDoube() {
		double numero = entrada.nextDouble();
		leString();
		return numero;
	}
	
	public static void imprimeMensagempl(String mensagem) {
		System.out.println(mensagem);
	}
	
	public static void imprimeMensagem(String mensagem) {
		System.out.print(mensagem);
	}
	

}
