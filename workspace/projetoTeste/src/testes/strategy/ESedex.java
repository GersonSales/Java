package testes.strategy;

public class ESedex implements CalculadorFrete {

	
	private static final Double TAXA_DISTANCIA = 0.41725366;
	private static final Double TAXA_PESO = 3.565;
	private static final Double TAXA_ESEDEX = 12.235;
	
	@Override
	public Double calculaFrete(Double peso, Double distancia) {
		return peso * TAXA_PESO + distancia * TAXA_DISTANCIA + TAXA_ESEDEX;
	}

}
