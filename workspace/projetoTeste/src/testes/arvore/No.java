package testes.arvore;

public class No<Tipo> implements Comparable<No<Tipo>> {

	private Comparable<Tipo> valor;
	private No<Tipo> esquerda;
	private No<Tipo> direita;

	public No(Comparable<Tipo> valor) {
		this.valor = valor;
	}

	public Comparable<Tipo> getValor() {
		return this.valor;
	}

	public No<Tipo> getEsquerda() {
		return this.esquerda;
	}
	
	public void setEsquerda(No<Tipo> esquerda) {
		this.esquerda = esquerda;
	}
	
	public No<Tipo> getDireita() {
		return direita;
	}

	public void setDireita(No<Tipo> direita) {
		this.direita = direita;
	}

	public void insere(No<Tipo> novoNo) {
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

	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(No<Tipo> outroNo) {
		return getValor().compareTo((Tipo)outroNo.getValor());
	}

}