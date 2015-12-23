package testes.aspecto;

public class Main {
	public static void main(String[] args) {
		try {
			Pessoa gerson = new Pessoa(null);
			System.out.println(gerson.getNome());
			gerson.setNome(null);
		}catch(IllegalArgumentException erro) {
			System.out.println(erro.getMessage());
		}
	}
}
