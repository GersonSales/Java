package testes.arvore;

public class No implements Comparable<No> {

	private Comparable<Object> valor;
	private No esquerda;
	private No direita;

	public No(Comparable<Object> valor) {
		this.valor = valor;
	}

	public Comparable<Object> getValor() {
		return this.valor;
	}

	public No getEsquerda() {
		return this.esquerda;
	}
	
	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}
	
	public No getDireita() {
		return direita;
	}

	public void setDireita(No direita) {
		this.direita = direita;
	}

	public void insere(No novoNo) {
		if (compareTo(novoNo) > 0) {
			if (getEsquerda() != null) {
				getEsquerda().insere(novoNo);
			}else {
				setEsquerda(novoNo);
			}
		} else if (compareTo(novoNo) < 0) {
			if (getDireita() != null) {
				getDireita().insere(novoNo);
			}else {
				setDireita(novoNo);
			}
		} else {
			throw new IllegalArgumentException("Nao pode conter valores iguais!");
		}

	}
	
	
	public No buscaValor(Comparable<Object> valor) {
		if (getValor().compareTo(valor) > 0) {
			if (getEsquerda() != null) {
				return getEsquerda().buscaValor(valor);
			}
		}else if (getValor().compareTo(valor) == 0) {
			return this;
		}else {
			if (getDireita() != null) {
				return getDireita().buscaValor(valor);
			}
		}
		return null;
	}
	
	public void emOrdem() {
		if (getEsquerda() != null) {
			getEsquerda().emOrdem();
		}
		
		System.out.println(toString());
		
		if (getDireita() != null) {
			getDireita().emOrdem();
		}
		
	}

	@Override
	public String toString() {
		return "(" + getValor() + ")";
	}

	@Override
	public int compareTo(No outroNo) {
		return getValor().compareTo(outroNo.getValor());
	}

}