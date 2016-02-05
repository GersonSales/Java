package lp2.lab02;

public class LojaoP2 {
	private static String[] produtosComprados;
	private static double[] precoProdutos;
	private static int[] qtdProdutos;
	private static double precoBase = 1.99;

	public static void menuCompra() {
		IO.imprimeMensagempl("Digite quantos itens deseja comprar:");
		int qtdItens = IO.leInteiro();
		for (int i = 0; i < qtdItens; i++) {
			
			
			
			IO.imprimeMensagempl("comprando item: " + i);
		}
	}

	public static void menuPrecoBase() {
		IO.imprimeMensagempl("Digite o novo preco base dos itens");
		precoBase = IO.leDoube();
	}
	
	
	private static void compraItem() {
		IO.imprimeMensagem("Nome do produto:" );
		IO.leString();
		
		IO.imprimeMensagem("Quantidade do produto: ");
	}

}
