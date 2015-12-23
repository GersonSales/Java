package testes.aspecto;

public class Main {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("unused")
			Pessoa gerson = new Pessoa(null);
		}catch(IllegalArgumentException erro) {
			erro.printStackTrace();
		}
	}
}
