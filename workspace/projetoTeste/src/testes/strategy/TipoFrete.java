package testes.strategy;

public enum TipoFrete {
	
	SEDEX {
		@Override
		public CalculadorFrete calculadorFrete() {
			return new Sedex();
		}
	}, PAC {
		@Override
		public CalculadorFrete calculadorFrete() {
			return new PAC();
		}
	}, ESEDEX {
		@Override
		public CalculadorFrete calculadorFrete() {
			return new ESedex();
		}
	};
	
	public abstract CalculadorFrete calculadorFrete();

}
