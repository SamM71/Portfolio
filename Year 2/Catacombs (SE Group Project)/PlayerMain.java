/**
 * Main class to test the implementation of the player class as it was developed 
 * @author Declan McGauley 984379
 * @version 1.0
 */
public class PlayerMain {
	
	/**
	 * tests the player code
	 * @param args
	 */
	public static void main(String[] args) {
		Gameboard gameBoard = new Gameboard();
		Profile profile = new Profile();
		
		//up test
		Player player = new Player(1, new int[] {1, 0}, profile);
		player.move(gameBoard, "up");
		
		
		//player.setNumberOfMoves(2);
		//player.move(gameBoard, "up");
		
	}
}

