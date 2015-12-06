package testes.composite;

public class Main {
	public static void main(String[] args) {
		TrechoAereo sPauloBrasilia = new TrechoAereoSimples("Sao Paulo", "Brasilia", 500d);
		TrechoAereo brasiliaRecife = new TrechoAereoSimples("Brasilia", "Recife", 300d);
		
		TrechoAereo conexaospdfre = new TrechoAereoComposto(sPauloBrasilia, brasiliaRecife, 30d);
		
		TrechoAereo recifeNatal = new TrechoAereoSimples("Recife", "Natal", 350d);
		
		TrechoAereo conexaocnrena = new TrechoAereoComposto(conexaospdfre, recifeNatal, 120d);
		
		System.out.println("Preco SP-DF: " + sPauloBrasilia.getPreco()); //Preco SP-DF: 500.0
		
		System.out.println("Preco DF-PE: " + brasiliaRecife.getPreco()); //Preco DF-PE: 300.0
		
		System.out.println("Preco SP-DF-PE: " + conexaospdfre.getPreco()); //Preco SP-DF-PE: 830.0
		
		System.out.println("Preco SP-DF-PE-RN: " + conexaocnrena.getPreco()); //Preco SP-DF-PE-RN: 1300.0
		
	}
}
