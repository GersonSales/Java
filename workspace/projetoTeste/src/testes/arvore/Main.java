package testes.arvore;

public class Main {
	public static void main(String[] args) {
		try {
			No<Integer> raiz = new No<>(10);
			No<Integer> no5 = new No<>(5);
			No<Integer> no1 = new No<>(1);
			No<Integer> no11 = new No<>(11);
			No<Integer> no8 = new No<>(8);
			No<Integer> no9 = new No<>(9);

			raiz.insere(no1);
			raiz.insere(no5);
			raiz.insere(no8);
			raiz.insere(no11);
			raiz.insere(no9);

			raiz.emOrdem();

		} catch (Exception erro) {
			erro.printStackTrace();
		}

	}
}
