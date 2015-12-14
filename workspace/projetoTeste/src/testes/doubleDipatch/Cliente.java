package testes.doubleDipatch;

public class Cliente {
	public static void main(String[] args) {
		Carrinho carrinho = new Carrinho();
		Produto computador = new Computador("Computador", "Core i3", 900d);

		carrinho.imprimeCarrinho();

		carrinho.addProduto(computador);

		carrinho.imprimeCarrinho();
	}
}
