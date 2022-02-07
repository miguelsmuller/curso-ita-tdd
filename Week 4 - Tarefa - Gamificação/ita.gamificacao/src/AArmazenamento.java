package src;

import java.util.ArrayList;
import java.util.List;

public abstract class AArmazenamento implements IArmazenamento {	
ArrayList<Ponto> _pointsRecords = new ArrayList<>();
	
	public AArmazenamento() {
		insertItens();
	}
	
	@Override
	public Boolean isEmpty() {
		return _pointsRecords.isEmpty();
	}

	@Override
	public int getSize() {
		return _pointsRecords.size();
	}

	@Override
	public void addPoint(Ponto ponto) {
		_pointsRecords.add(ponto);		
	}

	@Override
	public int getPointOfTypeFromUser(String user, String type) {
		int totalPoints = 0;
		for (Ponto ponto : _pointsRecords) {			
			if ((ponto.get_user().equals(user)) && (ponto.get_type().equals(type)))
					totalPoints += ponto.get_value();
		}
		return totalPoints;
	}

	
	@Override
	public List<String> getUsersWithPoints() {
		List<String> userWithPoints = new ArrayList<>();
		for (Ponto ponto : _pointsRecords) {
			if ((ponto.get_value() > 0) && !userWithPoints.contains(ponto.get_user()))
					userWithPoints.add(ponto.get_user());
		}
		return userWithPoints;
	}

	
	@Override
	public List<String> getPointsTypesFromUser(String user) {
		List<String> pointsTypesFromUser = new ArrayList<>();
		for (Ponto ponto : _pointsRecords) {
			if ((ponto.get_user().equals(user)) && !pointsTypesFromUser.contains(ponto.get_type()) && ponto.get_value() > 0)
				pointsTypesFromUser.add(ponto.get_type());
		}
		return pointsTypesFromUser;
	}
	
	private void insertItens() {
		addPoint(new Ponto("guerra", 20, "estrela"));
		addPoint(new Ponto("guerra", 5, "estrela"));
		addPoint(new Ponto("fernandes", 10, "estrela"));
		addPoint(new Ponto("fernandes", 9, "estrela"));
		addPoint(new Ponto("mula", 0, "estrela"));
		addPoint(new Ponto("rodrigo", 10, "estrela"));
		addPoint(new Ponto("rodrigo", 7, "estrela"));
		addPoint(new Ponto("guerra", 20, "moeda"));
	}

}
