package testes.strategy;

public class Sedex implements CalculadorFrete{
	
	private static final Double TAXA_DISTANCIA = .21238712937;
	private static final Double TAXA_PESO = 2.221;
	private static final Double TAXA_SEDEX = 6.151;

	@Override
	public Double calculaFrete(Double peso, Double distancia) {
		return peso * TAXA_PESO + distancia * TAXA_DISTANCIA + TAXA_SEDEX;
	}

}
