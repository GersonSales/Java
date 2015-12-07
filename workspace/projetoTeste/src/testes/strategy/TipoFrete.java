package testes.strategy;

public enum TipoFrete {

	SEDEX {
		@Override
		public Double calcularFrete(Double peso, Double distancia) {
			return new Sedex().calculaFrete(peso, distancia);
		}
	},
	PAC {
		@Override
		public Double calcularFrete(Double peso, Double distancia) {
			return new PAC().calculaFrete(peso, distancia);
		}
	},
	ESEDEX {
		@Override
		public Double calcularFrete(Double peso, Double distancia) {
			return new ESedex().calculaFrete(peso, distancia);
		}
	};

	public abstract Double calcularFrete(Double peso, Double distancia);

}
