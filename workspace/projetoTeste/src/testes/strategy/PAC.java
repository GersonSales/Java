package testes.strategy;

public class PAC implements CalculadorFrete {

	
	private static final Double TAXA_DISTANCIA = .10091723;
	private static final Double TAXA_PESO = 3.12;
	
	@Override
	public Double calculaFrete(Double peso, Double distancia) {
		return peso * TAXA_PESO + distancia * TAXA_DISTANCIA;
	}

}
