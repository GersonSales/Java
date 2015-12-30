package aspecto.aspecto;

/*2: crie um advice que intercepte chamadas e execucoes de metodos construtores da classe Produto. 
 * Dentro desse advice, imprima uma mensagem indicando  que o aspecto interceptou esses metodos. 
 * Para testar a implementacao crie uma Classe com um metodo main e instancie objetos do tipo Produto.
 * Em seguida teste o joinPoint com o this e depois com o target.
 */
import aspecto.exercicios.Produto;

public aspect AspectoQ2 {

	pointcut intercep(Produto produto) : execution(Produto.new(..)) && target(produto);

	void around(Produto produto) : intercep(produto) {
		proceed(produto);
		System.out.println("Construtor interceptado! Preco alterado.");
		System.out.println("Antigo valor: " + produto.getPreco());
		produto.setPreco(produto.getPreco() + 1d);
		System.out.println("Novo valor: " + produto.getPreco());

	}
}
