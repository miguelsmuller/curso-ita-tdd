public class Pilha {
	
	private Object[] elementos;
	private int quantidade = 0;

	public Pilha(int maximo) {
		elementos = new Object[maximo];
	}

	public boolean estaVazia() {
		return quantidade == 0;
	}

	public int tamanho() {
		return quantidade;
	}
	
	public Object topo() {
		return elementos[quantidade - 1 ];
	}

	public void empilha(Object elemento) {
		if(quantidade == elementos.length) {
			throw new PilhaCheiaExcepetion("Não é possivel empilhar");
		}
		
		elementos[quantidade] = elemento;
		quantidade++;
	}

	public Object desempilha() {
		if(estaVazia()) {
			throw new PilhaVaziaExcepetion("Não é possivel desempilhar");
		}
		
		Object topo = topo();
		quantidade--;
		return topo;
	}

}
