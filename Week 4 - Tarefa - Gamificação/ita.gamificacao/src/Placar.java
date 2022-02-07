package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Placar {
	private IArmazenamento _storage;
	
	public Placar(IArmazenamento armazenamento) {
		_storage = armazenamento;
	}

	public void addPoint(Ponto ponto) {
		_storage.addPoint(ponto);
	}

	public boolean isEmpty() {
		return _storage.isEmpty();
	}

	public Object getSize() {
		return _storage.getSize();
	}

	
	public List<Ponto> GetSumFromAllTypesPointsFromUser(String user) {
		List<Ponto> somaDePontosDeTodosOsTiposDoUsuarioInformado = new ArrayList<Ponto>();
		
		List<String> ListaDeTiposDePontos = _storage.getPointsTypesFromUser(user);
		
		for (String tipoDePonto : ListaDeTiposDePontos) {
			int somaDePontos = _storage.getPointOfTypeFromUser(user, tipoDePonto);
			
			Ponto PontoUnico = new Ponto(user, somaDePontos, tipoDePonto);
			somaDePontosDeTodosOsTiposDoUsuarioInformado.add(PontoUnico);
		}
		
		return somaDePontosDeTodosOsTiposDoUsuarioInformado;
	}

	public List<Ponto> GetRankingOfPointType(String type) {
		List<Ponto> rankingDeUsuariosEmUmDeterminadoPonto = new ArrayList<Ponto>();
		
		List<String> listaDeUsuariosComPontos = _storage.getUsersWithPoints();
		
		for (String usuarioComPonto : listaDeUsuariosComPontos) {
			int pontos = _storage.getPointOfTypeFromUser(usuarioComPonto, type);
			
			if (pontos > 0)
				rankingDeUsuariosEmUmDeterminadoPonto.add(new Ponto(usuarioComPonto, pontos, type));
		}
		
		Collections.sort(rankingDeUsuariosEmUmDeterminadoPonto, Collections.reverseOrder());   
		
		return rankingDeUsuariosEmUmDeterminadoPonto;
	}
}
