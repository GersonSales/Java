package lp2.lab02;

public class Menu {
	private static final int COMPRA = 1;
	private static final int MUDAR = 2;
	private static final int SAIR = 3;

	public static void main(String[] args) {
		entradaUsuario();
		IO.imprimeMensagempl("FIM");

	}

	public static void imprimeMenu() {
		IO.imprimeMensagempl("Menu de comrpa");
		IO.imprimeMensagempl("Digite a opcao:");
		IO.imprimeMensagempl("1 - Realizar compra");
		IO.imprimeMensagempl("2 - Mudar preco base");
		IO.imprimeMensagempl("3 - Sair");
	}

	public static void entradaUsuario() {
		int opcao;

		do {
			imprimeMenu();
			opcao = IO.leInteiro();
			switch (opcao) {
			case COMPRA:
				LojaoP2.menuCompra();
				break;
			case MUDAR:
				LojaoP2.menuPrecoBase();
				break;
			case SAIR:
				IO.imprimeMensagempl("Sair");
				break;
			default:
				IO.imprimeMensagempl("Opcao invalida");
				break;
			}
		} while (opcao != 4);
	}
}
