package testes.doubleDipatch;

import java.util.HashMap;
import java.util.Map;


public class Carrinho {

	Map<String, String> produtos;

	public Carrinho() {
		this.produtos = new HashMap<>();
	}

	public void addProduto(Produto produto) {
		produtos.put(produto.getNome(), "");
		produto.addCaracteristicas(this);

	}

	public void adicionaCaracteristicas(String produto, String caracteristica) {
		produtos.put(produto, caracteristica);
	}

	public void imprimeCarrinho() {
		for (String produto : this.produtos.keySet()) {
			System.out.println(produto + " " + this.produtos.get(produto));
		}
	}

}
