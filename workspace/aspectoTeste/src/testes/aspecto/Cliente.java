package testes.aspecto;


import org.junit.Assert;
import org.junit.Test;

public class Cliente {

	@Test 
	public void criacaoPessoa() {
		try {
			//@SuppressWarnings("unused")
			Pessoa gerson = new Pessoa(null, 20);
			System.out.println(gerson);
			Assert.fail();
		}catch (Exception erro){ 
			Assert.assertEquals("Nome nao pode ser nulo!", erro.getMessage());
			
		}
		
		
		try {
			@SuppressWarnings("unused")
			Pessoa gerson = new Pessoa("Gerson", null);
			Assert.fail();
		}catch(Exception erro) {
			Assert.assertEquals("Idade nao pode ser nulo!", erro.getMessage());

		}
		
		try {
			@SuppressWarnings("unused")
			Pessoa gerson = new Pessoa("Gerson", -20);
			Assert.fail();
		}catch (Exception erro){ 
			Assert.assertEquals("Idade nao pode ser negativo!", erro.getMessage());
			
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
