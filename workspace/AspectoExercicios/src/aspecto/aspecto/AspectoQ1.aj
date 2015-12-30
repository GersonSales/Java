package aspecto.aspecto;

import aspecto.exercicios.Cliente;

/*1: Crie um aspect que rastreia chamadas ao metodo setNome() da classe Cliente. 
 * Esse aspecto deve imprimir uma mensagem antes e apos as chamadas desse metodo, 
 * mostrando o ponto de juncao afetado. Use o Cross-Reference View. 
 * Depois faca a execucao do metodo setNome() da classe Cliente.
*/
public aspect AspectoQ1 {

	pointcut setNome() : execution(void Cliente.setNome(..));

	before() : setNome() {
		System.out.println("Antes do setNome()...");
	}

	after() : setNome() {
		System.out.println("Depois do setNome()...");
	}

}
