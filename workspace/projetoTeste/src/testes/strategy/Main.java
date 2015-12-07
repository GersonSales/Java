package testes.strategy;

public class Main {
	public static void main(String[] args) {
		Loja loja = new Loja();
		loja.cadastrarItem(1.16, 540.12);

		Double valorFrete = loja.simularFrete("SEDEX");
		System.out.println("SEDEX :" + valorFrete);

		valorFrete = loja.simularFrete("ESEDEX");
		System.out.println("ESEDEX :" + valorFrete);

		valorFrete = loja.simularFrete("PAC");
		System.out.println("PAC: " + valorFrete);
		
	}

}
