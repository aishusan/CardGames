import java.util.List;

public interface Game {
	public int compare(List<Hand> hands);
	public void dealCards(List<Hand> hands);
}
