package src;

import java.util.List;

public interface IArmazenamento {
	public Boolean isEmpty();
	public int getSize();
	public void addPoint(Ponto ponto);
	public int getPointOfTypeFromUser(String user, String type);
	public List<String> getUsersWithPoints();
	public List<String> getPointsTypesFromUser(String user);
}
