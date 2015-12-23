package testes.aspecto;


import org.junit.Assert;
import org.junit.Test;

public class Cliente {

	@Test 
	public void criacaoPessoa() {
		try {
			@SuppressWarnings("unused")
			Pessoa gerson = new Pessoa(null, 20);
			Assert.fail();
		}catch (Exception erro){ 
			Assert.assertEquals("Nao pode ser nulo!", erro.getMessage());
			
		}
		
		
		try {
			@SuppressWarnings("unused")
			Pessoa gerson = new Pessoa("Gerson", null);
			Assert.fail();
		}catch(Exception erro) {
			Assert.assertEquals("Nao pode ser nulo!", erro.getMessage());

		}
		
		try {
			@SuppressWarnings("unused")
			Pessoa gerson = new Pessoa("Gerson", -20);
			Assert.fail();
		}catch (Exception erro){ 
			Assert.assertEquals("Nao pode ser negativo!", erro.getMessage());
			
		}
		
		try {
			Pessoa gerson = new Pessoa("Gerson", 20);
			Assert.assertEquals("Gerson", gerson.getNome());
			Assert.assertEquals(20, (int)gerson.getIdade());
		}catch (Exception erro){
			Assert.fail();
			
		}
	}
	
}
