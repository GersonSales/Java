package aspecto.aspecto;

/*3: Crie um aspecto para adicionar os atributos 'codigo' e 'endereco' e seus respectivos 
 * metodos get e set a classe Cliente por meio do mecanismo inter-Type declarations. 
 * Para testar a implementacao crie uma classe com o metodo main, 
 * instancie um objeto do tipo Cliente e inclua uma chamada a um metodo get ou set 
 * relacionado aos atributos 'codigo' e 'endereco'
 */

import aspecto.exercicios.Cliente;

public aspect AspectoQ3 {

	private String Cliente.codigo;
	private String Cliente.endereco;

	public String Cliente.getCodigo() {
		return this.codigo;
	}
	
	public String Cliente.getEndereco() {
		return this.endereco;
	}
	
	public void Cliente.setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void Cliente.setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
	

}
