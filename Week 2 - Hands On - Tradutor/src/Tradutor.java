
public class Tradutor {

	private String traducao;
	
	public Boolean estaVazio() {
		return(traducao == null);
	}

	public void adicionaTraducao(String palavra, String traducao) {
		this.traducao = traducao;
	}

	public Object traduzir(String palavra) {
		return traducao;
	}	
}
